package com.example.baitap1android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai1_7a);
//        Button cal;
//        cal =  findViewById(R.id.calculate);
//        cal.setOnClickListener(tinhBMI);


    }

    public void tongTienKFC(View v){
        int Tong = 0;
        CheckBox cbCanh, cbDui, cbCom, cbKhac;
        TextView tv;
        //
        cbCanh = (CheckBox) findViewById(R.id.cbCanhGaRan);
        cbDui = (CheckBox) findViewById(R.id.cbDuiGaRan);
        cbCom = (CheckBox) findViewById(R.id.cbCombo);
        cbKhac = (CheckBox) findViewById(R.id.cbThucAnPhu);
        tv = (TextView) findViewById(R.id.tvTong);
        //
        if (cbCanh.isChecked()) {
            Tong = Tong + 89000;
        }
        if (cbDui.isChecked()) {
            Tong = Tong + 92000;
        }
        if (cbCom.isChecked()) {
            Tong = Tong + 156000;
        }
        if (cbKhac.isChecked()) {
            Tong = Tong + 34000;
        }
        //
        tv.setText(Tong + "");
    }


    public View.OnClickListener tinhBMI = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            double height, weight;
            double bmi = 0.0;
            TextView textView;

            EditText hei = (EditText) findViewById(R.id.height);
            EditText wei = (EditText) findViewById(R.id.weigh);

            height = Double.parseDouble(hei.getText().toString());
            weight = Double.parseDouble(wei.getText().toString());
            bmi =  weight / (height * height);
            String strkq = "";
            strkq = String.format("%5.2f", bmi);
            textView = findViewById(R.id.kqbmi);
            textView.setText(strkq);


        }
    };
}