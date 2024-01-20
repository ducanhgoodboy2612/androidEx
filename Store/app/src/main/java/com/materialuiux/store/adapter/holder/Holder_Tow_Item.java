package com.materialuiux.store.adapter.holder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.materialuiux.store.R;

public class Holder_Tow_Item extends RecyclerView.ViewHolder {

    public ImageView rightImage, leftImage;
    public TextView shopeManTx , bodyTx2,shopeWomenTx,bodyTx1;
    Context mContext;

    public Holder_Tow_Item(@NonNull View itemView, Context context) {
        super(itemView);
        mContext = context;
        leftImage = itemView.findViewById(R.id.id_Image_L);
        rightImage = itemView.findViewById(R.id.id_Image_R);
        shopeManTx = itemView.findViewById(R.id.id_shop_men);
        bodyTx2 = itemView.findViewById(R.id.id_body_tx2);
        shopeWomenTx = itemView.findViewById(R.id.id_shop_women);
        bodyTx1 = itemView.findViewById(R.id.id_body_tx1);
    }


}