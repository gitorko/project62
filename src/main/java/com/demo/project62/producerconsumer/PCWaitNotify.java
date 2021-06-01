package com.demo.project62.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;

public class PCWaitNotify {

    public static void main(String[] args) {
        MyBlockingQueue2<String> queue = new MyBlockingQueue2<>();
        final Runnable producer = () -> {
            for (int i = 0; i < 20; i++) {
                queue.put(String.valueOf(i));
                System.out.println("Published: " + i);
            }
        };

        final Runnable consumer = () -> {
            while (true) {
                System.out.println("Consumed: " + queue.take());
            }
        };

        new Thread(producer).start();
        new Thread(consumer).start();
    }
}

class MyBlockingQueue2<E> {
    private Queue<E> queue = new LinkedList<>();
    private int max = 10;

    public void put(E e) {
        synchronized (queue) {
            try {
                if (queue.size() == max) {
                    queue.wait();
                }
                queue.add(e);
                queue.notifyAll();
                ;
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    public E take() {
        synchronized (queue) {
            try {
                while (queue.size() == 0) {
                    queue.wait();
                }
                E item = queue.remove();
                queue.notifyAll();
                return item;
            } catch (InterruptedException e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}
