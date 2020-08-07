package com.easyway.review.module.service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;

import com.easyway.review.IMyAidlInterface;
import com.easyway.review.R;
import com.easyway.review.base.BaseActivity;
import com.hanks.frame.utils.UToast;

/**
 * @Package: com.easyway.review.module.service.AidlActivity
 * @Author: 侯建军
 * @CreateDate: 2019/11/22 16:33
 * @Description: 用于让某个Service与多个应用程序组件之间进行跨进程通信
 * 实际上实现跨进程之间通信的有很多，
 * 比如广播，Content Provider，但是AIDL的优势在于速度快(系统底层直接是共享内存)，性能稳，效率高，一般进程间通信就用它
 * <p>
 * 参考文献 ： https://www.cnblogs.com/huangjialin/p/7738104.html
 */
public class AidlActivity extends BaseActivity {

    private Button btnStartService;
    private Button btnStopService;
    private Button btnBindService;
    private Button btnUnbindService;
    private Button bind_service_click_listener;
    /**
     * 绑定服务
     * bindService(bindService, connection, BIND_AUTO_CREATE);
     * 解绑服务
     * unbindService(connection);
     */
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myAIDLService = IMyAidlInterface.Stub.asInterface(service);

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            myAIDLService = null;
        }
    };

    private IMyAidlInterface myAIDLService;
    /**
     * 未防止未注册service 而出现Service not registered的错误.
     */
    private boolean isBind;

    @Override
    protected void setOnTranslucent() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        btnStartService = findViewById(R.id.start_service);
        btnStopService = findViewById(R.id.stop_service);
        btnBindService = findViewById(R.id.bind_service);
        btnUnbindService = findViewById(R.id.unbind_service);
        bind_service_click_listener = findViewById(R.id.bind_service_click_listener);


        /**
         * 开启服务
         */
        btnStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntentService();
                startService(intent);

            }
        });


        /**
         * 停止服务
         */
        btnStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(getIntentService());
            }
        });

        /**
         * 绑定服务
         */
        btnBindService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isBind = bindService(getIntentService(), connection, BIND_AUTO_CREATE);
            }
        });
        /**
         * 调用service中的方法
         */
        bind_service_click_listener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myAIDLService != null) {
                    try {
                        String str = myAIDLService.getString();
                        UToast.showText(str);

                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
        /**
         * 解绑服务
         */
        btnUnbindService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBind) {
                    unbindService(connection);
                    isBind = false;
                }
            }
        });
    }

    @NonNull
    private Intent getIntentService() {
        Intent intent = new Intent("aaa-service");
        intent.setPackage("com.easyway.review");
        return intent;
    }
}
