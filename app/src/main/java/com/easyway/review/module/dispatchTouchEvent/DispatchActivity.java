package com.easyway.review.module.dispatchTouchEvent;

import android.os.Bundle;
import android.view.MotionEvent;

import com.easyway.review.R;
import com.easyway.review.base.BaseActivity;

public class DispatchActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dispatch);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
