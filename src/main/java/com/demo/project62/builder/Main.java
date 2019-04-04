package com.demo.project62.builder;

import lombok.Getter;
import lombok.ToString;

public class Main {

    public static void main(String[] args) {
        Dog dog1 = new Dog.DogBuilder("rocky", "German Sheperd").setColor("Grey").setAge(6).setWeight(40.5).build();
        System.out.println(dog1);
        Dog dog2 = new Dog.DogBuilder("rocky", "German Sheperd").build();
        System.out.println(dog2);
    }

}

@Getter
@ToString
class Dog {

    String name;
    String breed;
    String color;
    int age;
    double weight;

    private Dog(DogBuilder builder) {
        this.name = builder.name;
        this.breed = builder.breed;
        this.color = builder.color;
        this.age = builder.age;
        this.weight = builder.weight;
    }

    @Getter
    public static class DogBuilder {

        String name;
        String breed;
        String color;
        int age;
        double weight;

        public DogBuilder(String name, String breed) {
            this.name = name;
            this.breed = breed;
        }

        public Dog build() {
            return new Dog(this);
        }

        public DogBuilder setColor(String color) {
            this.color = color;
            return this;
        }

        public DogBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public DogBuilder setWeight(double weight) {
            this.weight = weight;
            return this;
        }
    }
}
