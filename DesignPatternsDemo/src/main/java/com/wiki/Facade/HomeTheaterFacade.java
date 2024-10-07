package com.wiki.Facade;

class HomeTheaterFacade {
    private Amplifier amplifier;
    private Projector projector;
    private Screen screen;

    public HomeTheaterFacade(Amplifier amplifier, Projector projector, Screen screen) {
        this.amplifier = amplifier;
        this.projector = projector;
        this.screen = screen;
    }

    public void watchMovie() {
        amplifier.on();
        projector.on();
        screen.lower();
        System.out.println("Todo listo para ver la película");
    }
}







