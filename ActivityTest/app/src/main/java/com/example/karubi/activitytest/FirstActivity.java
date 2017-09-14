package com.example.karubi.activitytest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.net.URL;

public class FirstActivity extends BaseActivity {

    private static final String TAG = "FirstActivity";
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this,"You click Add",Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this,"You click remove",Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return  true;
    }

    //requestCode 在Second中传入的请求吗
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String returnedData = data.getStringExtra("data_return");
                    Log.d(TAG, returnedData);
                }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        Log.d(TAG, this.toString());
        Log.d(TAG, "Task id is " + getTaskId());

        Button button1 = (Button)findViewById(R.id.button_1);
            button1.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
//                点击弹text
//                Toast.makeText(FirstActivity.this,"You clicked button1",Toast.LENGTH_SHORT).show();
//                销毁
//                finish();
//                    显示Intent
//                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
//                    隐式Intent
//                    Intent intent = new Intent("com.example.activitytext.ACTION_START");
//                    intent.addCategory("com.example.activitytest.MY_CATEGORY");
//                    更多隐式Intent的用法
//                    1.打开网页
//                    Intent intent = new Intent(Intent.ACTION_VIEW);
//                    intent.setData(Uri.parse("http://www.baidu.com"));
//                    2.打电话
//                    Intent intent = new Intent(Intent.ACTION_DIAL);
//                    intent.setData(Uri.parse("tel:10086"));
//                    2.3.4向下一个活动传递数据
//                    String data = "Hello SecondActivity";
//                    Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
//                    intent.putExtra("extra_data",data);

//                    startActivity方法  以上共用
//                    startActivity(intent);

//                    2.3.5 返回数据给上一个活动
//                    Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
//                    startActivityForResult(intent,1);

//                    2.5.1 standard
//                    Intent intent = new Intent(FirstActivity.this,FirstActivity.class);
//                    startActivity(intent);

//                    2.5.2 singleTop
//                    Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
//                    startActivity(intent);

//                    2.6.3 启动活动的最佳写法
                    SecondActivity.actionStart(FirstActivity.this,"data1","data2");
            }
        });
    }
}
