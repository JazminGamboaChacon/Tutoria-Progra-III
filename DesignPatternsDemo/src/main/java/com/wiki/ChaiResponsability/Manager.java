package com.wiki.ChaiResponsability;

class Manager extends Approver {
    @Override
    public void approveRequest(int amount) {
        if (amount < 1000) {
            System.out.println("Manager aprueba la solicitud de $" + amount);
        } else if (next != null) {
            next.approveRequest(amount);
        }
    }
}