package com.example.bktth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    float a, b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText hesoa, hesob;
        Button btn1, btn2, btn3, btn4, btnExit;
        TextView tvketqua;
        hesoa = findViewById(R.id.edtA);
        hesob = findViewById(R.id.edtB);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btnExit = findViewById(R.id.btnExit);
        tvketqua = findViewById(R.id.txtKQ);
//

//

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    a = Float.parseFloat(hesoa.getText().toString().trim());
                    b = Float.parseFloat(hesob.getText().toString().trim());
                    float kq = a + b;
                    String chuoikq = "" + a + " + " + b + " = " + kq;
                    tvketqua.setText(chuoikq);

                }
                catch (NumberFormatException e){
                    Toast.makeText(MainActivity.this, "Nhập dữ liệu kiểu số thực", Toast.LENGTH_SHORT).show();
                }

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    a = Float.parseFloat(hesoa.getText().toString().trim());
                    b = Float.parseFloat(hesob.getText().toString().trim());
                    float kq = (float) Math.pow(a, b);
                    String chuoikq = "" + a + " ^ " + b + " = " + kq;
                    tvketqua.setText(chuoikq);
                }
                catch (NumberFormatException e){
                    Toast.makeText(MainActivity.this, "Nhập dữ liệu kiểu số thực", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    a = Float.parseFloat(hesoa.getText().toString().trim());
                    b = Float.parseFloat(hesob.getText().toString().trim());
                    float kq = a * b;
                    String chuoikq = "" + a + " * " + b + " = " + kq;
                    tvketqua.setText(chuoikq);
                }
                catch (NumberFormatException e){
                    Toast.makeText(MainActivity.this, "Nhập dữ liệu kiểu số thực", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    a = Float.parseFloat(hesoa.getText().toString().trim());
                    b = Float.parseFloat(hesob.getText().toString().trim());
                    float kq = (float) Math.pow(a, 1 / b);
                    String chuoikq = "" + a + " căn " + b + " = " + kq;
                    tvketqua.setText(chuoikq);
                }
                catch (NumberFormatException e){
                    Toast.makeText(MainActivity.this, "Nhập dữ liệu kiểu số thực", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



    }
}