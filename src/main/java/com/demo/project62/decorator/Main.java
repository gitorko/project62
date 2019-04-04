package com.demo.project62.decorator;

import lombok.AllArgsConstructor;

interface Car {

    public void assemble();
}

public class Main {

    public static void main(String[] args) {
        Car sportsCar = new SportsCar(new BasicCar());
        sportsCar.assemble();
        System.out.println("--------------------------");
        Car sportsLuxuryCar = new SportsCar(new LuxuryCar(new BasicCar()));
        sportsLuxuryCar.assemble();
    }

}

class BasicCar implements Car {

    @Override
    public void assemble() {
        System.out.println("Basic Car assembled.");
    }
}

@AllArgsConstructor
abstract class CarDecorator implements Car {

    protected Car car;

    @Override
    public void assemble() {
        this.car.assemble();
        System.out.println("Default features added as no specific feature requested!");
    }

}

class LuxuryCar extends CarDecorator {

    public LuxuryCar(Car c) {
        super(c);
    }

    @Override
    public void assemble() {
        car.assemble();
        System.out.println("Adding features of Luxury Car.");
    }

}

class SportsCar extends CarDecorator {

    public SportsCar(Car c) {
        super(c);
    }

    @Override
    public void assemble() {
        car.assemble();
        System.out.println("Adding features of Sports Car.");
    }

}
