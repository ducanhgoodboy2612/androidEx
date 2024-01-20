package com.example.studyactivityintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ChiTietSach extends AppCompatActivity {

    private int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chi_tiet_sach);
        Button decreaseButton = findViewById(R.id.decrease_button);
        Button increaseButton = findViewById(R.id.increase_button);

        decreaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decreaseQuantity();
            }
        });

        increaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increaseQuantity();
            }
        });
    }
    private void decreaseQuantity() {
        if (quantity > 1) { // Đảm bảo số lượng không âm
            quantity--;
            displayQuantity();
        }
    }

    private void increaseQuantity() {
        quantity++;
        displayQuantity();
    }

    private void displayQuantity() {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText(String.valueOf(quantity));
    }
    public void onclickMuaSach(View v)
    {
        Toast.makeText(this, "Đã thêm sách vào giỏ hàng", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(ChiTietSach.this, GioHang.class);
        TextView TenSach, Gia, SoLuong;
        ImageView Anh;

        TenSach = findViewById(R.id.book_title);
        Gia = findViewById(R.id.book_price);
        SoLuong = findViewById(R.id.quantity_text_view);
        Anh = findViewById(R.id.book_image);

        //Drawable drawable = Anh.getDrawable();
        intent.putExtra("TenSach",TenSach.getText().toString());
        intent.putExtra("Gia",Gia.getText().toString());
        intent.putExtra("SoLuong",SoLuong.getText().toString());
        intent.putExtra("Anh", Anh.getDrawable().toString());

        startActivity(intent);
    }


}



