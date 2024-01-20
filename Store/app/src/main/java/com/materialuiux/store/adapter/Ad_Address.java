package com.materialuiux.store.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.materialuiux.store.R;
import com.materialuiux.store.adapter.holder.Holder_Address;

public class Ad_Address extends RecyclerView.Adapter<Holder_Address> {
    @NonNull
    @Override
    public Holder_Address onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_address, viewGroup, false);
        return new  Holder_Address(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder_Address holder_address, int i) {

    }

    @Override
    public int getItemCount() {
        return 1;
    }
}
