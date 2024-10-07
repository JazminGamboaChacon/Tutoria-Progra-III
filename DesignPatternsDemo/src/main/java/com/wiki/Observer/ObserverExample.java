package com.wiki.Observer;

public class ObserverExample {
    public static void main(String[] args) {
        Channel channel = new Channel();
        User user1 = new User("Alice");
        User user2 = new User("Bob");

        channel.subscribe(user1);
        channel.subscribe(user2);

        channel.notifySubscribers("Nuevo video publicado!");

    }
}