package com.materialuiux.store.adapter;

import android.annotation.SuppressLint;
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
import com.materialuiux.store.model.glasses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Ad_Main extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int TYPE_FIRST_ITEM = 3;
    public static final int TYPE_ONE_ITEM = 0;
    public static final int TYPE_TWO_ITEM = 1;

    private ArrayList<Integer> mResources;
    private Context context;
    int i = 0 ;

    public Ad_Main(Activity activity, ArrayList<Integer> getimages) {
        this.context = activity;
        mResources = getimages;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        switch (viewType) {
            case TYPE_FIRST_ITEM:
                View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_first_main, viewGroup, false);
                return new Holder_First_Item(view, context);
            case TYPE_ONE_ITEM:
                View view1 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_one_main, viewGroup, false);
                return new Holder_One_Item(view1, context);
            case TYPE_TWO_ITEM:
                View view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_two_main, viewGroup, false);
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
                FirstView.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, ArrivalsActivity.class);
                        context.startActivity(intent);
                    }
                });
                FirstView.tx_title.setText("300+ NEW ITEM");
                FirstView.tx_body.setText("New Arrivals");
                break;

            case TYPE_TWO_ITEM:
                Holder_Tow_Item TwoView = (Holder_Tow_Item) viewHolder;
                Glide.with(context).load(mResources.get(i++)).into(TwoView.rightImage);
                Glide.with(context).load(mResources.get(i++)).into(TwoView.leftImage);
                if (i > 4){
                    TwoView.bodyTx1.setVisibility(View.GONE);
                    TwoView.bodyTx2.setVisibility(View.GONE);
                    TwoView.shopeWomenTx.setVisibility(View.GONE);
                    TwoView.shopeManTx.setVisibility(View.GONE);
                }
                break;

            case TYPE_ONE_ITEM:
                Holder_One_Item OneView = (Holder_One_Item) viewHolder;
                ArrayList<glasses> arrayList = new ArrayList<>();
                arrayList.add(new glasses(mResources.get(i++),"Ray‑Ban"));
                arrayList.add(new glasses(mResources.get(i++),""));
                arrayList.add(new glasses(mResources.get(i++),""));

                OneView.setView(arrayList);
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
                return TYPE_ONE_ITEM;
            } else return TYPE_TWO_ITEM;
        }

    }


}
