package com.easyway.review.module.patter.mvc.callback;

import com.easyway.review.module.patter.mvc.model.Account;

/**
 * @author 侯建军 QQ:474664736
 * @time 2020/1/6 10:50
 * @class describe
 */
public interface MCallBack {
    void onSuccess(Account bean);
    void onFail();
}
