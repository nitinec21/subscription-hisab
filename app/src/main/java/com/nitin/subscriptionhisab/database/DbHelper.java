package com.nitin.subscriptionhisab.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.nitin.subscriptionhisab.app.SubsHisabApp;

/**
 * Created by nitin on 01/03/16.
 */
public class DbHelper extends SQLiteOpenHelper {

    private static final String TAG = DbHelper.class.getSimpleName();

    public static final String CREATE_TABLE_SUBSCRIPTION = "CREATE TABLE IF NOT EXISTS "
            + DbConstants.TABLE_SUBSCRIPTION + " (" + DbConstants.DbColumn.SUBSCRIPTION_ID
            + " integer primary key autoincrement, " + DbConstants.DbColumn.NAME
            + " text not null, " + DbConstants.DbColumn.START_DATE + " text not null, "
            + DbConstants.DbColumn.TYPE + " integer, " + DbConstants.DbColumn.AMOUNT_TYPE + " integer, "
            + DbConstants.DbColumn.AMOUNT + " real);";

    public static final String CREATE_TABLE_LEAVES = "CREATE TABLE IF NOT EXISTS "
            + DbConstants.TABLE_LEAVE + " (" + DbConstants.DbColumn.SUBSCRIPTION_ID
            + " integer primary key, " + DbConstants.DbColumn.DATE
            + " text not null, " + DbConstants.DbColumn.MONTH + " integer not null, "
            + DbConstants.DbColumn.YEAR + " integer not null, "
            + DbConstants.DbColumn.LEAVE_1 + " integer, " + DbConstants.DbColumn.LEAVE_2 + " integer);";

    public DbHelper() {
        super(SubsHisabApp.getInstance(), DbConstants.DATABASE_NAME, null, DbConstants.DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.i(TAG, CREATE_TABLE_SUBSCRIPTION);
        Log.i(TAG, CREATE_TABLE_LEAVES);

        sqLiteDatabase.execSQL(CREATE_TABLE_SUBSCRIPTION);
        sqLiteDatabase.execSQL(CREATE_TABLE_LEAVES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
}
