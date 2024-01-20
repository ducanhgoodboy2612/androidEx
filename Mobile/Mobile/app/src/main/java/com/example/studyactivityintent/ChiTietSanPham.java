package com.example.studyactivityintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ChiTietSanPham extends AppCompatActivity {

    private int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chitietsanpham);
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
    public void onclickMuaSP(View v)
    {
        Toast.makeText(this, "Đã thêm sản phẩm vào giỏ hàng", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(ChiTietSanPham.this, GioHang.class);
        TextView TenSP, GiaSP, SoLuong;
        ImageView Anh;

        TenSP = findViewById(R.id.product_title);
        GiaSP = findViewById(R.id.product_price);
        SoLuong = findViewById(R.id.quantity_text_view);
        Anh = findViewById(R.id.product_image1);

        //Drawable drawable = Anh.getDrawable();
        intent.putExtra("TenSP",TenSP.getText().toString());
        intent.putExtra("GiaSP",GiaSP.getText().toString());
        intent.putExtra("SoLuong",SoLuong.getText().toString());
        intent.putExtra("Anh", Anh.getDrawable().toString());

        startActivity(intent);
    }
}



