package com.example.tongtichapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button tong, tich;
        tong = findViewById(R.id.btnTong);
        tong.setOnClickListener(tinhtong);
        tich = findViewById(R.id.btnTich);
        tich.setOnClickListener(tinhTich);


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

            tich = a * b * c;
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