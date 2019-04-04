package com.demo.project62.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class BreakSingletonByReflection {

    public static void main(String[] args) {
        new BreakSingletonByReflection().testSingleton();
    }

    public void testSingleton() {

        ThreadSafeSingletonDoubleCheckLock instanceOne = ThreadSafeSingletonDoubleCheckLock.getInstance();
        ThreadSafeSingletonDoubleCheckLock instanceTwo = null;
        try {
            Constructor[] constructors = ThreadSafeSingletonDoubleCheckLock.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                constructor.setAccessible(true);
                instanceTwo = (ThreadSafeSingletonDoubleCheckLock) constructor.newInstance();
                break;
            }
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException ex) {
            ex.printStackTrace();
        }
        if (instanceOne.hashCode() != instanceTwo.hashCode()) {
            System.out.println("Singleton broken!");
        }
    }
}
