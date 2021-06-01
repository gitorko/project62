package com.demo.project62.scattergather.latch;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

public class ScatterGatherLatch {

    ExecutorService threadPool = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        Map<String, Float> book1Prices = new ScatterGatherLatch().getPrices("book1");
        System.out.println(book1Prices);
    }

    @SneakyThrows
    private Map<String, Float> getPrices(String productId) {
        Map<String, Float> prices = new ConcurrentHashMap<>();
        CountDownLatch latch = new CountDownLatch(3);
        threadPool.submit(new FetchData("http://amazon", productId, prices, latch));
        threadPool.submit(new FetchData("http://ebay", productId, prices, latch));
        threadPool.submit(new FetchData("http://flipkart", productId, prices, latch));
        latch.await(3, TimeUnit.SECONDS);
        threadPool.shutdown();
        return prices;
    }

    @AllArgsConstructor
    class FetchData implements Runnable {

        String url;
        String productId;
        Map<String, Float> prices;
        CountDownLatch latch;

        @SneakyThrows
        @Override
        public void run() {
            if (url.contains("amazon")) {
                //http fetch from amazon
                System.out.println("Fetching price from amazon!");
                TimeUnit.SECONDS.sleep(2);
                prices.put("amazon", 2.35f);
                latch.countDown();
            }

            if (url.contains("ebay")) {
                System.out.println("Fetching price from ebay!");
                //http fetch from ebay
                TimeUnit.SECONDS.sleep(4);
                prices.put("ebay", 2.30f);
                latch.countDown();
            }

            if (url.contains("flipkart")) {
                System.out.println("Fetching price from flipkart!");
                //http fetch from flipkart
                TimeUnit.SECONDS.sleep(1);
                prices.put("flipkart", 2.10f);
                latch.countDown();
            }
        }
    }
}

