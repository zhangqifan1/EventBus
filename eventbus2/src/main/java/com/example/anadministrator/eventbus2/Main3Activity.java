package com.example.anadministrator.eventbus2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class Main3Activity extends AppCompatActivity {

    /**
     * 收到的消息:
     */
    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initView();
        EventBus.getDefault().register(this);
        System.out.println("onCreate");

    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("onStart");
    }

    @Subscribe(sticky = false)
    public void onEventMainThread(EventMessage event) {
        System.out.println("onEventMainThread");
        String msg = "onEventMainThread收到了消息：" + event.getMessage();
        mTv.setText(msg);
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    private void initView() {
        mTv = (TextView) findViewById(R.id.tv3);
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        EventBus.getDefault().removeAllStickyEvents();
        EventBus.getDefault().unregister(this);
    }
}