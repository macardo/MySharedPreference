package com.macardo.mysharedpreference;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText mEtKey,mEtValue;
    private Button mBtnSave;
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

        mBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //保存用户输入的键值对
                String key = mEtKey.getText().toString().trim();
                String value = mEtValue.getText().toString().trim();
//                SharedPreferences sharedpreferences = MainActivity.this.getSharedPreferences("macardo", MODE_PRIVATE);//创建名为macardo的XML文件
                SharedPreferences sharedpreferences =PreferenceManager.getDefaultSharedPreferences(MainActivity.this);//创建以包名为前缀的XML文件
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(key,value);
//                editor.commit();//同步保存
                editor.apply();//异步保存（不会阻塞到当前线程，推荐）
            }
        });
    }
}
