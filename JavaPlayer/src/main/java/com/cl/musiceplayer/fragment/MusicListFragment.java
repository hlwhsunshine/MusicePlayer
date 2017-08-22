package com.cl.musiceplayer.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cl.musiceplayer.R;
import com.cl.musiceplayer.adapter.MusicListAdapter;
import com.cl.musiceplayer.viewholder.ViewHolder;
import com.yanzhenjie.recyclerview.swipe.SwipeMenu;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuCreator;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuItem;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuRecyclerView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MusicListFragment extends Fragment {

    private SwipeMenuRecyclerView recyclerView;

    public MusicListFragment() {

    }

    public static MusicListFragment newInstence() {
        return new MusicListFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_music_list, container, false);
        recyclerView = (SwipeMenuRecyclerView) view.findViewById(R.id.smr_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setLongPressDragEnabled(false);// 开启长按拖拽
        recyclerView.setItemViewSwipeEnabled(true);// 开启滑动删除。
        recyclerView.setSwipeMenuCreator(mSwipeMenuCreator);
        recyclerView.setAdapter(new MusicListAdapter() {
            @Override
            public void convert(ViewHolder holder, T t) {

            }
        });
        // 设置监听器。


        return view;
    }
    // 创建菜单：
    SwipeMenuCreator mSwipeMenuCreator = new SwipeMenuCreator() {
        @Override
        public void onCreateMenu(SwipeMenu leftMenu, SwipeMenu rightMenu, int viewType) {
            SwipeMenuItem deleteItem = new SwipeMenuItem(getActivity());
             // 各种文字和图标属性设置。
            deleteItem.setBackgroundColor(getResources().getColor(R.color.white));
            deleteItem.setImage(R.mipmap.delete);
            deleteItem.setWidth(RecyclerView.LayoutParams.MATCH_PARENT);
            deleteItem.setHeight(RecyclerView.LayoutParams.MATCH_PARENT);
            deleteItem.setText("删除");
            deleteItem.setTextColor(getResources().getColor(R.color.red));
            rightMenu.addMenuItem(deleteItem); // 在Item左侧添加一个菜单。

        }
    };

}
