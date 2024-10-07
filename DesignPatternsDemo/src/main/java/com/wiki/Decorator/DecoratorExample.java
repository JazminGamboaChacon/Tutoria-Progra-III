package com.wiki.Decorator;

public class DecoratorExample {
    public static void main(String[] args) {
        Coffee coffee;
        coffee = new SimpleCoffee();
        System.out.println(coffee.getDescription() + ": " + coffee.getCost());
        coffee = new MilkDecorator(coffee);
        System.out.println(coffee.getDescription() + ": " + coffee.getCost());
    }
}