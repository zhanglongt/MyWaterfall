package com.yfw.zlt.mywaterfall.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.yfw.zlt.mywaterfall.R;

import java.util.ArrayList;

/**
 * Created by zlt on 2016/5/10.
 */
public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder>{
    private ArrayList<String> items = new ArrayList<>();
    public ItemAdapter(ArrayList<String> items) {
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_waterfall_list_item,
                parent, false);
        return new ViewHolder(view);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String info = items.get(position);
        Log.i("ii",info);
        View view = holder.itemView;
        ImageView textView = (ImageView) view.findViewById(R.id.waterfall_item_image);
        textView.setImageResource(R.mipmap.ic_launcher);
        //手动更改高度，不同位置的高度有所不同
        //textView.setHeight(100 + (position % 3) * 30);
       // holder.textView.setText(mJoke.getDetail().get(position).getContent());

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
