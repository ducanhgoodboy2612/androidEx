package com.example.sqlite125214;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CongViecAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    ArrayList<CongViec> congViecList;

    public CongViecAdapter(Context context, int layout, ArrayList<CongViec> congViecList) {
        this.context = context;
        this.layout = layout;
        this.congViecList = congViecList;
    }

    @Override
    public int getCount() {
        return congViecList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    public class ViewHolder{
        ImageView imgDelete, imgEdit;
        TextView txtTen;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout,null);
            holder.txtTen = convertView.findViewById(R.id.textviewTen);
            holder.imgDelete = convertView.findViewById(R.id.ImageviewDelete);
            holder.imgEdit = convertView.findViewById(R.id.ImageviewEdit);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        CongViec congViec = congViecList.get(position);
        holder.txtTen.setText(congViec.getTenCV());

        return convertView;
    }
}
