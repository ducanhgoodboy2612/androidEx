package com.example.checkboxorder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void TongTien(View v) {
        int Tong = 0;

        CheckBox cb1, cb2, cb3, cb4, cb5;
        EditText et1, et2, et3, et4, et5;
        int sl1, sl2, sl3, sl4, sl5;
        TextView tv;
        //
        cb1 = (CheckBox) findViewById(R.id.cbCo);
        cb2 = (CheckBox) findViewById(R.id.cbKem);
        cb3 = (CheckBox) findViewById(R.id.cbBim);
        cb4 = (CheckBox) findViewById(R.id.cbSuac);
        cb5 = (CheckBox) findViewById(R.id.cbSuacNC);
        tv = (TextView) findViewById(R.id.tvTong);
        //
        if (cb1.isChecked()) {
            et1 = findViewById(R.id.txtCo);
            sl1 = Integer.parseInt(et1.getText().toString());
            Tong = Tong + 20000*sl1;
            et1.setText("");
        }
        if (cb2.isChecked()) {
            et2 = findViewById(R.id.txtKem);
            sl2 = Integer.parseInt(et2.getText().toString());
            Tong = Tong + 10000*sl2;
        }
        if (cb3.isChecked()) {
            et3 = findViewById(R.id.txtBim);
            sl3 = Integer.parseInt(et3.getText().toString());
            Tong = Tong + 5000*sl3;
        }
        if (cb4.isChecked()) {
            et4 = findViewById(R.id.txtSuac);
            sl4 = Integer.parseInt(et4.getText().toString());
            Tong = Tong + 6000*sl4;
        }
        if (cb5.isChecked()) {
            et5 = findViewById(R.id.txtSuacNC);
            sl5 = Integer.parseInt(et5.getText().toString());
            Tong = Tong + 12000*sl5;
        }
        //
        tv.setText( Tong + " VNĐ");
    }
}