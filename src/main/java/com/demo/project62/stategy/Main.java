package com.demo.project62.stategy;

interface PaymentStrategy {

    public void pay(int amount);
}

public class Main {

    public static void main(String[] args) {
        new ShoppingCart().pay(new CreditCardStrategy(), 10);
        new ShoppingCart().pay(new PaypalStrategy(), 10);
    }
}

class CreditCardStrategy implements PaymentStrategy {

    @Override
    public void pay(int amount) {
        System.out.println("Paid by creditcard: " + amount);
    }

}

class PaypalStrategy implements PaymentStrategy {

    @Override
    public void pay(int amount) {
        System.out.println("Paid by paypall: " + amount);
    }

}

class ShoppingCart {

    public void pay(PaymentStrategy paymentMethod, Integer amount) {
        paymentMethod.pay(amount);
    }
}
