package com.materialuiux.store.adapter.holder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.materialuiux.store.R;
import com.materialuiux.store.adapter.Ad_Pager;
import com.materialuiux.store.model.glasses;

import java.util.ArrayList;

public class Holder_Tow_V_Item extends RecyclerView.ViewHolder {

    private Context mContext;

    public ImageView imageView1, imageView2;


    public Holder_Tow_V_Item(@NonNull View itemView, Context context) {
        super(itemView);

        imageView1 = itemView.findViewById(R.id.id_Image_1);
        imageView2 = itemView.findViewById(R.id.id_Image_2);

    }


}
