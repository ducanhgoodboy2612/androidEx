package com.materialuiux.store.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.materialuiux.store.ArrivalsActivity;
import com.materialuiux.store.R;
import com.materialuiux.store.adapter.holder.Holder_First_Item;
import com.materialuiux.store.adapter.holder.Holder_One_Item;
import com.materialuiux.store.adapter.holder.Holder_Tow_Item;
import com.materialuiux.store.adapter.holder.Holder_Tow_V_Item;
import com.materialuiux.store.model.glasses;

import java.util.ArrayList;

public class Ad_Blog extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    public static final int TYPE_FIRST_ITEM = 3;
    public static final int TYPE_TWO_V_ITEM = 0;
    public static final int TYPE_TWO_ITEM = 1;

    private ArrayList<Integer> mResources;
    private Context context;
    int i = 0 ;

    public Ad_Blog(Activity activity, ArrayList<Integer> getimages) {
        this.context = activity;
        mResources = getimages;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        switch (viewType) {
            case TYPE_FIRST_ITEM:
                View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_first_blog, viewGroup, false);
                return new Holder_First_Item(view, context);
            case TYPE_TWO_V_ITEM:
                View view1 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_two_v_blog, viewGroup, false);
                return new Holder_Tow_V_Item(view1, context);
            case TYPE_TWO_ITEM:
                View view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_two_blog, viewGroup, false);
                return new Holder_Tow_Item(view2, context);
            default:
                return null;
        }
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        switch (viewHolder.getItemViewType()) {

            case TYPE_FIRST_ITEM:
                Holder_First_Item FirstView = (Holder_First_Item) viewHolder;
                Glide.with(context).load(mResources.get(i++)).into(FirstView.imageView);
                break;

            case TYPE_TWO_ITEM:
                Holder_Tow_Item TwoView = (Holder_Tow_Item) viewHolder;
                Glide.with(context).load(mResources.get(i++)).into(TwoView.rightImage);
                Glide.with(context).load(mResources.get(i++)).into(TwoView.leftImage);

                break;

            case TYPE_TWO_V_ITEM:
                Holder_Tow_V_Item OneView = (Holder_Tow_V_Item) viewHolder;
                ArrayList<glasses> arrayList = new ArrayList<>();
                Glide.with(context).load(mResources.get(i++)).into(OneView.imageView1);
                Glide.with(context).load(mResources.get(i++)).into(OneView.imageView2);

                break;

        }
    }


    @Override
    public int getItemCount() {
        return 6;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_FIRST_ITEM;
        } else {
            if (position % 2 == 0) {
                return TYPE_TWO_V_ITEM;
            } else return TYPE_TWO_ITEM;
        }

    }
}
