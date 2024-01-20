package com.example.studyactivityintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DangNhap extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dang_nhap);
        Button btn1;
        btn1 = findViewById(R.id.btnBackDangNhap);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
    public void onclickdangnhap(View v) {
        //Khai báo các biến điều khiển tương ứng
        EditText sdt,mk;
        sdt = (EditText) findViewById(R.id.idSDTEmailDangNhap);
        mk=(EditText)findViewById(R.id.idMKDangNhap);
        //Lấy giá trị người dùng nhập vào, đưa ra thông báo
        if(sdt.getText().toString().equals("khachhang")&&mk.getText().toString().equals("khachhang"))
        {
            Intent intent = new Intent(DangNhap.this, TrangChu.class);
            startActivity(intent);
        }
        else if(sdt.getText().toString().equals("quanly")&&mk.getText().toString().equals("quanly"))
        {
            Intent intent = new Intent(DangNhap.this, QuanLySach.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this, "Thông tin đăng nhập sai!!!", Toast.LENGTH_SHORT).show();
        }
    }
}