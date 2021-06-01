package com.demo.project62.scattergather.invoke;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

public class ScatterGatherInvoke {
    ExecutorService threadPool = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        Map<String, Float> book1Prices = new ScatterGatherInvoke().getPrices("book1");
        System.out.println(book1Prices);
    }

    @SneakyThrows
    private Map<String, Float> getPrices(String productId) {
        Map<String, Float> prices = new ConcurrentHashMap<>();
        List<Callable<Void>> tasks = new ArrayList<>();

        tasks.add(new FetchData("http://amazon", productId, prices));
        tasks.add(new FetchData("http://ebay", productId, prices));
        tasks.add(new FetchData("http://flipkart", productId, prices));
        threadPool.invokeAll(tasks, 3, TimeUnit.SECONDS);
        threadPool.shutdown();
        return prices;
    }

    @AllArgsConstructor
    class FetchData implements Callable<Void> {

        String url;
        String productId;
        Map<String, Float> prices;

        @Override
        @SneakyThrows
        public Void call() throws Exception {
            if (url.contains("amazon")) {
                //http fetch from amazon
                System.out.println("Fetching price from amazon!");
                TimeUnit.SECONDS.sleep(2);
                prices.put("amazon", 2.35f);
            }

            if (url.contains("ebay")) {
                System.out.println("Fetching price from ebay!");
                //http fetch from ebay
                TimeUnit.SECONDS.sleep(4);
                prices.put("ebay", 2.30f);
            }

            if (url.contains("flipkart")) {
                System.out.println("Fetching price from flipkart!");
                //http fetch from flipkart
                TimeUnit.SECONDS.sleep(1);
                prices.put("flipkart", 2.10f);
            }
            return null;
        }
    }
}


