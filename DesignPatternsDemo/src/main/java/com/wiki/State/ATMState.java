package com.wiki.State;

interface ATMState {
    void insertCard();
    void ejectCard();
    void withdrawMoney(int amount);
}