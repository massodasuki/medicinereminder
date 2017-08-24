package com.unifreelancer.masso.medicinereminder;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

//http://javapapers.com/android/android-alarm-clock-tutorial/
//http://www.codingconnect.net/android-application-creates-alarm-clock/

public class PillReminder extends AppCompatActivity {

    TimePicker alarmTimePicker;
    PendingIntent pendingIntent;
    AlarmManager alarmManager;
    EditText medicine;
    Context context;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pill_reminder);
        alarmTimePicker = (TimePicker) findViewById(R.id.timePicker);
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        medicine = (EditText) findViewById(R.id.type_medicine);


        Calendar calenadr = Calendar.getInstance();


        Button alarm_on = (Button) findViewById(R.id.alarmOn);


        Button alarm_off = (Button) findViewById(R.id.alarmOff);

        alarm_on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }


}
