package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class TraiCayAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<TraiCay> traicayList;

    public TraiCayAdapter(Context context, int layout, List<TraiCay> traicayList) {
        this.context = context;
        this.layout = layout;
        this.traicayList = traicayList;
    }

    @Override
    public int getCount() {
        return traicayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    private class ViewHolder{
        ImageView imgHinh;
        TextView txtTen, txtMota;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout,null);
            holder = new ViewHolder();
            //ánh xạ sang giao diện
            holder.imgHinh = convertView.findViewById(R.id.ImageViewHinh);
            holder.txtTen = convertView.findViewById(R.id.textViewTen);
            holder.txtMota = convertView.findViewById(R.id.textViewMoTa);
            convertView.setTag(holder);

        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        //gán giá trị
        TraiCay traiCay = traicayList.get(position);
        holder.txtTen.setText(traiCay.getTen());
        holder.txtMota.setText(traiCay.getMoTa());
        holder.imgHinh.setImageResource(traiCay.getHinh());

        return convertView;
    }
}
