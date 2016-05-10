package com.yfw.zlt.mywaterfall.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.yfw.zlt.mywaterfall.common.Constants;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showItem(Constants.FIRST_POSITION);//显示瀑布流的条目

    }

    protected abstract void showItem(int Position);

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
