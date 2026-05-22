package com.example.assignment8alarm;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class stopAlarm extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(Alarmservice.mediaPlayer!=null){
            Alarmservice.mediaPlayer.stop();
            Alarmservice.mediaPlayer.release();
            Alarmservice.mediaPlayer=null;
        }
        NotificationManager manager= (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.cancel(1);
    }
}
