package com.nitin.subscriptionhisab.screens;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.nitin.subscriptionhisab.R;
import com.nitin.subscriptionhisab.data.SubscriptionData;
import com.nitin.subscriptionhisab.database.DbAccess;

import java.util.Calendar;

/**
 * Created by Nitin on 21-02-2016.
 */
public class AddSubscriptionActivity extends BaseActivity implements View.OnClickListener {

    private Button btSave;
    private Button btDate;
    private int year_x, month_x, day_x;
    static final int DIALOG_ID = 0;
    private Context context;
    private TextView tvDate;
    private EditText etSubsName;
    private EditText etAmt;
    private RadioGroup rGrp;
    private RadioButton rBtMonthly, rBtPerSubs;
    private Spinner spinnerSubsType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_addsubscription);
        setupAppBar();
        initComponents();
        setupSpinner();
        setupDatePickerDialog();
        showCurrentDate();
    }

    private void setupSpinner() {
        spinnerSubsType = (Spinner) findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinnerSubsType layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.once_twice, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinnerSubsType
        spinnerSubsType.setAdapter(adapter);

    }


    private void setupAppBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(null);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setTitle(R.string.add_subscription);
    }

    public void setupDatePickerDialog() {
        btDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new DatePickerDialog(context, dpickerListener, year_x,
                        month_x, day_x).show();
            }
        });
    }

    private void showCurrentDate() {
        final Calendar cal = Calendar.getInstance();
        year_x = cal.get(Calendar.YEAR);
        month_x = cal.get(Calendar.MONTH);
        month_x++;
        day_x = cal.get(Calendar.DAY_OF_MONTH);
        showDate();
    }

    private DatePickerDialog.OnDateSetListener dpickerListener = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            year_x = year;
            month_x = monthOfYear + 1;
            day_x = dayOfMonth;

            showDate();
        }
    };

    private void showDate() {
        tvDate.setText(day_x + "/" + month_x + "/" + year_x);
    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    private void initComponents() {
        etSubsName = (EditText) findViewById(R.id.et_subsName);
        etAmt = (EditText) findViewById(R.id.et_Amt);
        btSave = (Button) findViewById(R.id.bt_save);
        btDate = (Button) findViewById(R.id.bt_date);
        tvDate = (TextView) findViewById(R.id.tv_date);
        rGrp = (RadioGroup) findViewById(R.id.radio_grp);
        btSave.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if (view == btSave) {
            if (isDataComplete()) {
//                saveDataInDB();
                int amountType = 0;
                if (rGrp.getCheckedRadioButtonId() == R.id.rb_persubs) {
                    amountType = 1;
                }
                SubscriptionData data = new SubscriptionData(etSubsName.getText().toString(),
                        tvDate.getText().toString(), spinnerSubsType.getSelectedItemPosition(),
                        Float.valueOf(etAmt.getText().toString()), amountType);
                boolean isSaved = DbAccess.getInstance().insertSubscriptionData(data);
                if (isSaved){
                    Toast.makeText(context, "Data is saved.", Toast.LENGTH_LONG).show();
                    finish();
                } else {
                    Toast.makeText(context, "Oops... Data isn't saved!", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(context, "Please fill the required details!", Toast.LENGTH_LONG).show();
            }
        }
    }

    private boolean isDataComplete() {
        if (TextUtils.isEmpty(etSubsName.getText()) || TextUtils.isEmpty(etAmt.getText())) {
            return false;
        }
        return true;
    }


}

