package com.wiki.State;

class HasCardState implements ATMState {
    @Override
    public void insertCard() {
        System.out.println("La tarjeta ya está insertada.");
    }

    @Override
    public void ejectCard() {
        System.out.println("Tarjeta expulsada.");
    }

    @Override
    public void withdrawMoney(int amount) {
        System.out.println("Retirando $" + amount);
    }
}