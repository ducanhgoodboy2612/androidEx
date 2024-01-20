package com.example.btlandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MonAnAdapter extends BaseAdapter {
    private MonAn_Activity context;
    private int layout;
    ArrayList<MonAn> listMon;

    public MonAnAdapter(MonAn_Activity context, int layout, ArrayList<MonAn> listMon) {
        this.context = context;
        this.layout = layout;
        this.listMon = listMon;
    }
    @Override
    public int getCount() {
        return listMon.size();
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
        TextView tvTen, tvGia, tvDBan;
        ImageView imgEdit, imgDelete;
    }
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder.tvTen = view.findViewById(R.id.textViewTen);
            holder.tvGia = view.findViewById(R.id.textViewGia);
            holder.tvDBan = view.findViewById(R.id.textViewSLBan);
            holder.imgDelete = view.findViewById(R.id.imgDelete);
            holder.imgEdit = view.findViewById(R.id.imgEdit);
            view.setTag(holder);
        }
        else {
            holder = (ViewHolder) view.getTag();
        }
        MonAn monAn = listMon.get(i);
        holder.tvTen.setText(monAn.getTenMon());
        holder.tvGia.setText(String.valueOf(monAn.getGia()));
        holder.tvDBan.setText(String.valueOf(monAn.getSlban()));
        holder.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(context, "Sua", Toast.LENGTH_SHORT).show();
                context.DialogSua(monAn.getTenMon(),monAn.getGia(), monAn.getMaMon());
            }
        });

        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.DialogXoa(monAn.getTenMon(), monAn.getMaMon());
            }
        });
        return view;
    }




}
