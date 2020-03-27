package com.easyway.review.module.patter.mvvmdemo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.easyway.review.R;
import com.easyway.review.databinding.ActivityDemoMvvmBinding;
import com.easyway.review.module.patter.mvc.model.Account;
import com.hanks.frame.utils.UToast;

/**
 * @Package: com.easyway.review.module.patter.mvvm.MVVMDemoActivity
 * @Author: 侯建军
 * @CreateDate: 2020/1/6 15:43
 * @Description: 请填写描述
 */
public class MVVMDemoActivity extends AppCompatActivity {
    /**
     * 当layout改为databinding布局时，就是可以下面的对象，注意声明的名称是布局名称大写+Binding
     *
     * C:\Python27\;C:\ProgramData\Oracle\Java\javapath;%SystemRoot%\system32;%SystemRoot%;%SystemRoot%\System32\Wbem;%SYSTEMROOT%\System32\WindowsPowerShell\v1.0\;C:\Program Files\TortoiseSVN\bin;C:\Program Files\MySQL\MySQL Server 5.1\bin;%JAVA_HOME%\bin;%JAVA_HOME%;%JAVA_HOME%\jre\bin;%CATALINA_HOME%\bin;%MAVEN_HOME%\bin;C:\Program Files (x86)\Windows Kits\8.1\Windows Performance Toolkit\;C:\Program Files\Microsoft SQL Server\110\Tools\Binn\;%ANDROID_HOME%\platform-tools;C:\Users\hjj\AppData\Roaming\Nox\bin;C:\Program Files\Microsoft\Web Platform Installer\;C:\Program Files\VisualSVN Server\bin;C:\Program Files\TortoiseGit\bin;C:\ProgramFiles\ffmpeg\bin;C:\Program Files\Microsoft SQL Server\Client SDK\ODBC\110\Tools\Binn\;C:\Program Files (x86)\Microsoft SQL Server\120\Tools\Binn\ManagementStudio\;C:\Program Files (x86)\Microsoft SQL Server\120\Tools\Binn\;C:\Program Files\Microsoft SQL Server\120\Tools\Binn\C:\Program Files (x86)\Microsoft SQL Server\120\DTS\Binn\C:\Program Files\Microsoft SQL Server\120\DTS\Binn\%NDK-ROOT%
     */
    ActivityDemoMvvmBinding binding;
    Account bean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //取代 setContentView(R.layout.activity_normal);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_demo_mvvm);
        binding.setActivity(this);
        bean = new Account("hanks7", 123);
        binding.setBean(bean);
    }

    public void commit(View view) {
        bean.setName("张三");
        bean.setLevel(222);
        UToast.showText("ttt");
    }
}
