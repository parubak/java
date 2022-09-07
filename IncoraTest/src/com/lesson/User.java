package com.lesson;

import java.util.ArrayList;

public class User {

    private ArrayList<Subscription> subscriptions;

    public User(ArrayList<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }

    public Subscription subscribe(StreamingService streamingService) {
        Subscription newSubscription = new Subscription(streamingService);
        if (subscriptions.contains(newSubscription)) {
            System.out.println("You are already subscribed!!!");
            return null;
        }

        subscriptions.add(newSubscription);
        return newSubscription;
    }

    public Subscription getSubscript(int index) {
        return subscriptions.get(index - 1);
    }
}
