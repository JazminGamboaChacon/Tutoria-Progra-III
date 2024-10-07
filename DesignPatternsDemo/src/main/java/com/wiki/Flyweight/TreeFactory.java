package com.wiki.Flyweight;

import java.util.HashMap;
import java.util.Map;

class TreeFactory {
    private static Map<String, TreeType> treeTypes = new HashMap<>();

    public static TreeType getTreeType(String name, String color, String texture) {
        String key = name + "-" + color + "-" + texture;
        if (!treeTypes.containsKey(key)) {
            treeTypes.put(key, new TreeType(name, color, texture));
            System.out.println("Creando tipo de árbol: " + key);
        }
        return treeTypes.get(key);
    }
}
