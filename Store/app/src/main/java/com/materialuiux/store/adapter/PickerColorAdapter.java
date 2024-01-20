package com.materialuiux.store.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.materialuiux.store.R;

import java.util.ArrayList;
import java.util.List;

public class PickerColorAdapter extends RecyclerView.Adapter<PickerColorAdapter.ViewHolder> {


    private LayoutInflater colorViewInflater;
    private List<Integer> colorCodeList;
    Context context;


    public PickerColorAdapter(@NonNull Context context) {
        this(context, setColorInList(context));
        this.colorViewInflater = LayoutInflater.from(context);
        this.context = context;
    }

    private PickerColorAdapter(Context context, List<Integer> colorPickerColors) {
        this.colorViewInflater = LayoutInflater.from(context);
        this.colorCodeList = colorPickerColors;
    }


    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = colorViewInflater.inflate(R.layout.layout_picker, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {


    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position, @NonNull List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            holder.view.setBackground(setCirclecolor(colorCodeList.get(position)));
        }


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    holder.view.setBackground(setSelectedColorCircle(colorCodeList.get(position)));
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return colorCodeList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        View view;

        private ViewHolder(View itemView) {
            super(itemView);
            view = itemView.findViewById(R.id.color_view);
        }
    }


    public GradientDrawable setCirclecolor(Integer integer) {
        Log.d("color selcted", String.valueOf(integer));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(integer);
        gradientDrawable.setShape(GradientDrawable.OVAL);
        return gradientDrawable;
    }

    public GradientDrawable setSelectedColorCircle(Integer integer) {
        Log.d("color selcted", String.valueOf(integer));
        int strokeWidth = 5;
        int strokeColor = Color.parseColor("#d2d2d2");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(integer);
        gradientDrawable.setShape(GradientDrawable.OVAL);
        gradientDrawable.setStroke(strokeWidth, strokeColor);
        return gradientDrawable;

    }

    private static List<Integer> setColorInList(Context context) {
        ArrayList<Integer> colorPickerColors = new ArrayList<>();
        colorPickerColors.add(ContextCompat.getColor(context, R.color.grey5));
        colorPickerColors.add(ContextCompat.getColor(context, R.color.grey15));
        colorPickerColors.add(ContextCompat.getColor(context, R.color.grey20));
        colorPickerColors.add(ContextCompat.getColor(context, R.color.red20));
        colorPickerColors.add(ContextCompat.getColor(context, R.color.orange15));
        colorPickerColors.add(ContextCompat.getColor(context, R.color.orange20));
        colorPickerColors.add(ContextCompat.getColor(context, R.color.lime15));
        colorPickerColors.add(ContextCompat.getColor(context, R.color.green20));
        colorPickerColors.add(ContextCompat.getColor(context, R.color.cyne20));
        colorPickerColors.add(ContextCompat.getColor(context, R.color.skyblue20));
        colorPickerColors.add(ContextCompat.getColor(context, R.color.blue15));
        colorPickerColors.add(ContextCompat.getColor(context, R.color.pink20));
        colorPickerColors.add(ContextCompat.getColor(context, R.color.violet20));
        return colorPickerColors;
    }
}

