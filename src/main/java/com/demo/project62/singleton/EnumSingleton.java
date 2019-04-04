package com.demo.project62.singleton;

public enum EnumSingleton {

    INSTANCE;

    public static void main(String[] args) {
        System.out.println(EnumSingleton.INSTANCE.hello());
    }

    public String hello() {
        return ("Hello from EnumSingleTon!");
    }

}
