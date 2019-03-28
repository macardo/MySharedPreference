package com.macardo.mysharedpreference;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText mEtKey,mEtValue;
    Button mBtnSave;

    EditText mEtReadKey;
    TextView mTvReadValue;
    Button mBtnRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        mEtKey = findViewById(R.id.etKEY);
        mEtValue = findViewById(R.id.etVALUE);
        mBtnSave = findViewById(R.id.btnSave);
        mEtReadKey =findViewById(R.id.etReadKEY);
        mTvReadValue = findViewById(R.id.tvReadVALUE);
        mBtnRead = findViewById(R.id.btnRead);

        mBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //保存用户输入的键值对
                String key = mEtKey.getText().toString().trim();
                String value = mEtValue.getText().toString().trim();

/*
                SharedPreferences sharedpreferences = MainActivity.this.getSharedPreferences("macardo", MODE_PRIVATE);//创建名为macardo的XML文件
//                SharedPreferences sharedpreferences =PreferenceManager.getDefaultSharedPreferences(MainActivity.this);//创建以包名为前缀的XML文件
                SharedPreferences.Editor editor = sharedpreferences.edit();//获取editorlmpl对象
                editor.putString(key,value);//传入键值对形式的数据
//                editor.commit();//同步保存
                editor.apply();//异步保存（不会阻塞当前线程，推荐）
*/
                SharedPreferencesUtil.getInstance().put(MainActivity.this,key,value);
            }
        });

        mBtnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //读取用户输入key的value
                String key = mEtReadKey.getText().toString().trim();

                /*
                SharedPreferences sharedpreferences = MainActivity.this.getSharedPreferences("macardo",MODE_PRIVATE);
                String value = sharedpreferences.getString(key, "null");
                */

                String value = (String) SharedPreferencesUtil.getInstance().get(MainActivity.this, key, "null");
                mTvReadValue.setText(value);
            }
        });
    }
}
