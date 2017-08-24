package com.unifreelancer.masso.medicinereminder;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class AlarmActivity extends AppCompatActivity implements View.OnClickListener{

    TimePicker alarmTimePicker;
    PendingIntent pendingIntent;
    AlarmManager alarmManager;
    EditText medicine;
    TextView update_text;


    public static final String ALARM_STATUS = "ALARM";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);



        medicine = (EditText)findViewById(R.id.type_medicine);

        alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);

        alarmTimePicker = (TimePicker)findViewById(R.id.timePicker);

        update_text = (TextView)findViewById(R.id.alarmStatus);

        final Calendar calendar = Calendar.getInstance();

        final Intent my_intent  = new Intent(this, AlarmReceiver.class);


        Button alarm_on = (Button)findViewById(R.id.alarmOn);

        final Button alarm_off = (Button)findViewById(R.id.alarmOff);

        alarm_on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calendar.set(Calendar.HOUR_OF_DAY, alarmTimePicker.getHour());
                calendar.set(Calendar.MINUTE, alarmTimePicker.getMinute());

                int hour = alarmTimePicker.getHour();
                int minute = alarmTimePicker.getMinute();

                String hour_string = String.valueOf(hour);
                String minute_string = String.valueOf(minute);

                String alarm = "alarm on";
                my_intent.putExtra(ALARM_STATUS, alarm);

                if (hour > 12){

                    hour_string = String.valueOf(hour - 12);

                }

                if (minute < 10) {

                    minute_string = "0" + String.valueOf(minute);
                }

                set_alarm_text("Alarm On :" + hour_string + ":" + minute_string);


                String alert = medicine.getText().toString();
                PillAlert.instance().setMydataToShare(alert);


                pendingIntent = PendingIntent.getBroadcast(AlarmActivity.this, 0,
                        my_intent, PendingIntent.FLAG_UPDATE_CURRENT);

                alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                        pendingIntent);

            }
        });

        alarm_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                set_alarm_text("Alarm Off");

                alarmManager.cancel(pendingIntent);

                //tell the clock to press alarm off
                String alarm = "alarrm off";
                my_intent.putExtra(ALARM_STATUS, alarm);

                //stop ringtone
                sendBroadcast(my_intent);

            }
        });


    }

    private void set_alarm_text(String output) {

        update_text.setText(output);

    }


    @Override
    public void onClick(View v) {

    }
}
