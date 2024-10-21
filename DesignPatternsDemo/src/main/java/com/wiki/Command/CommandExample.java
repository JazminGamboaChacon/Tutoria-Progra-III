package com.wiki.Command;

public class CommandExample {
    public static void main(String[] args) {
        Light light = new Light();
        Command turnOn = new TurnOnCommand(light);
        Command turnOff = new TurnOffCommand(light);
        turnOn.execute();
        turnOff.execute();
    }
}