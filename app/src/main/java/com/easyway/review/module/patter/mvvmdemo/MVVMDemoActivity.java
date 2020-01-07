package com.easyway.review.module.patter.mvvmdemo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.easyway.review.R;
import com.easyway.review.databinding.ActivityDemoMvvmBinding;
import com.easyway.review.module.patter.mvc.model.Account;
import com.hanks.frame.utils.UToast;

/**
 * @Package: com.easyway.review.module.patter.mvvm.MVVMDemoActivity
 * @Author: 侯建军
 * @CreateDate: 2020/1/6 15:43
 * @Description: 请填写描述
 */
public class MVVMDemoActivity extends AppCompatActivity {
    /**
     * 当layout改为databinding布局时，就是可以下面的对象，注意声明的名称是布局名称大写+Binding
     */
    ActivityDemoMvvmBinding binding;
    Account bean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //取代 setContentView(R.layout.activity_normal);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_demo_mvvm);
        binding.setActivity(this);
        bean = new Account("hanks7", 123);
        binding.setBean(bean);
    }

    public void commit(View view) {
        bean.setName("张三");
        bean.setLevel(222);
        UToast.showText("ttt");
    }
}
