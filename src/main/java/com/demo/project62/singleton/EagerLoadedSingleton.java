package com.demo.project62.singleton;

public class EagerLoadedSingleton {

    private static final EagerLoadedSingleton instance = new EagerLoadedSingleton();

    private EagerLoadedSingleton() {
    }

    public static void main(String[] args) {
        System.out.println(EagerLoadedSingleton.getInstance().hello());
    }

    public static EagerLoadedSingleton getInstance() {
        return instance;
    }

    public String hello() {
        return ("Hello from EagerLoadedSingleton!");
    }
}
