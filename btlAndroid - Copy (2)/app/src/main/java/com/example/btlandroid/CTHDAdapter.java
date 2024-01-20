package com.example.btlandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CTHDAdapter extends BaseAdapter {
    private CTHD_Activity context;
    private int layout;

    public CTHDAdapter(CTHD_Activity context, int layout, ArrayList<CTHD> listCTHD) {
        this.context = context;
        this.layout = layout;
        this.listCTHD = listCTHD;
    }

    ArrayList<CTHD> listCTHD;
    @Override
    public int getCount() {
        return listCTHD.size();
    }

    @Override
    public Object getItem(int i) {
        return listCTHD.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder{
        TextView tvMaHD, tvTenMon, tvSoluong;
        ImageView imgEdit, imgDelete;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        CTHDAdapter.ViewHolder holder;
        if(view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder.tvMaHD = view.findViewById(R.id.textViewMaHD);
            holder.tvTenMon = view.findViewById(R.id.textViewTenMon);
            holder.tvSoluong = view.findViewById(R.id.textViewSl);
            holder.imgDelete = view.findViewById(R.id.imgDelete);
            holder.imgEdit = view.findViewById(R.id.imgEdit);

            view.setTag(holder);
        }
        else {
            holder = (CTHDAdapter.ViewHolder) view.getTag();
        }
        CTHD ct = listCTHD.get(i);
        holder.tvMaHD.setText(String.valueOf(ct.getMaHD()));
        holder.tvTenMon.setText(ct.getTenMon());
        holder.tvSoluong.setText(String.valueOf(ct.getSoluong()));



        return view;
    }
}
