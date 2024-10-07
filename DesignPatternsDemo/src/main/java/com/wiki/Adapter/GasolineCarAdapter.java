package com.wiki.Adapter;


class GasolineCarAdapter implements ElectricCar {
    private GasolineCar gasolineCar;

    public GasolineCarAdapter(GasolineCar gasolineCar) {
        this.gasolineCar = gasolineCar;
    }

    @Override
    public void charge() {
        gasolineCar.fillWithGas();
    }
}
