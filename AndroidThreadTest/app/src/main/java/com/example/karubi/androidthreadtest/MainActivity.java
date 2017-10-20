package com.example.karubi.androidthreadtest;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import static com.example.karubi.androidthreadtest.R.id.text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int UPDATE_TEXT = 1;
    private Handler handler = new Handler() {
        public void  handleMessage(Message msg) {
            switch (msg.what) {
                case UPDATE_TEXT:
                    //在这里可以进行UI操作
                    text.setText("Nice To Meet you");
                    break;
                default:
                    break;
            }
        }
    };


        private TextView text;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            text = (TextView) findViewById(R.id.text);
            Button changeText = (Button) findViewById(R.id.change_text);
            changeText.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.change_text:
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            Message message = new Message();
                            message.what = UPDATE_TEXT;
                            handler.sendMessage(message);
                        }
                    }).start();
            }
        }
    }
