package com.easyway.review.module.service;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.easyway.review.R;
import com.easyway.review.base.BaseActivity;

public class ServiceActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
    }

    public void startService(View view) {
        Intent startService = new Intent(ServiceActivity.this, TestService.class);
        startService(startService);
    }

    public void stopService(View view) {
        Intent stopService = new Intent(ServiceActivity.this, TestService.class);
        stopService(stopService);
    }
}
