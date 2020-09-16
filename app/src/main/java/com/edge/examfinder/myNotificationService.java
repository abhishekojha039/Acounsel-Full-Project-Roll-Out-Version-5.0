package com.edge.examfinder;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class myNotificationService extends FirebaseMessagingService {
    int count1=0;
    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt("count",count1+1);
        editor.commit();
        showNotification(remoteMessage.getNotification().getTitle(),remoteMessage.getNotification().getBody());
    }
    public  void showNotification(String title,String message)
    {
        Intent resultIntent =new Intent(this,myNotification.class);
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt("count",count1+1);
        editor.commit();
        PendingIntent resultPending=PendingIntent.getActivity(getApplicationContext(),1,resultIntent,PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,"myNotifications")
                .setContentTitle(title)
                .setSmallIcon(R.drawable.logo_image)
                .setAutoCancel(true)
                .setContentIntent(resultPending)
                .setContentText(message);
        NotificationManagerCompat managerCompat=NotificationManagerCompat.from(this);
        managerCompat.notify(999,builder.build());


    }
}
