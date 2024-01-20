package com.example.testapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.absolute_layout);

        Button tong, tich;
        tong = findViewById(R.id.btnTong);
        tong.setOnClickListener(tinhtong);
        tich = findViewById(R.id.btnTich);
        tich.setOnClickListener(tinhTich);

//        Button btn1 =  (Button) findViewById(R.id.btIntent1);
//        Button btn2 =  (Button) findViewById(R.id.btIntent2);
//
//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent in = new Intent(view.getContext(), layout1Activity.class);
//                startActivity(in);
//            }
//        });
//
//        btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent in = new Intent(view.getContext(), layout2Activity.class);
//                startActivity(in);
//            }
//        });

    }
    private View.OnClickListener tinhtong = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            double a, b, c;
            double tong = 0.0;
            TextView textview;

            //Nhap a, b, c dang string
            EditText hsa = (EditText) findViewById(R.id.HeSoA);
            EditText hsb = (EditText) findViewById(R.id.HeSoB);
            EditText hsc = (EditText) findViewById(R.id.HeSoC);

            a = Double.parseDouble(hsa.getText().toString());
            b = Double.parseDouble(hsb.getText().toString());
            c = Double.parseDouble(hsc.getText().toString());

            tong = a + b+ c;
            String strkq = "";
            strkq = "Tong 3 so = " + String.format("%5.2f", tong);
            textview = findViewById(R.id.result);
            textview.setText(strkq);
        }
    };

    private View.OnClickListener tinhTich = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            double a, b, c;
            double tich = 0.0;
            TextView textview;

            //Nhap a, b, c dang string
            EditText hsa = (EditText) findViewById(R.id.HeSoA);
            EditText hsb = (EditText) findViewById(R.id.HeSoB);
            EditText hsc = (EditText) findViewById(R.id.HeSoC);

            a = Double.parseDouble(hsa.getText().toString());
            b = Double.parseDouble(hsb.getText().toString());
            c = Double.parseDouble(hsc.getText().toString());

            tich = a + b+ c;
            String strkq = "";
            strkq = "Tich 3 so = " + String.format("%5.2f", tich);
            textview = findViewById(R.id.result);
            textview.setText(strkq);
        }
    };

//    public void onClickBt(View v) {
//        AlertDialog.Builder al = new AlertDialog.Builder(this);
//        al.setTitle("Message");
//        al.setMessage("Death is like the wind, always by my side");
//        al.create().show();
//    }

}