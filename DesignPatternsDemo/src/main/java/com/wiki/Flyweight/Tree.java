package com.wiki.Flyweight;

class Tree {
    private int x;
    private int y;
    private TreeType type;

    public Tree(int x, int y, TreeType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }
    // Usa la parte compartida (tipo de árbol) para dibujarse.
    public void draw() {
        type.draw(x, y);
    }
}
