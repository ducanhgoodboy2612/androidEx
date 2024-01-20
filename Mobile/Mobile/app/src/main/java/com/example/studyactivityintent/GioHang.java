package com.example.studyactivityintent;

import android.content.Intent;
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
        setContentView(R.layout.cart);

        //addControls();
    }
    public void onclickThanhToan(View v)
    {
        Toast.makeText(this, "Thanh toán thành công!", Toast.LENGTH_SHORT).show();
    }
    private void addControls() {
        TextView TenSP, GiaSP, SoLuong;
        ImageView Anh;
        TenSP = findViewById(R.id.product_title);
        GiaSP = findViewById(R.id.product_price);
        SoLuong = findViewById(R.id.SoLuong);
        Anh = findViewById(R.id.ImgAnh);


        Intent intent = getIntent();

        String ten = intent.getStringExtra("TenSP");
        String gia = intent.getStringExtra("GiaSP");
        String soluong = intent.getStringExtra("SoLuong");
        String imageResourceId = getIntent().getStringExtra("Anh");

        TenSP.setText(ten);
        GiaSP.setText(gia);
        SoLuong.setText(soluong);
        Anh.setImageResource(R.drawable.product_1);

    }
}
