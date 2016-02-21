package com.nitin.subscriptionhisab.screens;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;

import com.nitin.subscriptionhisab.R;

/**
 * Created by Nitin on 21-02-2016.
 */
public class AddSubscriptionActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_addsubscription);

        setupAppBar();
    }

    private void setupAppBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(null);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setTitle(R.string.add_subscription);
    }


    @Override
    protected void onResume() {
        super.onResume();
    }
}
