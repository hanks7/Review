package com.easyway.review.module.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.easyway.review.IMyAidlInterface;
import com.hanks.frame.utils.Ulog;

public class AidlService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        Ulog.i("ServiceTest", "  ----->  onCreate");
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Ulog.i("ServiceTest", "  ----->  onStartCommand");

        return super.onStartCommand(intent, flags, startId);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();

        Ulog.i("ServiceTest", "  ----->  onDestroy");

    }

    @Override
    public IBinder onBind(Intent intent) {

        return new Mybind();
    }


    class Mybind extends IMyAidlInterface.Stub {


        @Override
        public String getString() {
            String string = "我是从服务起返回的";

            return string;
        }

    }
}
