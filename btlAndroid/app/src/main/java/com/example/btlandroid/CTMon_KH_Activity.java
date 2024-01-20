package com.example.btlandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CTMon_KH_Activity extends AppCompatActivity {
    private int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ctmon_kh);

//        Intent intent = getIntent();
//        String tenMon = intent.getStringExtra("ten");
//        int gia = intent.getIntExtra("gia",50000);
//        Toast.makeText(this, tenMon, Toast.LENGTH_SHORT).show();
//        Toast.makeText(this, String.valueOf(gia), Toast.LENGTH_SHORT).show();
//
//        txtTen = findViewById(R.id.product_title);
//        txtTen.setText(tenMon);
//        txtGia = findViewById(R.id.product_price);
//        txtGia.setText(String.valueOf(gia) + " VNĐ");

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
}
