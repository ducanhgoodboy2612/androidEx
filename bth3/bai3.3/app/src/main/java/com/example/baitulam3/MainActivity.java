package com.example.baitulam3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void TinhDiem(View v) {
        int Tong = 0;
        //Khai báo điều khiển
        RadioButton cau1, cau2, cau3, cau4;
        TextView tv;
        cau1 = (RadioButton) findViewById(R.id.dapancau1);
        cau2 = (RadioButton) findViewById(R.id.dapancau2);
        cau3 = (RadioButton) findViewById(R.id.dapancau3);
        cau4 = (RadioButton) findViewById(R.id.dapancau4);
        tv = (TextView) findViewById(R.id.tvKetQua);
        if (cau1.isChecked()) {
            Tong = Tong + 10;
        }
        if (cau2.isChecked()) {
            Tong = Tong + 10;
        }
        if (cau3.isChecked()) {
            Tong = Tong + 10;
        }
        if (cau4.isChecked()) {
            Tong = Tong + 10;
        }
        tv.setText(Tong + "");
    }

}