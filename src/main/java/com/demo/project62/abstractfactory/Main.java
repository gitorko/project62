package com.demo.project62.abstractfactory;

interface Animal {
    public String sound();
}

interface BaseFactory {
    public Animal createAnimal();
}

public class Main {

    public static void main(String[] args) {
        Animal animal = AbstractFactory.getAnimal(new DogFactory());
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

class AbstractFactory {
    public static Animal getAnimal(BaseFactory bf) {
        return bf.createAnimal();
    }
}

class DuckFactory implements BaseFactory {
    @Override
    public Animal createAnimal() {
        return new Duck();
    }
}

class DogFactory implements BaseFactory {
    @Override
    public Animal createAnimal() {
        return new Dog();
    }
}

class CatFactory implements BaseFactory {
    @Override
    public Animal createAnimal() {
        return new Cat();
    }
}
