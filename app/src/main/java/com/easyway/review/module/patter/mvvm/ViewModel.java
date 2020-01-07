package com.easyway.review.module.patter.mvvm;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;

import com.easyway.review.BR;
import com.easyway.review.databinding.ActivityMvvmBinding;
import com.easyway.review.module.patter.mvc.callback.MCallBack;
import com.easyway.review.module.patter.mvc.model.Account;

/**
 * @Package: com.easyway.review.module.patter.mvvm.ViewModel
 * @Author: 侯建军
 * @CreateDate: 2020/1/7 15:54
 * @Description: 请填写描述
 */
public class ViewModel extends BaseObservable {


    private Model model;
    private ActivityMvvmBinding binding;


    private String userInput;

    @Bindable
    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
        notifyPropertyChanged(BR.userInput);
    }

    private String result;

    @Bindable
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
        notifyPropertyChanged(BR.result);
    }

    public ViewModel() {
        model = new Model();
    }

    public ViewModel(ActivityMvvmBinding binding) {
        model = new Model();
        this.binding = binding;
    }

    public void getData(View view) {
        model.getAccountdata(userInput, new MCallBack() {
            @Override
            public void onSuccess(Account bean) {
                String info = bean.getName() + " | " + bean.getLevel();
                setResult(info);
            }

            @Override
            public void onFail() {
                setResult("获取数据失败");
            }
        });
    }


}
