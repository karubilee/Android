package com.example.karubi.uiwidgettest;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
//
//public class MainActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        Button button = (Button) findViewById(R.id.button);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //在此添加逻辑
//            }
//        });
//    }
//}

//不喜欢用匿名类的方式来注册监听器也可以用实现接口的方式来进行注册,
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    private EditText editText;
    private ImageView imageView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
        editText = (EditText) findViewById(R.id.edit_text);
        imageView = (ImageView) findViewById(R.id.image_view);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                Log.d(TAG, "onClick: button");
                String inputText = editText.getText().toString();
                Toast.makeText(MainActivity.this,inputText,Toast.LENGTH_SHORT).show();

                imageView.setImageResource(R.drawable.image_1);
                break;
            case R.id.text_view:
                //不具有点击属性?
                Log.d(TAG, "onClick: text_view");
                break;
            case R.id.activity_main:
                //不具有点击属性?
                Log.d(TAG, "onClick: activity_main");
                break;
            default:
                break;
        }
    }
}
