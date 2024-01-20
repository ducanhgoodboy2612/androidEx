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
        btn1 = findViewById(R.id.btnBackDK);
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
        EditText TK, OTP, MK;
        TK = (EditText) findViewById(R.id.idTaiKhoanDK);
        OTP = (EditText) findViewById(R.id.idMaOTP);
        MK =(EditText)findViewById(R.id.idMatKhauDK);
        //Lấy giá trị người dùng nhập vào, đưa ra thông báo
        if(TK.getText().toString().equals("") && OTP.getText().toString().equals("") && MK.getText().toString().equals(""))
            Toast.makeText(this, "Đăng ký không thành công !!!", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
    }

}