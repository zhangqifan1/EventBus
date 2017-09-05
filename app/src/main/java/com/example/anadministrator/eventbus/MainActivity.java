package com.example.anadministrator.eventbus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends Activity {

        Button btn;
        TextView tv;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            EventBus.getDefault().register(this);

            btn = (Button) findViewById(R.id.btn_try);
            tv = (TextView)findViewById(R.id.tv);

            btn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    Intent intent = new Intent(getApplicationContext(),
                            SecondActivity.class);
                    startActivity(intent);
                }
            });
        }
        @Subscribe
        public void aa(EventBusMessage event) {

            String msg = "aa：" + event.getMessage();
            Log.d("harvic", msg);
            tv.setText(msg);
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
        }

        @Override
        protected void onDestroy(){
            super.onDestroy();
            EventBus.getDefault().unregister(this);
        }
    }