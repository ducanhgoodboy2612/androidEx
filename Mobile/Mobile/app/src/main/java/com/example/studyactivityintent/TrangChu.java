package com.example.studyactivityintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class TrangChu extends AppCompatActivity {
    ListView lvSanPham;
    ArrayList<SanPham> arrSanPham;
    SanPhamAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trang_chu);
        AnhXa();
        adapter = new SanPhamAdapter(this,R.layout.dong_san_pham,arrSanPham);
        lvSanPham.setAdapter(adapter);
    }
    private void AnhXa(){
        lvSanPham = findViewById(R.id.idlistviewMain);
        arrSanPham = new ArrayList<>();
        arrSanPham.add(new SanPham("Robot biến hình style 1","419.000đ",R.drawable.product_1,R.drawable.cart));
        arrSanPham.add(new SanPham("Robot biến hình style 2","429.000đ",R.drawable.product_2,R.drawable.cart));
        arrSanPham.add(new SanPham("Robot biến hình style 3","439.000đ",R.drawable.product_3,R.drawable.cart));
        arrSanPham.add(new SanPham("Robot biến hình style 4","449.000đ",R.drawable.product_4,R.drawable.cart));
        arrSanPham.add(new SanPham("Robot biến hình style 5","459.000đ",R.drawable.product_5,R.drawable.cart));
    }
    public void onclickChiTietSanPham(View v)
    {
        Intent intent = new Intent(TrangChu.this, ChiTietSanPham.class);
        startActivity(intent);

    }
    public void onclickMuaSP(View v)
    {
        Toast.makeText(this, "Đã thêm sản phẩm vào giỏ hàng", Toast.LENGTH_SHORT).show();

    }
}
