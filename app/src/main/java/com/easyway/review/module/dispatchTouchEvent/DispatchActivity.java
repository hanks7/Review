package com.easyway.review.module.dispatchTouchEvent;

import android.os.Bundle;
import android.view.MotionEvent;

import com.easyway.review.R;
import com.easyway.review.base.BaseActivity;

/**
 *
 * @Package:        com.easyway.review.module.dispatchTouchEvent.DispatchActivity
 * @Author:         侯建军
 * @CreateDate:     2019/11/28 9:58
 * @Description:    事件分发 参考文献：http://www.luyixian.cn/news_show_14683.aspx
 */
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
