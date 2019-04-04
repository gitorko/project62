package com.demo.project62.visitor;

import lombok.AllArgsConstructor;
import lombok.Data;

interface Visitable {
    public double accept(Visitor visitor);
}

interface Visitor {
    public double visit(Liquor item);

    public double visit(Grocery item);
}

public class Main {
    public static void main(String[] args) {

        Visitor taxCalculator = new TaxVisitor();
        Liquor liquor = new Liquor("Black Dog", 12.00d);
        System.out.println("Price of liquor: " + liquor.accept(taxCalculator));

        Grocery grocery = new Grocery("Potato Chips", 12.00d);
        System.out.println("Price of grocery: " + grocery.accept(taxCalculator));

    }
}

@AllArgsConstructor
@Data
class Liquor implements Visitable {
    String name;
    double price;

    @Override
    public double accept(Visitor visitor) {
        return visitor.visit(this);
    }
}

@AllArgsConstructor
@Data
class Grocery implements Visitable {
    String name;
    double price;

    @Override
    public double accept(Visitor visitor) {
        return visitor.visit(this);
    }
}

class TaxVisitor implements Visitor {

    @Override
    public double visit(Liquor item) {
        return item.price * .30 + item.price;
    }

    @Override
    public double visit(Grocery item) {
        return item.price * .10 + item.price;
    }
}
