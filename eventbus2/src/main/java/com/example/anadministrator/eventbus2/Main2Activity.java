package com.example.anadministrator.eventbus2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 收到的消息:
     */
    private TextView mTv;
    /**
     * 跳转到第三个Activity
     */
    private Button mButTo3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        EventBus.getDefault().register(this);
        System.out.println("onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("onStart");
    }

    @Subscribe(sticky = true)
    public void onEventMainThread(EventMessage event) {
        System.out.println("onEventMainThread");
        String msg = "onEventMainThread收到了消息：" + event.getMessage();
        List<String> list = event.getList();
        mTv.setText(list.get(5));
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    private void initView() {
        mTv = (TextView) findViewById(R.id.tv);
        mButTo3 = (Button) findViewById(R.id.butTo3);
        mButTo3.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().removeAllStickyEvents();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.butTo3:
                startActivity(new Intent(Main2Activity.this,Main3Activity.class));
                break;
        }
    }
}
