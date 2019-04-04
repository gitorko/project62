package com.demo.project62.builder.other;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

public class Main {
    public static void main(String[] args) {
        Dog dog1 = Dog.builder().name("Rocky").breed("German Sheperd").build();
        System.out.println(dog1);
    }
}

@Builder
@Getter
@ToString
class Dog {

    String name;
    String breed;
    String color;
    int age;
    @Builder.Default
    double weight = 30.0;
}