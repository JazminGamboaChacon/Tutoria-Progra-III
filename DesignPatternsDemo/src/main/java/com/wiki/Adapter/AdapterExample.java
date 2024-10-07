package com.wiki.Adapter;

public class AdapterExample {
    public static void main(String[] args) {
        ElectricCar tesla = new Tesla();
        tesla.charge();

        ElectricCar adaptedCar = new GasolineCarAdapter(new GasolineCar());
        adaptedCar.charge();
    }
}

