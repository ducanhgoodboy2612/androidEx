package com.example.studyactivityintent;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class GioHang extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gio_hang);

        addControls();
    }
    public void onclickThanhToan(View v)
    {
        Toast.makeText(this, "Thanh toán thành công!!!", Toast.LENGTH_SHORT).show();
    }
    private void addControls() {
        TextView TenSach, Gia, SoLuong;
        ImageView Anh;
        TenSach = findViewById(R.id.book_title1);
        Gia = findViewById(R.id.book_price1);
        SoLuong = findViewById(R.id.SoLuong1);
        Anh = findViewById(R.id.book_image1);


        Intent intent = getIntent();

        String ten = intent.getStringExtra("TenSach");
        String gia = intent.getStringExtra("Gia");
        String soluong = intent.getStringExtra("SoLuong");
        String imageResourceId = getIntent().getStringExtra("Anh");

        TenSach.setText(ten);
        Gia.setText(gia);
        SoLuong.setText(soluong);
        Anh.setImageResource(R.drawable.nhatky_chubenhutnhat1);

    }
}
