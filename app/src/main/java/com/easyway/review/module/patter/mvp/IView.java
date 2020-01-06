package com.easyway.review.module.patter.mvp;

import com.easyway.review.module.patter.mvc.model.Account;

/**
 * @author 侯建军 QQ:474664736
 * @time 2020/1/6 13:30
 * @class describe
 */
public interface IView {

    String getUserInput();

    void showSuccessPage(Account bean);


    void showFailPage();

}
