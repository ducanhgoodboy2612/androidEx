package com.materialuiux.store.adapter.holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.materialuiux.store.R;

public class Holder_Arrivals extends RecyclerView.ViewHolder {

    private ImageView imageView;
    private TextView Title , Body , Price;

    public Holder_Arrivals(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.id_image);
        Title = itemView.findViewById(R.id.id_title_tx);
        Body = itemView.findViewById(R.id.id_body_tx);
        Price = itemView.findViewById(R.id.id_price);
    }

    public ImageView getImageView() {
        return imageView;
    }

    public TextView getTitle() {
        return Title;
    }

    public TextView getBody() {
        return Body;
    }

    public TextView getPrice() {
        return Price;
    }
}
