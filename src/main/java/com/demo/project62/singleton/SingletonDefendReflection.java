package com.demo.project62.singleton;

public class SingletonDefendReflection {

    private static volatile SingletonDefendReflection instance;

    private SingletonDefendReflection() {
        if (instance != null) {
            throw new RuntimeException("Use get instance to create object!");
        }
    }

    public static void main(String[] args) {
        System.out.println(SingletonDefendReflection.getInstance().hello());
    }

    public static SingletonDefendReflection getInstance() {
        if (instance == null) {
            synchronized (SingletonDefendReflection.class) {
                if (instance == null) {
                    instance = new SingletonDefendReflection();
                }
            }
        }
        return instance;
    }

    public String hello() {
        return ("Hello from ThreadSafeSingleton!");
    }
}
