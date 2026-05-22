package com.example.assignment8alarm;

import android.Manifest;
import  android.app.NotificationChannel;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.provider.Settings;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;


public class Alarmservice  extends BroadcastReceiver {
    public  static MediaPlayer mediaPlayer;
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"Alarm Triggered",Toast.LENGTH_LONG).show();
        mediaPlayer=MediaPlayer.create(context, Settings.System.DEFAULT_ALARM_ALERT_URI);
        mediaPlayer.start();
        Intent intent1=new Intent(context,stopAlarm.class);
        PendingIntent pendingIntent=PendingIntent.getBroadcast(context,1,intent1,PendingIntent.FLAG_IMMUTABLE);
        NotificationManager manager= (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        String channel_id="Alarm_channel";

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel=new NotificationChannel(channel_id,"Alarm Notification",NotificationManager.IMPORTANCE_HIGH);
            manager.createNotificationChannel(channel);
            NotificationCompat.Builder builder=new NotificationCompat.Builder(context,channel_id)
                    .setSmallIcon(R.drawable.outline_acute_24)
                    .setContentTitle("Alarm Notification")
                    .setContentText("Wake up")
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setAutoCancel(false)
                    .addAction(R.drawable.outline_acute_24,"Cancel",pendingIntent);

            manager.notify(1,builder.build());

        }
    }
}