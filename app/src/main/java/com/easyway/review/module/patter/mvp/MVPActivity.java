package com.easyway.review.module.patter.mvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.easyway.review.R;
import com.easyway.review.module.patter.mvc.model.Account;

import butterknife.BindView;
/**
 *
 * @Package:        com.easyway.review.module.patter.mvp.MVPActivity
 * @Author:         侯建军
 * @CreateDate:     2020/1/6 15:30
 * @Description:    有点： 解决Mvc中controller与View过度耦合，职责划分明显，更加易于维护
 *                    缺点： 接口数量多，项目复杂度高。随着项目复杂度提升，Presenter层将越来越臃肿。
 *
 *                    建议：1.接口规范化（封装父类接口以减少接口的使用量）
 *                          2.使用第三方插件自动生成  MVP代码
 *                          3.对于一些简单的界面，可以选择不使用框架
 *                          4.根据项目的复杂程度，部分模块可以选择不使用接口
 */
public class MVPActivity extends AppCompatActivity implements IView {

    @BindView(R.id.edt_input)
    EditText edtInput;
    @BindView(R.id.tv_info)
    TextView tvInfo;

    MVPPresenter mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);
        mPresenter = new MVPPresenter(this);

    }

    public void btnClick(View view) {
        mPresenter.getData();
    }

    @Override
    public String getUserInput() {
        return edtInput.getText().toString();
    }

    @Override
    public void showSuccessPage(Account bean) {
        tvInfo.setText("用户账号：" + bean.getName() + "   用户等级 ：" + bean.getLevel());
    }

    @Override
    public void showFailPage() {
        tvInfo.setText("获取数据失败");
    }


}
