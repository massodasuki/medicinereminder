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
import android.widget.Toast;

/**
 * Created by Masso on 8/22/2017.
 */

public class RingtonePlayingService extends Service {

    MediaPlayer media_song;
    boolean isRunning;
    int startId;
    private String state;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("LocalService", "Received start id " + startId + " : " + intent);

        media_song = MediaPlayer.create(this, R.raw.victory);

        state = intent.getStringExtra(AlarmReceiver.ALARM_RECEIVER);
        Log.i("Extra state get here ", "what is intent "+ state);

        assert state != null;
        switch (state) {
            case "alarm on":

                Log.i("Extra state get here ", "what is intent 1"+ state);
                startId = 1;
                break;
            case "alarm off":
                Log.i("Extra state get here ", "what is intent 2"+ state);
                startId = 0;
                break;
            default:
                break;
        }


        //if else statement
        if (!this.isRunning && startId == 1)
        {
            Log.i("Extra state get here ", "what is intent 3"+ state);
            media_song = MediaPlayer.create(this, R.raw.victory);
            Log.i("Extra state get here ", "what is intent "+ state);

            media_song.start();
            Log.i("Extra state get here ", "what is intent 4"+ state);

            this.isRunning = true;
            Log.i("Extra state get here ", "what is intent 5"+ state);
            this.startId = 0;
            Log.i("Extra state get here ", "what is intent 6"+ state);
            NotificationManager notify_manager = (NotificationManager)
                    getSystemService(NOTIFICATION_SERVICE);
            Log.i("Extra state get here ", "what is intent 7"+ state);
            Intent intent_alarm_activity = new Intent (this.getApplicationContext(), AlarmActivity.class);
            Log.i("Extra state get here ", "what is intent 8"+ state);
            PendingIntent pendingIntent_alarm_activity = PendingIntent.getActivity(this, 0,
                    intent_alarm_activity, 0);
            Log.i("Extra state get here ", "what is intent 9"+ state);
            Notification notification_popup = new Notification.Builder(this)
                    .setContentTitle("An alarm is going off")
                    .setContentText("Click Me")
                    .setContentIntent(pendingIntent_alarm_activity)
                    .setSmallIcon(R.drawable.ic_launcher)
                    .setAutoCancel(true)
                    .build();
            Log.i("Extra state get here ", "what is intent 10"+ state);
            notify_manager.notify(0, notification_popup);

        }
        else if (this.isRunning && startId == 0)
        {
            Log.i("Extra state get here ", "what is intent 11"+ state);

            media_song = MediaPlayer.create(this, R.raw.victory);
            media_song.stop();
            media_song.reset();
            Log.i("Extra state get here ", "what is intent 12"+ state);
            this.isRunning = false;
            this.startId = 0;

        }

         else if (!this.isRunning && startId == 0)
        {

            Log.i("Extra state get here ", "what is intent 13"+ state);
            this.isRunning = false;
            this.startId = 0;
            Log.i("Extra state get here ", "what is intent 14"+ state);
        }
        else if (this.isRunning && startId == 1)
        {
            this.isRunning = true;
            this.startId = 1;
            Log.i("Extra state get here ", "what is intent 15"+ state);
        }
        else {

            Log.e("Something"," happen");
        }

        Log.i("Extra state get here ", "what is intent 16"+ state);

        return START_NOT_STICKY;

    }

    @Override
    public void onDestroy() {
        // Tell the user we stopped.
        Log.i("Extra state get here ", "what is intent 17"+ state);
        Toast.makeText(this,"on Destroy Called", Toast.LENGTH_SHORT).show();
    }




}


