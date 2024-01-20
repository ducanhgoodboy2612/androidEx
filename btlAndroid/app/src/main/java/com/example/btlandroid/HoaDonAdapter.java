package com.example.btlandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HoaDonAdapter extends BaseAdapter {
    private HoaDon_Activity context;
    private int layout;
    ArrayList<HoaDonDM> lisHD;
    public HoaDonAdapter(HoaDon_Activity context, int layout, ArrayList<HoaDonDM> arrlist) {
        this.context = context;
        this.layout = layout;
        this.lisHD = arrlist;
    }

    @Override
    public int getCount() {
        return lisHD.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


    private class ViewHolder{
        TextView tvMa, tvTenNV, tvNgayLap;
        ImageView imgEdit, imgDelete, imgDetail;
    }
    public View getView(int i, View view, ViewGroup viewGroup) {
        HoaDonAdapter.ViewHolder holder;
        if(view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder.tvMa = view.findViewById(R.id.textViewMaHD);
            holder.tvTenNV = view.findViewById(R.id.textViewNV);
            holder.tvNgayLap = view.findViewById(R.id.textViewNgay);
            holder.imgDelete = view.findViewById(R.id.imgDelete);
            holder.imgEdit = view.findViewById(R.id.imgEdit);
            holder.imgDetail = view.findViewById(R.id.imgDetail);
            view.setTag(holder);
        }
        else {
            holder = (HoaDonAdapter.ViewHolder) view.getTag();
        }
        HoaDonDM hoaDon = lisHD.get(i);
        holder.tvTenNV.setText(hoaDon.getTenNV());
        holder.tvNgayLap.setText(hoaDon.getNgayLap());
        holder.tvMa.setText(String.valueOf(hoaDon.getMaHD()));

//        holder.imgEdit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //Toast.makeText(context, "Sua", Toast.LENGTH_SHORT).show();
//                context.DialogSua(monAn.getTenMon(),monAn.getGia(), monAn.getMaMon());
//            }
//        });
//
        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.DialogXoa(hoaDon.getMaHD());
            }
        });
//
        holder.imgDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.GetCTHD(hoaDon.getMaHD());

            }
        });
        return view;
    }
}
