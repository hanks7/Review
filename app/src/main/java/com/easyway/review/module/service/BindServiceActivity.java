package com.easyway.review.module.service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;

import com.easyway.review.R;
import com.easyway.review.base.BaseActivity;

public class BindServiceActivity extends BaseActivity {

    private Button startService,stopService,bindService,unbindService;
    private BindService.Mybind mybind;


    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mybind = (BindService.Mybind) service;
            mybind.getString(); //获取到getString方法
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startService = (Button) findViewById(R.id.start_service);
        stopService = (Button) findViewById(R.id.stop_service);
        bindService = (Button) findViewById(R.id.bind_service);
        unbindService = (Button) findViewById(R.id.unbind_service);


        /**
         * 开启服务
         */
        startService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startService = new Intent(BindServiceActivity.this,BindService.class);
                startService(startService);

            }
        });


        /**
         * 停止服务
         */
        stopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent stopService = new Intent(BindServiceActivity.this,BindService.class);
                stopService(stopService);
            }
        });

        /**
         * 绑定服务
         */
        bindService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bindService = new Intent(BindServiceActivity.this,BindService.class);
                bindService(bindService,connection,BIND_AUTO_CREATE);
            }
        });

        /**
         * 解绑服务
         */
        unbindService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unbindService(connection);
            }
        });
    }
}