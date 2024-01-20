package com.example.qlnhahang;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MonAnAdapter extends BaseAdapter {
    private MainActivity context;
    private int layout;
    ArrayList<Mon_An> monAnList;

    public MonAnAdapter(MainActivity context, int layout, ArrayList<Mon_An> monAnList) {
        this.context = context;
        this.layout = layout;
        this.monAnList = monAnList;
    }


    @Override
    public int getCount() {
        return 0;
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
        TextView txtTen;
        ImageView imgEdit, imgDelete; }
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder.txtTen = view.findViewById(R.id.textviewtenCV);
            holder.imgDelete = view.findViewById(R.id.imgDelete);
            holder.imgEdit = view.findViewById(R.id.imgEdit);
            view.setTag(holder);
        }
        else {
            holder = (ViewHolder) view.getTag();
        }
        Mon_An monan = monAnList.get(i);
        holder.txtTen.setText(monan.getTenMon() + "--" + monan.getGia());
//        holder.imgEdit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //Toast.makeText(context, "Sua", Toast.LENGTH_SHORT).show();
//                context.DialogSua(monan.getGia(),monan.getMaMon());
//            }
//        });
//        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                context.DialogXoa(monan.getTenMon(), monan.getMaMon());
//            }
//        });
        return view;
    }
}
