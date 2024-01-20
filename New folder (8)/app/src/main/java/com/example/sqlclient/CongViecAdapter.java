package com.example.sqlclient;

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
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    public class ViewHolder{
        ImageView imgDelete, imgEdit;
        TextView txtTen;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view==null)
        {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,null);
            holder.txtTen = view.findViewById(R.id.textviewTen);
            holder.imgDelete = view.findViewById(R.id.ImageDelete);
            holder.imgEdit = view.findViewById(R.id.ImageEdit);
            view.setTag(holder);
        }
        else{
            holder = (ViewHolder) view.getTag();
        }
        CongViec congViec = congViecList.get(i);
        holder.txtTen.setText(congViec.getTenCV());
        return view;
    }
}
