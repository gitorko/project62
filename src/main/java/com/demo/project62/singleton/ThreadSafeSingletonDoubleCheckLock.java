package com.demo.project62.singleton;

public class ThreadSafeSingletonDoubleCheckLock {

    private static ThreadSafeSingletonDoubleCheckLock instance;

    private ThreadSafeSingletonDoubleCheckLock() {
    }

    public static void main(String[] args) {
        System.out.println(ThreadSafeSingletonDoubleCheckLock.getInstance().hello());
    }

    public static ThreadSafeSingletonDoubleCheckLock getInstance() {
        if (instance == null) {
            synchronized (ThreadSafeSingletonDoubleCheckLock.class) {
                if (instance == null) {
                    instance = new ThreadSafeSingletonDoubleCheckLock();
                }
            }

        }
        return instance;
    }

    public String hello() {
        return ("Hello from ThreadSafeSingleton!");
    }
}