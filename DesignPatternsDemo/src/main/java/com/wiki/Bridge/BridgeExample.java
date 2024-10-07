package com.wiki.Bridge;


public class BridgeExample {
    public static void main(String[] args) {

        RemoteControl remote;
        System.out.println("Control Universal");

        System.out.println("---------------------");
        Device tv = new TV();
        remote= new  RemoteControl(tv);
        remote.turnOn();
        remote.turnOff();
        System.out.println("---------------------");

        Device radio = new Radio();
        remote= new  RemoteControl(radio);
        remote.turnOn();
        remote.turnOff();
        System.out.println("---------------------");

        Device computadora = new Computadora();
        remote= new  RemoteControl(computadora);
        remote.turnOn();
        remote.turnOff();
    }
}
