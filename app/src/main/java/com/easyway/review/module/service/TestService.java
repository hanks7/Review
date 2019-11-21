package com.easyway.review.module.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.hanks.frame.utils.Ulog;

public class TestService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        Ulog.i("ServiceTest","  ----->  onCreate");
    }


    @Override
    public int onStartCommand(Intent intent,int flags, int startId) {

        Ulog.i("ServiceTest","  ----->  onStartCommand");

        return super.onStartCommand(intent, flags, startId);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();

        Ulog.i("ServiceTest","  ----->  onDestroy");

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
