package com.wiki.State;


class NoCardState implements ATMState {
    @Override
    public void insertCard() {
        System.out.println("Tarjeta insertada.");
    }

    @Override
    public void ejectCard() {
        System.out.println("No hay tarjeta para expulsar.");
    }

    @Override
    public void withdrawMoney(int amount) {
        System.out.println("Inserte la tarjeta primero.");
    }
}