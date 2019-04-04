package com.demo.project62.singleton;

public class StaticBlockSingleton {

    private static final StaticBlockSingleton instance;

    static {
        try {
            instance = new StaticBlockSingleton();
        } catch (Exception e) {
            throw new RuntimeException("Exception occured in creatingsingleton instance");
        }
    }

    private StaticBlockSingleton() {
    }

    public static void main(String[] args) {
        System.out.println(StaticBlockSingleton.getInstance().hello());
    }

    public static StaticBlockSingleton getInstance() {
        return instance;
    }

    public String hello() {
        return ("Hello from StaticBlockSingleton!");
    }
}
