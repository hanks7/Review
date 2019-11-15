package com.easyway.review.module;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.View;

import com.easyway.review.R;
import com.easyway.review.base.BaseActivity;
import com.easyway.review.utils.SoundPoolUtils;

/**
 * 点击button震动和声音
 * <p>
 * 在使用之前在AndroidManifest.xml文件中添加
 * <uses-permission android:name="android.permission.VIBRATE"/>
 */
public class VibrationVoiceActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vibration_voice);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("震动和声音");

    }

    @Override
    protected void setOnTranslucent() {
    }

    public void btnClick(View view) {
        SoundPoolUtils.getInstance(this).startVibrator(1000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        SoundPoolUtils.getInstance(this).release();
    }
}
