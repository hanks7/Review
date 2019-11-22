package com.easyway.review.module.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.hanks.frame.utils.Ulog;

/**
 * 三个重写的方法
 * onCreate Service生成之后只运行一次
 * onStartCommand 每次startService都执行
 * onDestroy 销毁
 */
public class BindService extends Service {
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


    class Mybind extends Binder {
        public void getString() {
            Ulog.i("ServiceTest", "  ----->  getString");
        }
    }

}
