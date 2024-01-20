package com.example.studyactivityintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DangKy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dang_ky);
        Button btn1;
        btn1 = findViewById(R.id.btnBackDangKy);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
    public void onclickdangky(View v) {
        //Khai báo các biến điều khiển tương ứng
        EditText sdt, otp,mk;
        sdt = (EditText) findViewById(R.id.idSDTDangKy);
        otp = (EditText) findViewById(R.id.id6KyTuDangKy);
        mk=(EditText)findViewById(R.id.idMKDangKy);
        //Lấy giá trị người dùng nhập vào, đưa ra thông báo
        if(sdt.getText().toString().equals("")&&otp.getText().toString().equals("")&&mk.getText().toString().equals(""))
            Toast.makeText(this, "Đăng ký thất bại!", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Đăng ký thành công!", Toast.LENGTH_SHORT).show();
    }

}