package com.easyway.review.module.patter.mvvm;

import android.app.Application;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;

import com.easyway.review.BR;
import com.easyway.review.databinding.ActivityMvvmBinding;
import com.easyway.review.module.patter.mvc.callback.MCallBack;
import com.easyway.review.module.patter.mvc.model.Account;

/**
 * @Package: com.easyway.review.module.patter.mvvm.MVVMViewModel
 * @Author: 侯建军
 * @CreateDate: 2020/1/7 15:54
 * @Description: 请填写描述
 */
public class MVVMViewModel extends BaseObservable {
    private String result;
    private MVVMModel mvvmModel;
    private ActivityMvvmBinding binding;

    @Bindable
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
        notifyPropertyChanged(BR.result);
    }

    public MVVMViewModel(Application application) {
        mvvmModel = new MVVMModel();
    }

    public MVVMViewModel(Application application, ActivityMvvmBinding binding) {
        mvvmModel = new MVVMModel();
        this.binding = binding;
    }

    public void getData(View view) {
        mvvmModel.getAccountdata(binding.edtInput.getText().toString(), new MCallBack() {
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
