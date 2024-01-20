package com.example.studyactivityintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class TrangChu extends AppCompatActivity {
    ListView lvSach;
    ArrayList<Sach> arrsach;
    SachAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trang_chu);
        AnhXa();
        adapter = new SachAdapter(this,R.layout.dong_sach,arrsach);
        lvSach.setAdapter(adapter);
    }
    private void AnhXa(){
        lvSach = findViewById(R.id.listview);
        arrsach = new ArrayList<>();
        arrsach.add(new Sach("Nhật ký chú bé nhút nhát tập 1","44.000đ",R.drawable.nhatky_chubenhutnhat1,R.drawable.cart));
        arrsach.add(new Sach("Nhật ký chú bé nhút nhát tập 2","44.000đ",R.drawable.nhatky_chubenhutnhat2,R.drawable.cart));
        arrsach.add(new Sach("Nhật ký chú bé nhút nhát tập 3","44.000đ",R.drawable.nhatky_chubenhutnhat3,R.drawable.cart));
        arrsach.add(new Sach("Nhật ký chú bé nhút nhát tập 4","44.000đ",R.drawable.nhatky_chubenhutnhat5,R.drawable.cart));
        arrsach.add(new Sach("Nhật ký chú bé nhút nhát tập 5","44.000đ",R.drawable.nhatky_chubenhutnhat6,R.drawable.cart));
        arrsach.add(new Sach("Nhật ký chú bé nhút nhát tập 6","44.000đ",R.drawable.image_195509_1_31019,R.drawable.cart));
        arrsach.add(new Sach("Nhật ký chú bé nhút nhát tập 7","44.000đ",R.drawable.image_239003,R.drawable.cart));
        arrsach.add(new Sach("Nhật ký chú bé nhút nhát tập 8","44.000đ",R.drawable.image_195509_1_31020,R.drawable.cart));
    }
    public void onclickChiTietSach(View v)
    {
        Intent intent = new Intent(TrangChu.this, ChiTietSach.class);
        startActivity(intent);

    }
    public void onclickMuaSach(View v)
    {
        Toast.makeText(this, "Đã thêm sách vào giỏ hàng", Toast.LENGTH_SHORT).show();

    }
}
