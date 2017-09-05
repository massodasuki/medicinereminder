package com.unifreelancer.masso.medicinereminder;


import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Masso on 8/22/2017.
 */

public class RingtonePlayingService extends Service {

    MediaPlayer media_song;
    boolean isRunning;
    static int startId;
    private String state;
    private String alertMeTitle;


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("LocalService", "Received start id " + startId + " : " + intent);



        state = intent.getStringExtra(AlarmReceiver.ALARM_RECEIVER);
        Log.i("Extra state get here ", "what is intent "+ state);

        alertMeTitle = PillAlert.instance().getMydataToShare();

        assert state != null;
        switch (state) {
            case "alarm on":

                Log.i("Line 1", "when intent is :"+ state);
                startId = 1;
                break;
            case "alarm off":
                Log.i("Line 2", "when intent is :"+ state);
                startId = 0;
                break;
            default:
                startId = 0;
                break;
        }


        //if else statement
        if (!this.isRunning && startId == 1)
        {
            Log.i("Line 3", "when intent is :"+ state);
            media_song = MediaPlayer.create(this, R.raw.victory);
            Log.i("Line 4", "when intent is :"+ state);

            media_song.start();
            Log.i("Line 5", "when intent is :"+ state);

            this.isRunning = true;
            Log.i("Line 6", "when intent is :"+ state);
            this.startId = 0;
            Log.i("Line 7", "when intent is :"+ state);
            NotificationManager notify_manager = (NotificationManager)
                    getSystemService(NOTIFICATION_SERVICE);
            Log.i("Line 8", "when intent is :"+ state);
            Intent intent_alarm_activity = new Intent (this.getApplicationContext(), AlarmActivity.class);
            Log.i("Line 9", "when intent is :"+ state);
            PendingIntent pendingIntent_alarm_activity = PendingIntent.getActivity(this, 0,
                    intent_alarm_activity, 0);
            Log.i("Line 10", "when intent is :"+ state);
            Notification notification_popup = new Notification.Builder(this)
                    .setContentTitle("Time for :" + alertMeTitle)
                    .setContentText("Click Me To Off Alarm")
                    .setContentIntent(pendingIntent_alarm_activity)
                    .setSmallIcon(R.drawable.ic_launcher)
                    .setAutoCancel(true)
                    .build();
            Log.i("Line 11", "when intent is :"+ state);
            notify_manager.notify(0, notification_popup);

        }
        else if (this.isRunning && startId == 0)
        {
            Log.i("Line 12", "when intent is :"+ state);

            //media_song = MediaPlayer.create(this, R.raw.victory);
            media_song.stop();
            media_song.reset();
            Log.i("Line 13", "when intent is :"+ state);
            this.isRunning = false;
            this.startId = 0;

        }

         else if (!this.isRunning && startId == 0)
        {

            Log.i("Line 14", "when intent is :"+ state);
            this.isRunning = false;
            this.startId = 0;
            Log.i("Line 15", "when intent is :"+ state);
        }
        else if (this.isRunning && startId == 1)
        {
            this.isRunning = true;
            this.startId = 1;
            Log.i("Line 16", "when intent is :"+ state);
        }
        else {

            Log.e("Something"," happen");
        }

        Log.i("Line 17", "when intent is :"+ startId + state);

        return START_NOT_STICKY;

    }

    @Override
    public void onDestroy() {
        // Tell the user we stopped.
        Log.i("Line 18 onDestroy", "when intent is :"+ state);
        super.onDestroy();
        isRunning = false;

    }




}


