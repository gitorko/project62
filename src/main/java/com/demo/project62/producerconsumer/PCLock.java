package com.demo.project62.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PCLock {
    public static void main(String[] args) {

        MyBlockingQueue<String> queue = new MyBlockingQueue<>();
        ExecutorService executor = Executors.newFixedThreadPool(10);

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

        executor.submit(producer);
        executor.submit(consumer);
    }
}

class MyBlockingQueue<E> {
    private Queue<E> queue = new LinkedList<>();
    private int max = 10;
    private Lock lock = new ReentrantLock(true);
    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();

    public void put(E e) {
        lock.lock();
        try {
            if (queue.size() == max) {
                notFull.await();
            }
            queue.add(e);
            notEmpty.signalAll();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public E take() {
        lock.lock();
        try {
            while (queue.size() == 0) {
                notEmpty.await();
            }
            E item = queue.remove();
            notFull.signalAll();
            return item;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        } finally {
            lock.unlock();
        }
    }

}
