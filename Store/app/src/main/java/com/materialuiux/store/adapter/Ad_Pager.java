package com.materialuiux.store.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.materialuiux.store.R;
import com.materialuiux.store.model.glasses;

import java.util.ArrayList;
import java.util.Map;

public class Ad_Pager extends PagerAdapter {


    private Context mContext;
    LayoutInflater mLayoutInflater;
    private ArrayList<glasses>  mResources;

    public Ad_Pager(Context context, ArrayList<glasses> data) {
        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mResources = data;
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View itemView = mLayoutInflater.inflate(R.layout.item_pager, container, false);
        ImageView imageView = itemView.findViewById(R.id.ImagePager);
        TextView textView = itemView.findViewById(R.id.id_title);
        textView.setText(mResources.get(position).getBrand());
        Glide.with(mContext).load(mResources.get(position).getUrlImage()).into(imageView);
        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return mResources.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
