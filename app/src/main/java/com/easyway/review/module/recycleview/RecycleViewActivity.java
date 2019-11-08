package com.easyway.review.module.recycleview;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.easyway.review.R;
import com.easyway.review.base.BaseActivity;

import java.util.List;

public class RecycleViewActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initToolbar();

        List<Meizi> meizis = initData();

        MeiziAdapter adapter = new MeiziAdapter(this, meizis);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);//设置布局管理器

        layoutManager.setOrientation(OrientationHelper.VERTICAL);//设置为垂直布局，这也是默认的
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new MeiziItemDecoration(2)); //设置分隔线,2px

    }

    @Override
    protected void setOnTranslucent() {
    }

    /**
     * 初始化数据
     *
     * @return
     */
    private List<Meizi> initData() {
        return MeiziFactory.createMeizis(100);
    }

    /**
     * 初始化顶部状态栏
     */
    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setVisibility(View.GONE);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("RecycleView例子");

    }

}
