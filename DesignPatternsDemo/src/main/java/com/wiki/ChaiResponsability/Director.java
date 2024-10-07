package com.wiki.ChaiResponsability;

class Director extends Approver {
    @Override
    public void approveRequest(int amount) {
        if (amount < 5000) {
            System.out.println("Director aprueba la solicitud de $" + amount);
        } else if (next != null) {
            next.approveRequest(amount);
        }
    }
}