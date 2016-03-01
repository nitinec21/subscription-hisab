package com.nitin.subscriptionhisab.data;

/**
 * Created by nitin on 01/03/16.
 */
public class LeavesData {

    public int subscription_id;
    public int month;
    public int year;
    public String date;
    public int leave_1 = 0;
    public int leave_2 = 0;

    public LeavesData(int subscription_id, int month, int year, String date, int leave_1, int leave_2) {
        this.subscription_id = subscription_id;
        this.month = month;
        this.year = year;
        this.date = date;
        this.leave_1 = leave_1;
        this.leave_2 = leave_2;
    }

    public int getSubscription_id() {
        return subscription_id;
    }

    public void setSubscription_id(int subscription_id) {
        this.subscription_id = subscription_id;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getLeave_1() {
        return leave_1;
    }

    public void setLeave_1(int leave_1) {
        this.leave_1 = leave_1;
    }

    public int getLeave_2() {
        return leave_2;
    }

    public void setLeave_2(int leave_2) {
        this.leave_2 = leave_2;
    }
}
