package com.wiki.Decorator;


class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", con leche";
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 0.5;
    }
}
