package com.easyway.review.base;

import android.view.MenuItem;

import com.hanks.frame.base.HjjActivity;

/**
 * @author 侯建军 QQ:474664736
 * @time 2019/11/7 15:28
 * @class describe
 */
public class BaseActivity extends HjjActivity {
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
