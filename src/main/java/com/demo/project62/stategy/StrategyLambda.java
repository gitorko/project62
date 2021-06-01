package com.demo.project62.stategy;

import java.util.function.Consumer;

public class StrategyLambda {
    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();

        Consumer<Integer> creditCard = (amount) -> System.out.println("Paid by credit card: " + amount);
        Consumer<Integer> payPal = (amount) -> System.out.println("Paid by paypal: " + amount);

        shoppingCart.pay(creditCard, 10);
        shoppingCart.pay(payPal, 10);
    }

    static class ShoppingCart {
        public void pay(Consumer<Integer> payMethod, Integer amount) {
            payMethod.accept(amount);
        }
    }

}
