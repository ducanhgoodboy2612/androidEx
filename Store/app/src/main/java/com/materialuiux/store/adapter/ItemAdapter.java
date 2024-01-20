package com.materialuiux.store.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;


import com.materialuiux.store.R;
import com.materialuiux.store.adapter.holder.Holder_Wish_List;

import java.security.AccessControlContext;
import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<Holder_Wish_List> {

    Context context;
    ArrayList<String> item;

    public ItemAdapter(Context context, ArrayList<String> itemSet) {
        this.context = context;
        item =itemSet;
    }


    @NonNull
    @Override
    public Holder_Wish_List onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new Holder_Wish_List(LayoutInflater.from(context).inflate(R.layout.item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Holder_Wish_List holder, int i) {

    }

    @Override
    public int getItemCount() {
        return item.size();
    }
}

