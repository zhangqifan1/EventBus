package com.example.anadministrator.eventbus2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * btn_bty
     */
    private Button butJump;
    /**
     * btn_bty
     */
    private Button mBtnTry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();


    }

    private void initView() {
        butJump = (Button) findViewById(R.id.butJump);
        butJump.setOnClickListener(this);
        mBtnTry = (Button) findViewById(R.id.butSend);
        mBtnTry.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.butJump:
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
                break;
            case R.id.butSend:
                List<String> list=new ArrayList<>();
                for (int i = 0; i < 10; i++) {
                    list.add("ndiasjdias");
                }
                EventMessage message = new EventMessage("发消息到Main2");
                message.setList(list);
                EventBus.getDefault().postSticky(message);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
