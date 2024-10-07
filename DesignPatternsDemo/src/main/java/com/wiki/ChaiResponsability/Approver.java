package com.wiki.ChaiResponsability;

abstract class Approver {
    protected Approver next;

    public void setNext(Approver next) {
        this.next = next;
    }

    public abstract void approveRequest(int amount);
}
