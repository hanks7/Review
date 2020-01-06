package com.easyway.review.module.patter.mvc.normal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.easyway.review.R;
import com.easyway.review.module.patter.mvc.callback.MCallBack;
import com.easyway.review.module.patter.mvc.model.Account;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NormalActivity extends AppCompatActivity {

    @BindView(R.id.edt_input)
    EditText edtInput;
    @BindView(R.id.tv_info)
    TextView tvInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);
        ButterKnife.bind(this);
    }


    String getUserInput() {
        return edtInput.getText().toString();
    }

    void showSuccessPage(Account bean) {
        tvInfo.setText("用户账号：" + bean.getName() + "   用户等级 ：" + bean.getLevel());
    }

    void showFailPage() {
        tvInfo.setText("获取数据失败");
    }

    /**
     * 所谓mvc就是把处理业务数据的逻辑代码放在model层中 比如你如何得到数据的代码，下面的这个方法就是这种情况
     * @param strAccount
     * @param back
     */
    void getAccountdata(String strAccount, MCallBack back) {
        Random random = new Random();
        boolean isSuccess = random.nextBoolean();

        if (isSuccess) {
            Account bean = new Account(strAccount, 100);
            back.onSuccess(bean);
        } else {
            back.onFail();
        }
    }

    /**
     * 所谓mvp就是在 主要业务代码提取单独成类，方便后期维护。
     * @param view
     */
    public void btnClick(View view) {
        getAccountdata(getUserInput(), new MCallBack() {
            @Override
            public void onSuccess(Account bean) {
                showSuccessPage(bean);
            }

            @Override
            public void onFail() {
                showFailPage();
            }
        });
    }
}
