package com.demo.project62.decorator;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;

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



interface Pizza {
    public String getDescription();
    public BigDecimal getCost();
}

class ThickCrustPizza implements Pizza {

    @Override
    public String getDescription() {
        return "Thick Crust Pizza";
    }

    @Override
    public BigDecimal getCost() {
        return new BigDecimal(10.00);
    }
}

@AllArgsConstructor
class PizzaToppingDecorator implements Pizza {

    Pizza pizza;

    @Override
    public String getDescription() {
        return pizza.getDescription();
    }

    @Override
    public BigDecimal getCost() {
        return pizza.getCost();
    }
}

class Cheese extends PizzaToppingDecorator {

    public Cheese(Pizza pizza) {
        super(pizza);
    }

    @Override
    public BigDecimal getCost() {
        return (new BigDecimal(2.00).add(pizza.getCost()));
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " + Cheese";
    }
}