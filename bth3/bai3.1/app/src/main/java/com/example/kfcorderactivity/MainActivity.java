package com.example.kfcorderactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private TextView tvTongTien;
    private int giaMonAn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void TongTien(View view) {
        radioGroup = findViewById(R.id.radioGroup1);
        tvTongTien = findViewById(R.id.tvTong);

        int selecteId = radioGroup.getCheckedRadioButtonId();


        if (selecteId == R.id.cbCanhGaRan) {
            giaMonAn = 89000;
        } else if (selecteId == R.id.cbDuiGaRan) {
            giaMonAn = 92000;
        } else if (selecteId == R.id.cbCombo) {
            giaMonAn = 156000;
        } else {
            giaMonAn = 34000;
        }


        tvTongTien.setText("Tổng tiền: " + giaMonAn + " VNĐ");
    }

}