package com.wiki.Bridge;

interface Device {
    void turnOn();
    void turnOff();
}

class TV implements Device {
    @Override
    public void turnOn() {
        System.out.println("TV encendida");
    }

    @Override
    public void turnOff() {
        System.out.println("TV apagada");
    }
}

class Radio implements Device {
    @Override
    public void turnOn() {
        System.out.println("Radio encendida");
    }

    @Override
    public void turnOff() {
        System.out.println("Radio apagada");
    }
}

class Computadora implements Device {
    @Override
    public void turnOn() {
        System.out.println("Computadora encendida");
    }

    @Override
    public void turnOff() {
        System.out.println("Computadora apagada");
    }
}