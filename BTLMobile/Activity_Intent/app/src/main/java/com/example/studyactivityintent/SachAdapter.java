package com.example.studyactivityintent;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SachAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Sach> sachList;

    public SachAdapter(Context context, int layout, List<Sach> sachList) {
        this.context = context;
        this.layout = layout;
        this.sachList = sachList;
    }

    @Override
    public int getCount() {
        return sachList.size();
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
        ImageView imgHinh, imgMua;
        TextView txtTen, txtGia;
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
            holder.txtGia = convertView.findViewById(R.id.textViewGia);
            holder.imgMua = convertView.findViewById(R.id.ImageViewMua);
            convertView.setTag(holder);

        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        //gán giá trị
        Sach sach = sachList.get(position);
        holder.txtTen.setText(sach.getTen());
        holder.txtGia.setText(sach.getGia());
        holder.imgHinh.setImageResource(sach.getHinh());
        holder.imgMua.setImageResource(sach.getMua());
        return convertView;
    }
}
