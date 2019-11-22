package com.easyway.review;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.easyway.review.adapter.OnItemClickListener;
import com.easyway.review.adapter.RecycleViewAdapter;
import com.easyway.review.adapter.RecyclerItemClickListener;
import com.easyway.review.base.BaseActivity;
import com.easyway.review.module.VibrationVoiceActivity;
import com.easyway.review.module.ndk.NDKActivity;
import com.easyway.review.module.recycleview.RecycleViewActivity;
import com.easyway.review.module.service.AidlActivity;
import com.hanks.frame.utils.UToast;
import com.hanks.frame.utils.Uintent;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    RecyclerView mRecyclerView;
    List<String> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mList = initData();
        mList.add("RecycleView");
        mList.add("NDK");
        mList.add("震动和声音");
        mList.add("AidlService");

        initToolbar();

        initRecycleView(mList);
        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                switch (mList.get(position)) {
                    case "RecycleView":
                        Uintent.intentDIY(mActivity, RecycleViewActivity.class);
                        break;
                    case "NDK":
                        Uintent.intentDIY(mActivity, NDKActivity.class);
                        break;
                    case "震动和声音":
                        Uintent.intentDIY(mActivity, VibrationVoiceActivity.class);
                        break;
                    case "AidlService":
                        Uintent.intentDIY(mActivity, AidlActivity.class);
                        break;
                }
            }

            @Override
            public void onLongClick(View view, int position) {
                UToast.showText("onLongClick" + position);
            }
        }));


    }

    @Override
    protected void setOnTranslucent() {
        //注释之后就没有状态栏沉浸了
//        super.setOnTranslucent();
    }

    private void initRecycleView(List<String> list) {
        mRecyclerView = findViewById(R.id.recyclerView);
        RecycleViewAdapter adapter = new RecycleViewAdapter(list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);//设置布局管理器

        layoutManager.setOrientation(OrientationHelper.VERTICAL);//设置为垂直布局，这也是默认的

        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(layoutManager);
        //添加自定义分割线
        DividerItemDecoration divider = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(this, R.drawable.custom_divider));
        mRecyclerView.addItemDecoration(divider);
    }

    /**
     * 初始化数据
     *
     * @return
     */
    private List<String> initData() {
        List<String> list = new ArrayList<>();
        return list;
    }

    /**
     * 初始化顶部状态栏
     */
    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.ic_menu);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(
                        MainActivity.this, "Yahoooo!", Toast.LENGTH_SHORT
                ).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toobar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.action_search) {
            Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
