package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView gvHinhAnh;
    ArrayList<HinhAnh> arrayImage;
    HinhAnhAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        adapter = new HinhAnhAdapter(this,R.layout.dong_hinh_anh,arrayImage);
        gvHinhAnh.setAdapter(adapter);
    }
    private void AnhXa(){
        gvHinhAnh = findViewById(R.id.idGridView);
        arrayImage = new ArrayList<>();
        arrayImage.add(new HinhAnh("Hình 1",R.drawable.anh1));
        arrayImage.add(new HinhAnh("Hình 2",R.drawable.anh2));
        arrayImage.add(new HinhAnh("Hình 3",R.drawable.b191917c870dad702193571cfb7df9e2));
//        arrayImage.add(new HinhAnh("Hình 4",R.drawable.a004));
//        arrayImage.add(new HinhAnh("Hình 5",R.drawable.a005));
//        arrayImage.add(new HinhAnh("Hình 6",R.drawable.a006));
//        arrayImage.add(new HinhAnh("Hình 7",R.drawable.a006));
//        arrayImage.add(new HinhAnh("Hình 8",R.drawable.a008));
    }

}