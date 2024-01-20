package com.example.studyactivityintent;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SanPhamAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<SanPham> sanPhamList;

    public SanPhamAdapter(Context context, int layout, List<SanPham> sanPhamList) {
        this.context = context;
        this.layout = layout;
        this.sanPhamList = sanPhamList;
    }

    @Override
    public int getCount() {
        return sanPhamList.size();
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
        SanPham sanPham = sanPhamList.get(position);
        holder.txtTen.setText(sanPham.getTen());
        holder.txtGia.setText(sanPham.getGia());
        holder.imgHinh.setImageResource(sanPham.getHinh());
        holder.imgMua.setImageResource(sanPham.getMua());
        return convertView;
    }
}
