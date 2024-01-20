package com.materialuiux.store.adapter.holder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.materialuiux.store.R;
import com.materialuiux.store.adapter.Ad_Pager;
import com.materialuiux.store.model.glasses;
import java.util.ArrayList;

public class Holder_One_Item  extends RecyclerView.ViewHolder implements ViewPager.OnPageChangeListener {


    ViewPager mImageViewPager;
    private Ad_Pager mAdapter;
    private LinearLayout pager_indicator;
    private int dotsCount;
    private ImageView[] dots;
    private Context mContext;

    public Holder_One_Item(@NonNull View itemView, Context context) {
        super(itemView);
        this.mContext = context;
        mImageViewPager = itemView.findViewById(R.id.pager);
        pager_indicator = itemView.findViewById(R.id.viewPagerCountDots);


    }

    public void setView(ArrayList<glasses> data) {
        mAdapter = new Ad_Pager(mContext, data);
        mImageViewPager.setAdapter(mAdapter);
        mImageViewPager.setCurrentItem(0);
        mImageViewPager.setOnPageChangeListener(this);

        setPageViewIndicator();
    }

    private void setPageViewIndicator() {

        Log.d("###setPageViewIndicator", " : called");
        dotsCount = mAdapter.getCount();
        dots = new ImageView[dotsCount];

        for (int i = 0; i < dotsCount; i++) {
            dots[i] = new ImageView(mContext);
            dots[i].setImageDrawable(mContext.getResources().getDrawable(R.drawable.nonselecteditem_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

            params.setMargins(4, 0, 4, 0);

            final int presentPosition = i;
            dots[presentPosition].setOnTouchListener(new View.OnTouchListener() {

                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    mImageViewPager.setCurrentItem(presentPosition);
                    return true;
                }

            });


            pager_indicator.addView(dots[i], params);
        }

        dots[0].setImageDrawable(mContext.getResources().getDrawable(R.drawable.selecteditem_dot));
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

        Log.d("###onPageSelected, pos ", String.valueOf(position));
        for (int i = 0; i < dotsCount; i++) {
            dots[i].setImageDrawable(mContext.getResources().getDrawable(R.drawable.nonselecteditem_dot));
        }

        dots[position].setImageDrawable(mContext.getResources().getDrawable(R.drawable.selecteditem_dot));

        if (position + 1 == dotsCount) {

        } else {

        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


}
