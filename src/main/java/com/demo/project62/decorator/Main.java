package com.demo.project62.decorator;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

public class Main {

    public static void main(String[] args) {
        Pizza pizza = new ThickCrustPizza();
        System.out.println("Pizza: " + pizza.getDescription());
        System.out.println("Cost: " + pizza.getCost());

        Cheese cheese = new Cheese(pizza);
        System.out.println("Pizza: " + cheese.getDescription());
        System.out.println("Cost: " + cheese.getCost());

        Cheese doubleCheese = new Cheese(cheese);
        System.out.println("Pizza: " + doubleCheese.getDescription());
        System.out.println("Cost: " + doubleCheese.getCost());
    }

}

abstract class Pizza {
    String description;

    public String getDescription() {
        return description;
    }

    abstract BigDecimal getCost();
}

class ThickCrustPizza extends Pizza {
    public ThickCrustPizza() {
        super();
        this.description = "Thick Crust Pizza";
    }

    @Override
    BigDecimal getCost() {
        return new BigDecimal(10.00);
    }
}

abstract class PizzaIngredient extends Pizza {
    public abstract String getDescription();
}

@AllArgsConstructor
class Cheese extends PizzaIngredient {
    private Pizza pizza;

    @Override
    BigDecimal getCost() {
        return (new BigDecimal(2.00).add(pizza.getCost()));
    }

    @Override
    public String getDescription() {
        return this.pizza.getDescription() + " + Cheese";
    }
}