package com.wiki.Composite;

public class CompositeExample {
    public static void main(String[] args) {
        Developer dev1 = new Developer("Alice");
        Developer dev2 = new Developer("Bob");
        Manager manager = new Manager("John");
        manager.add(dev1);
        manager.add(dev2);
        manager.showDetails();
    }
}
