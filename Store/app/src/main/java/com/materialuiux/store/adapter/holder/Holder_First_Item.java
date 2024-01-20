package com.materialuiux.store.adapter.holder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.materialuiux.store.R;


public class Holder_First_Item extends RecyclerView.ViewHolder {

    private Context mContext;
    public ImageView imageView;
    public TextView tx_title,tx_body;

    public Holder_First_Item(@NonNull View itemView, Context context) {
        super(itemView);
        this.mContext = context;
        imageView = itemView.findViewById(R.id.id_first_item);
        tx_title = itemView.findViewById(R.id.id_title);
        tx_body = itemView.findViewById(R.id.id_body);

    }

}
