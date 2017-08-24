package com.unifreelancer.masso.medicinereminder;

/**
 * Created by Masso on 8/14/2017.
 */

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class AlarmReceiver extends BroadcastReceiver {
    private String notification;
    private String alarmReceiver;
    public static final String ALARM_RECEIVER = "ALARM_RECEIVER";

    @Override
    public void onReceive(Context context, Intent intent)
    {
        Log.e("We are in the receiver.","Yay");

        alarmReceiver = intent.getStringExtra(AlarmActivity.ALARM_STATUS);

        Intent service_intent = new Intent(context, RingtonePlayingService.class);
        service_intent.putExtra(ALARM_RECEIVER, alarmReceiver);
        //start the ringtone service
        context.startService(service_intent);
    }
}