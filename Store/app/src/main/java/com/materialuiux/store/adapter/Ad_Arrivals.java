package com.materialuiux.store.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.materialuiux.store.ArrivalsActivity;
import com.materialuiux.store.ProductCard;
import com.materialuiux.store.R;
import com.materialuiux.store.adapter.holder.Holder_Arrivals;
import com.materialuiux.store.adapter.holder.Holder_First_Item;
import com.materialuiux.store.model.Clothes;

import java.util.ArrayList;

public class Ad_Arrivals extends RecyclerView.Adapter<Holder_Arrivals> {


    Context mContext;

    ArrayList<Clothes> data;

    public Ad_Arrivals(Context context, ArrayList<Clothes> data) {
        this.mContext = context;
        this.data = data;
    }

    @NonNull
    @Override
    public Holder_Arrivals onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_arrivals, viewGroup, false);
        return new Holder_Arrivals(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder_Arrivals holder_arrivals, int position) {
        final Clothes clothes = data.get(position);
        Glide.with(mContext).load(clothes.getUrlImage()).into(holder_arrivals.getImageView());
        holder_arrivals.getTitle().setText(clothes.getTitlle());
        holder_arrivals.getBody().setText(clothes.getBrand());
        holder_arrivals.getPrice().setText("$ " + clothes.getPrice());
        holder_arrivals.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ProductCard.class);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
