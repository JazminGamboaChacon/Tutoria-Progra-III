package com.wiki.Adapter;


interface ElectricCar {
    void charge();
}

class Tesla implements ElectricCar {
    @Override
    public void charge() {
        System.out.println("Cargando coche eléctrico.");
    }
}