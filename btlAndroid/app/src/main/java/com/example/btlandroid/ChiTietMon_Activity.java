package com.example.btlandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ChiTietMon_Activity extends AppCompatActivity {
    private int quantity = 1;
    TextView txtTen, txtGia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chitiet_monan);

        Intent intent = getIntent();
        String tenMon = intent.getStringExtra("ten");
        int gia = intent.getIntExtra("gia",50000);

        txtTen = findViewById(R.id.product_title);
        txtTen.setText(tenMon);
        txtGia = findViewById(R.id.product_price);
        txtGia.setText(String.valueOf(gia) + " VNĐ");


//        Button addToCart = findViewById(R.id.add_to_cart_button);
//        addToCart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                ImageView productImage = findViewById(R.id.product_image1);
//                TextView productTitle = findViewById(R.id.product_title);
//                TextView productPrice = findViewById(R.id.product_price);
//                TextView quantityTextView = findViewById(R.id.quantity_text_view);
//
//                Intent intent = new Intent(view.getContext(),GioHang.class);
//                intent.putExtra("IMAGE", productImage.getImageAlpha());
//                intent.putExtra("TITLE", productTitle.getText().toString());
//                intent.putExtra("PRICE", productPrice.getText().toString());
//                intent.putExtra("QUANTITY", quantityTextView.getText().toString());
//
//                startActivity(intent);
//            }
//        });

    }

}
