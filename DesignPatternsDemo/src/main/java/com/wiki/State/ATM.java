package com.wiki.State;

class ATM {
    private ATMState state;

    public ATM() {
        state = new NoCardState();
    }

    public void setState(ATMState state) {
        this.state = state;
    }

    public void insertCard() {
        state.insertCard();
    }

    public void ejectCard() {
        state.ejectCard();
    }

    public void withdrawMoney(int amount) {
        state.withdrawMoney(amount);
    }
}

