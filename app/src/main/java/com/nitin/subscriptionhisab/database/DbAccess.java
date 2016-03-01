package com.nitin.subscriptionhisab.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.nitin.subscriptionhisab.app.SubsHisabApp;
import com.nitin.subscriptionhisab.data.SubscriptionData;

/**
 * Created by nitin on 01/03/16.
 */
public class DbAccess {

    private static DbAccess instance;
    private Context context;

    public SQLiteDatabase database;
    private DbHelper dbHelper;

    private DbAccess() {
        dbHelper = new DbHelper();
        context = SubsHisabApp.getInstance().getApplicationContext();
    }

    public static DbAccess getInstance() {
        if (instance == null) {
            instance = new DbAccess();
        }
        return instance;
    }


    public boolean insertSubscriptionData(SubscriptionData subscriptionData) {
        openDB();
        long rowId = database.insert(DbConstants.TABLE_SUBSCRIPTION, null, getContenValues(subscriptionData));
        closeDB();
        if (rowId == -1) {
            return false;
        }
        return true;
    }


    public ContentValues getContenValues(SubscriptionData subscriptionData) {
        ContentValues values = new ContentValues();
        values.put(DbConstants.DbColumn.NAME, subscriptionData.getName());
        values.put(DbConstants.DbColumn.START_DATE, subscriptionData.getStart_date());
        values.put(DbConstants.DbColumn.TYPE, subscriptionData.getType());
        values.put(DbConstants.DbColumn.AMOUNT, subscriptionData.getAmount());
        return values;
    }

    public void openDB() {
        database = dbHelper.getWritableDatabase();
    }

    public void closeDB() {
        if (database != null && database.isOpen())
            database.close();
    }


}
