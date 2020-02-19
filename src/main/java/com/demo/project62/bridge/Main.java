package com.demo.project62.bridge;

import lombok.AllArgsConstructor;

//Decouple an abstraction from its implementation so that the two can vary independently
interface Color {
    public void applyColor();
}

public class Main {

    public static void main(String[] args) {
        Shape tri = new Triangle(new RedColor());
        tri.applyColor();
        Shape sqr = new Square(new GreenColor());
        sqr.applyColor();
    }

}

class GreenColor implements Color {
    @Override
    public void applyColor() {
        System.out.println("green!");
    }
}

class RedColor implements Color {
    public void applyColor() {
        System.out.println("red!");
    }
}

@AllArgsConstructor
abstract class Shape {

    protected Color color;

    public abstract void applyColor();
}

class Square extends Shape {

    public Square(Color c) {
        super(c);
    }

    @Override
    public void applyColor() {
        System.out.print("Square filled with color ");
        color.applyColor();
    }
}

class Triangle extends Shape {

    public Triangle(Color c) {
        super(c);
    }

    @Override
    public void applyColor() {
        System.out.print("Triangle filled with color ");
        color.applyColor();
    }
}
