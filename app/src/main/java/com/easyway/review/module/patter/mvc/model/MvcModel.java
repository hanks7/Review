package com.easyway.review.module.patter.mvc.model;

import com.easyway.review.module.patter.mvc.callback.MCallBack;

import java.util.Random;

/**
 * @author 侯建军 QQ:474664736
 * @time 2020/1/6 13:13
 * @class describe
 */
public class MvcModel {
    public void getAccountdata(String strAccount, MCallBack back) {
        Random random = new Random();
        boolean isSuccess = random.nextBoolean();

        if (isSuccess) {
            Account bean = new Account(strAccount, 100);
            back.onSuccess(bean);
        } else {
            back.onFail();
        }
    }
}
