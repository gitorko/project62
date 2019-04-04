package com.demo.project62.singleton;


public class BillPughSingleton {

    private BillPughSingleton() {
    }

    public static void main(String[] args) {
        BillPughSingleton.getInstance().hello();
    }

    public static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public String hello() {
        return "Hello from BillPughSingleton";
    }

    private static class SingletonHelper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }
}
