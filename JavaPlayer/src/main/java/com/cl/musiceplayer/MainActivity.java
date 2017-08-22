package com.cl.musiceplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.widget.Toast;

import com.cl.musiceplayer.activity.PlayerActivity;
import com.cl.musiceplayer.bean.TabEntity;
import com.cl.musiceplayer.fragment.MusicListFragment;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {
    private CommonTabLayout tabLayout;
    private ArrayList<CustomTabEntity> customTabEntities = new ArrayList<>();            //
    private ArrayList<Fragment> fragments = new ArrayList<>();
    private int mCurrentTab = 0;
    private int[] selectIcon = {R.mipmap.list_no,R.mipmap.player_yes};
    private int[] unSelectIcon = {R.mipmap.list_yes,R.mipmap.player_no};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        listener();
    }

    private void listener() {
        tabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
               switch (position){
                   case 1:
                       jumpActivityForResult(PlayerActivity.class);
               }
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
    }

    private void init() {
        tabLayout = (CommonTabLayout) findViewById(R.id.ctl_layout);
        String[] titles = getResources().getStringArray(R.array.titles);
        for (int i = 0; i < titles.length; i++) {
            customTabEntities.add(new TabEntity(titles[i],selectIcon[i],unSelectIcon[i]));
        }
        fragments.add(MusicListFragment.newInstence());
        fragments.add(new Fragment());
        tabLayout.setTabData(customTabEntities,this,R.id.fl_layout,fragments);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        long mExitTime = 0L;
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                Toast.makeText(this, "再按一次返回键退出快掌柜", Toast.LENGTH_SHORT).show();
                mExitTime = System.currentTimeMillis();
            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            switch (requestCode){
                case 1:
                    break;
                default:
                    tabLayout.setCurrentTab(0);
                    break;
            }
        }
    }
}
