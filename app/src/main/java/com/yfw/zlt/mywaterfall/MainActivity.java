package com.yfw.zlt.mywaterfall;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.yfw.zlt.mywaterfall.base.BaseActivity;
import com.yfw.zlt.mywaterfall.common.Constants;
import com.yfw.zlt.mywaterfall.fragment.WaterfallFragment;

public class MainActivity extends BaseActivity implements View.OnClickListener,AdapterView.OnItemClickListener{
    private Toolbar toolbar;
    private DrawerLayout drawer;
    private ListView list;
    private String [] array = {"条目1","条目2","条目3"};
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,array);
        setTitle();
        initView();

    }

    /**
     * 实现BaseActivity里的showItem方法显示瀑布流
     * @param Position
     */
    @Override
    protected void showItem(int Position) {
//        WaterFallFragment fragment = null;
//        switch (position) {
//            case Global.FIRST_POSITION:
//                fragment = new WaterFallFragment();
//                break;
//            default:
//                break;
//        }
//        getSupportFragmentManager().beginTransaction().replace(R.id.mian_layout, fragment).commit();
        WaterfallFragment fragment=null;
        switch (Position){
            case Constants.FIRST_POSITION:
                fragment=new WaterfallFragment();
                break;
            default:
                break;
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.mian_layout, fragment).commit();
    }
    /**
     * 设置标题
     */
    protected void setTitle(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        //设置toolbar标题
        toolbar.setTitle("Drawer");
        //设置Navigation
        toolbar.setNavigationIcon(R.mipmap.logoloading);
        //为了让ToolBar各项设置都生效的话，这个方法必须放到最后
        setSupportActionBar(toolbar);
        //设置点击Navigation的方法
        toolbar.setNavigationOnClickListener(this);
    }
    private void initView(){//初始化
        drawer = (DrawerLayout) findViewById(R.id.drawer);
        list = (ListView) findViewById(R.id.listDrawer);
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);
    }

    /**
     * 此方法定义Menu的布局样式，返回false则不显示Menuq
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    /**
     * 此方法定义点击Menu按钮产生的事件
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.action_settings){
            //点击侧滑弹出的事件
            if(drawer.isDrawerOpen(Gravity.RIGHT)){
                drawer.closeDrawer(Gravity.RIGHT);
            }else {
                drawer.openDrawer(Gravity.RIGHT);
            }
            return true;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.toolbar:

                break;
        }
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {//条目点击事件
        Object itemAtPosition = list.getItemAtPosition(position);
//        Toast.makeText(MainActivity.this,"1111"+view.getId()+":"+position+":"+itemAtPosition,Toast.LENGTH_SHORT).show();
//        Log.i("ii","qqqqqqqqq"+itemAtPosition);
    }
}
