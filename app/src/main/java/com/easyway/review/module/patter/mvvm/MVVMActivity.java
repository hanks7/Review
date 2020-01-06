package com.easyway.review.module.patter.mvvm;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.easyway.review.R;
import com.easyway.review.databinding.ActivityMvvmBinding;
import com.easyway.review.module.patter.mvc.model.Account;

/**
 * @Package: com.easyway.review.module.patter.mvvm.MVVMActivity
 * @Author: 侯建军
 * @CreateDate: 2020/1/6 15:43
 * @Description: 请填写描述
 */
public class MVVMActivity extends AppCompatActivity {
    ActivityMvvmBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm);


    }

    public void commit(View view) {
        Account bean = new Account("hanks7", 123);
        binding.setAccount(bean);
    }
}
