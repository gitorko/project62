package com.demo.project62.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializedSingleton implements Serializable {

    private static final long serialVersionUID = -1L;

    private SerializedSingleton() {
    }

    public static void main(String[] args) throws Exception {

        SerializedSingleton instanceOne = SerializedSingleton.getInstance();
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream("filename.ser"));
        out.writeObject(instanceOne);
        out.close();

        ObjectInput in = new ObjectInputStream(new FileInputStream("filename.ser"));
        SerializedSingleton instanceTwo = (SerializedSingleton) in.readObject();
        in.close();
        if (instanceOne.hashCode() != instanceTwo.hashCode()) {
            System.out.println("Singleton broken!");
        } else {
            System.out.println(instanceOne.getInstance().hello());
        }

    }

    public static SerializedSingleton getInstance() {
        return SingletonHelper.instance;
    }

    public String hello() {
        return ("Hello from singleton!");
    }

    protected Object readResolve() {
        return getInstance();
    }

    private static class SingletonHelper {
        private static final SerializedSingleton instance = new SerializedSingleton();
    }

}
