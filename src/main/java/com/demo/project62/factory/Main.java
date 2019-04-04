package com.demo.project62.factory;

enum AnimalType {
    DOG, DUCK, CAT;
}

interface Animal {
    public String sound();
}

public class Main {

    public static void main(String[] args) {
        Animal animal = Factory.getAnimal(AnimalType.CAT);
        System.out.println(animal.sound());
    }
}

class Duck implements Animal {

    @Override
    public String sound() {
        return "Quak!";
    }
}

class Dog implements Animal {

    @Override
    public String sound() {
        return "Bark!";
    }
}

class Cat implements Animal {

    @Override
    public String sound() {
        return "Meow!";
    }
}

class Factory {
    public static Animal getAnimal(AnimalType type) {
        switch (type) {
            case DOG:
                return new Dog();
            case CAT:
                return new Cat();
            case DUCK:
                return new Duck();
            default:
                return null;
        }
    }
}
