package com.wiki.State;

public class StateExample {
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.insertCard();
        atm.setState(new HasCardState());
        atm.withdrawMoney(100);
        atm.ejectCard();
        atm.setState(new HasCardState());

    }
}