package com.demo.project62.producerconsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProduceConsumer {

    public static void main(String[] args) {
        // BlockingQueue<String> queue = new SynchronousQueue<>();
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(10);

        final Runnable producer = () -> {
            for (int i = 0; i < 20; i++) {
                try {
                    queue.put(String.valueOf(i));
                    System.out.println("Published: " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        final Runnable consumer = () -> {
            while (true) {
                try {
                    System.out.println("Consumed" + queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(producer).start();
        new Thread(consumer).start();
        System.out.println("Producer and Consumer has been started");
    }
}
