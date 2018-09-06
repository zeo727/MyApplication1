package com.example.zzz.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private Button mBtnTest;
    private Button btn1;
    private TextView t1;
    private AutoCompleteTextView acTextView;
    //3.初始化一个数据源---这数据源去匹配文本框输入的内容
    private String[] res = {"beijing1", "beijing2", "beijing3", "shanghai1", "shanghai2"};
    private MultiAutoCompleteTextView macTextView;

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("TAG","MainActivity-->onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("TAG","MainActivity-->onStop");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("TAG","MainActivity-->onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("TAG","MainActivity-->onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("TAG","MainActivity-->onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("TAG","MainActivity-->onDestroy");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("TAG","MainActivity-->onCreate");


        macTextView = findViewById(R.id.multiAutoCompleteTextView);
        t1 = findViewById(R.id.textView3);
        mBtnTest = findViewById(R.id.btn_test);
        btn1=findViewById(R.id.button1);

        /*btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                MainActivity.this.startActivity(intent);
            }
        });*/


        //1.初始化控件
        acTextView = findViewById(R.id.autoCompleteTextView);
        //2.需要一个适配器
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, res);
        //4.将adpter与当前AutoCompleteTextView绑定
        acTextView.setAdapter(adapter);


        macTextView.setAdapter(adapter);
        //设置以逗号为结束的分隔符；
        macTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());


        String s1 = "<font color='blue'><b>百度一下，你就知道~：</b></font><br>";
        s1 += "<a href = 'http://www.baidu.com'>百度</a>";
        t1.setText(Html.fromHtml(s1));
        t1.setMovementMethod(LinkMovementMethod.getInstance());



        /*
         * 1.匿名内部类实现点击事件
         */
        /*mBtnTest.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Test被点击", Toast.LENGTH_SHORT).show();
            }
        });*/
        mBtnTest.setOnClickListener(new MyOnClickListener() {
            @Override
            public void onClick(View v) {
                super.onClick(v);
                Toast.makeText(MainActivity.this,
                        "Test被点击", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

/*
 * 2.外部类实现点击事件
 */
class MyOnClickListener implements View.OnClickListener {
    @Override
    public void onClick(View v) {
        Log.i("tag", "父类的Onclick事件");
        v.setAlpha(0.5f);
    }

}

