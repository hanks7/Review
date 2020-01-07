package com.easyway.review.module.patter.mvvm;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.easyway.review.R;
import com.easyway.review.databinding.ActivityMvvmBinding;

/**
 * 提供View ，ViewModel 以及Model三层
 * 将布局修改为DataBinding布局
 * View与ViewModel之间通过DataBinding进行通信
 * 获取数据并展示在界面上
 */
public class MVVMActivity extends AppCompatActivity {

    private ActivityMvvmBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm);
        ViewModel viewModel = new ViewModel(binding);
        binding.setViewModel(viewModel);

    }
}
