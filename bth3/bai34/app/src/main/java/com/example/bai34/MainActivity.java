package com.example.bai34;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import android.os.Bundle;
import android.widget.Toast;

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

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thông báo");
        builder.setMessage("Bạn phải nhập số lượng");
        builder.setPositiveButton("OK", null);
        //
        if (cb1.isChecked()) {
            et1 = findViewById(R.id.txtCo);
            if(!et1.getText().toString().isEmpty()){

                sl1 = Integer.parseInt(et1.getText().toString());
                Tong = Tong + 20000*sl1;
                et1.setText("");
            }
            else {
                builder.show();
                //Toast.makeText(this, "Số lượng phải lớn hơn 0", Toast.LENGTH_SHORT).show();
            }

        }
        if (cb2.isChecked()) {
            et2 = findViewById(R.id.txtKem);
            if(!et2.getText().toString().isEmpty()){

                sl2 = Integer.parseInt(et2.getText().toString());
                Tong = Tong + 10000*sl2;
                et2.setText("");
            }
            else {
                builder.show();
                //Toast.makeText(this, "Số lượng phải lớn hơn 0", Toast.LENGTH_SHORT).show();
            }

        }
        if (cb3.isChecked()) {
            et3 = findViewById(R.id.txtBim);
            if(!et3.getText().toString().isEmpty()){

                sl3 = Integer.parseInt(et3.getText().toString());
                Tong = Tong + 5000*sl3;
                et3.setText("");
            }
            else {
                builder.show();
                //Toast.makeText(this, "Số lượng phải lớn hơn 0", Toast.LENGTH_SHORT).show();
            }

        }
        if (cb4.isChecked()) {
            et4 = findViewById(R.id.txtSuac);
            if(!et4.getText().toString().isEmpty()){

                sl4 = Integer.parseInt(et4.getText().toString());
                Tong = Tong + 6000*sl4;
                et4.setText("");
            }
            else {
                builder.show();
                //Toast.makeText(this, "Số lượng phải lớn hơn 0", Toast.LENGTH_SHORT).show();
            }

        }
        if (cb5.isChecked()) {
            et5 = findViewById(R.id.txtSuacNC);
            if(!et5.getText().toString().isEmpty()){

                sl5 = Integer.parseInt(et5.getText().toString());
                Tong = Tong + 12000*sl5;
                et5.setText("");
            }
            else {
                builder.show();
                //Toast.makeText(this, "Số lượng phải lớn hơn 0", Toast.LENGTH_SHORT).show();
            }

        }
        //
        tv.setText( Tong + " VNĐ");
    }
}