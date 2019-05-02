package com.tech4use.timedatepicker;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button time, date;
    TextView t_time, t_date;
    int mYear, mMonth, mDay, mMinute, mHour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //finding ids
        time = (Button)findViewById(R.id.time);
        date = (Button)findViewById(R.id.date);
        t_time = (TextView)findViewById(R.id.text1);
        t_date = (TextView) findViewById(R.id.text2);

        time.setOnClickListener(this);
        date.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(v==date) {

            //creating calendar to get current time
            final Calendar calendar = Calendar.getInstance();

            //storing month, year and date
            mYear = calendar.get(Calendar.YEAR);
            mMonth = calendar.get(Calendar.MONTH);
            mDay = calendar.get(Calendar.DAY_OF_MONTH);

            //creating the date dialog picker to get date from the user
            DatePickerDialog datepicker = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    t_date.setText(dayOfMonth +"-"+(month + 1)+"-"+year);
                }
            }, mYear, mMonth, mDay);
            datepicker.show();
        }

        if(v==time) {

            //getting current time
            final Calendar calendar = Calendar.getInstance();

            //storing hour and minute
            mHour = calendar.get(Calendar.HOUR_OF_DAY);
            mMinute = calendar.get(Calendar.MINUTE);

            //creating the time picker
            TimePickerDialog timepicker = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    t_time.setText(hourOfDay+":"+minute);
                }
            },mHour, mMinute, false);
            timepicker.show();
        }
    }
}
