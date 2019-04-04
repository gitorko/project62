package com.demo.project62.singleton;

public class RuntimeSingleton {
    public static void main(String[] args) {
        Runtime singleton1 = Runtime.getRuntime();
        singleton1.gc();
        Runtime singleton2 = Runtime.getRuntime();
        if (singleton1 == singleton2) {
            System.out.println("Singleton!");
        } else {
            System.out.println("Not Singleton!");
        }
    }
}
