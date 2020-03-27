package com.easyway.review.module.patter.mvp;

import com.easyway.review.module.patter.mvc.callback.MCallBack;
import com.easyway.review.module.patter.mvc.model.Account;

/**
 * @author 侯建军 QQ:474664736
 * @time 2020/1/6 13:37
 * @class describe
 */
public class MVPPresenter {
    IView mView;
    MVPModel mModel;

    public MVPPresenter(IView mView) {
        this.mView = mView;
        mModel=new MVPModel();
    }

    public void setViewData() {
        mModel.dealData(mView.getUserInput(), new MCallBack() {
            @Override
            public void onSuccess(Account bean) {
                mView.showSuccessPage(bean);
            }

            @Override
            public void onFail() {
                mView.showFailPage();
            }
        });
    }
}
