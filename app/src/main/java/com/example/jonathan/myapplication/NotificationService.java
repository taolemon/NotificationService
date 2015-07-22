package com.example.jonathan.myapplication;

import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;

/**
 * Created by jonathan on 15/07/22.
 */
public class NotificationService extends NotificationListenerService {

    private String TAG = "Notification";

    @Override
    public void onCreate(){
        super.onCreate();
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
    }

    @Override
    public void onNotificationPosted(StatusBarNotification sbn){
        Log.d(TAG, "onNotificationPosted");
        showLog(sbn);

        StatusBarNotification[] array = getActiveNotifications();
        for(int i=0; i < array.length; i++){
            showLog(array[i]);
        }
    }

    private void showLog(StatusBarNotification sbn){
        int id = sbn.getId();
        String name = sbn.getPackageName();
        long time = sbn.getPostTime();
        boolean clearable = sbn.isClearable();
        boolean playing = sbn.isOngoing();
        CharSequence text = sbn.getNotification().tickerText;

        Log.d(TAG, "id:"+id+" name:"+name+" time:"+time);
        Log.d(TAG, "isClearable:"+clearable+" isOngoing:"+playing+" tickerText:"+text);
    }
}
