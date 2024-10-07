package com.wiki.Facade;

public class FacadeExample {
    public static void main(String[] args) {
        Amplifier amp = new Amplifier();
        Projector proj = new Projector();
        Screen screen = new Screen();
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(amp, proj, screen);
        homeTheater.watchMovie();
    }
}
