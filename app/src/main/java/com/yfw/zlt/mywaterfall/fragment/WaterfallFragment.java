package com.yfw.zlt.mywaterfall.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yfw.zlt.mywaterfall.R;
import com.yfw.zlt.mywaterfall.adapter.ItemAdapter;
import com.yfw.zlt.mywaterfall.base.BaseFragment;
import com.yfw.zlt.mywaterfall.base.SpaceItem;

import java.util.ArrayList;

/**
 * Created by zlt on 2016/5/10.
 */
public class WaterfallFragment extends BaseFragment {
    private RecyclerView mRecycler;
    private int spanCount=2;
    private ArrayList<String> items = new ArrayList<>();
    private ItemAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.waterfallfragment, container, false);
        init(v);
        return v;
    }

    private void init(View v) {
        mRecycler = (RecyclerView) v.findViewById(R.id.recycler);
        //mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mRecycler.setLayoutManager(new StaggeredGridLayoutManager(spanCount,StaggeredGridLayoutManager.VERTICAL));

        //构建一个临时数据源
        for (int i = 0; i < 100; i++) {
            items.add("i:" + i);
        }
        mAdapter = new ItemAdapter(items);
        mRecycler.setAdapter(mAdapter);
        SpaceItem item = new SpaceItem(10);
        mRecycler.addItemDecoration(item);
    }
}
