package com.demo.project62.singleton;

public class LazyLoadedSingleton {

    private static LazyLoadedSingleton instance;

    private LazyLoadedSingleton() {
    }

    public static void main(String[] args) {
        System.out.println(LazyLoadedSingleton.getInstance().hello());
    }

    public static LazyLoadedSingleton getInstance() {
        if (instance == null) {
            instance = new LazyLoadedSingleton();
        }
        return instance;
    }

    public String hello() {
        return ("Hello from LazyLoadedSingleton!");
    }
}
