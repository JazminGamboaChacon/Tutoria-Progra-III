package com.wiki.Decorator;


interface Coffee {
    String getDescription();
    double getCost();
}

class SimpleCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Café simple";
    }

    @Override
    public double getCost() {
        return 2.0;
    }
}
