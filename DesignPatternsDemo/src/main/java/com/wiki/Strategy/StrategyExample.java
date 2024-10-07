package com.wiki.Strategy;

public class StrategyExample {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        double price = 100.0;

        cart.setDiscountStrategy(new NoDiscount());
        System.out.println("Precio final (sin descuento): $" + cart.calculateFinalPrice(price));

        cart.setDiscountStrategy(new SeasonalDiscount());
        System.out.println("Precio final (descuento de temporada): $" + cart.calculateFinalPrice(price));

        cart.setDiscountStrategy(new ClearanceDiscount());
        System.out.println("Precio final (descuento por liquidación): $" + cart.calculateFinalPrice(price));
    }
}
