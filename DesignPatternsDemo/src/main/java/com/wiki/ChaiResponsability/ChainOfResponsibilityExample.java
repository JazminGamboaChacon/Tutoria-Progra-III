package com.wiki.ChaiResponsability;

public class ChainOfResponsibilityExample {
    public static void main(String[] args) {
        Manager manager = new Manager();
        Director director = new Director();
        manager.setNext(director);

        manager.approveRequest(500);
        manager.approveRequest(2000);
    }
}