package com.cl.musiceplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/8/22.
 */

public class BaseActivity extends AppCompatActivity {
    private TextView textView;
    private ImageView imageView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       /* setContentView(R.layout.top_title_layout);
        textView = (TextView)findViewById(R.id.tv_title);
        imageView = (ImageView)findViewById(R.id.iv_back);*/
    }

    public void back(){
        View view = findViewById(R.id.iv_back);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK);
                finish();
            }
        });
    }


    public void setTitleName(String title) {
        TextView textView = (TextView) findViewById(R.id.tv_title);
        textView.setText(title);
    }
    public void jumpActivityForResult(Class cla){
        startActivityForResult(new Intent(this,cla),111);
    }
}
