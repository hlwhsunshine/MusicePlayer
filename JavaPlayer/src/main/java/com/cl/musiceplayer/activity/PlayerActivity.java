package com.cl.musiceplayer.activity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.TextView;

import com.cl.musiceplayer.BaseActivity;
import com.cl.musiceplayer.R;

import static android.app.Activity.RESULT_OK;

public class PlayerActivity extends BaseActivity {
    private ImageView ivBack;
    private TextView tvTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        init();
        back();
        setTitleName("正在播放");
    }

    private void init() {
        ivBack = (ImageView) findViewById(R.id.iv_back);
        tvTitle = (TextView) findViewById(R.id.tv_title);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        setResult(RESULT_OK);
        return super.onKeyDown(keyCode, event);
    }
}
