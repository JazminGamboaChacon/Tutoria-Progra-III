package com.wiki.Flyweight;

public class FlyweightExample {
    public static void main(String[] args) {
        TreeType type = TreeFactory.getTreeType("Arbol", "Verde", "Rough");

        Tree tree1 = new Tree(10, 20, type);
        Tree tree2 = new Tree(30, 40, type);
        Tree tree3 = new Tree(50, 60, type);

        tree1.draw();
        tree2.draw();
        tree3.draw();
    }
}