package com.nitin.subscriptionhisab.data;

/**
 * Created by nitin on 01/03/16.
 */
public class SubscriptionData {

    public int subscription_id;
    public String name;
    public String start_date;
    public int type = 0;
    public float amount;
    public int amount_type = 0;

    public SubscriptionData(String name, String start_date, int type, float amount, int amount_type) {
        this.name = name;
        this.start_date = start_date;
        this.type = type;
        this.amount = amount;
        this.amount_type = amount_type;
    }

    public int getSubscription_id() {
        return subscription_id;
    }

    public void setSubscription_id(int subscription_id) {
        this.subscription_id = subscription_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public int getAmount_type() {
        return amount_type;
    }

    public void setAmount_type(int amount_type) {
        this.amount_type = amount_type;
    }
}
