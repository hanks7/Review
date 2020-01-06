package com.easyway.review.module.patter.mvc.normal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.easyway.review.R;
import com.easyway.review.module.patter.mvc.callback.MCallBack;
import com.easyway.review.module.patter.mvc.model.Account;
import com.easyway.review.module.patter.mvc.model.MvcModel;

import butterknife.BindView;
/**
 *
 * @Package:        com.easyway.review.module.patter.mvc.normal.MvcActivity
 * @Author:         侯建军
 * @CreateDate:     2020/1/6 13:20
 * @Description:    mvc :   缺点：control层与view难以完全解耦（activity既是控制器，又要承担部分视图工作）
 */
public class MvcActivity extends AppCompatActivity {
    @BindView(R.id.edt_input)
    EditText edtInput;
    @BindView(R.id.btn_commit)
    Button btnCommit;
    @BindView(R.id.tv_info)
    TextView tvInfo;

    MvcModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);
          model=new MvcModel();
    }

    public void btnClick(View view) {
        model.getAccountdata(getUserInput(), new MCallBack() {
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

    String getUserInput() {
        return edtInput.getText().toString();
    }

    void showSuccessPage(Account bean) {
        tvInfo.setText("用户账号：" + bean.getName() + "   用户等级 ：" + bean.getLevel());
    }

    void showFailPage() {
        tvInfo.setText("获取数据失败");
    }
}
