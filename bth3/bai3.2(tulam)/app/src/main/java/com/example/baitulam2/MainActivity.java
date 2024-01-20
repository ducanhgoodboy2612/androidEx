package com.example.baitulam2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void ThayDoiMau(View v) {

        //Khai báo điều khiển
        CheckBox red, blue, yellow;
        TextView tv;
        red = (CheckBox) findViewById(R.id.chkRed);
        blue = (CheckBox) findViewById(R.id.chkBlue);
        yellow = (CheckBox) findViewById(R.id.chkYellow);
        tv = (TextView) findViewById(R.id.textview);
        if (red.isChecked()) {
            tv.setTextColor(Color.RED);
        }
        if (blue.isChecked()) {
            tv.setTextColor(Color.BLUE);
        }
        if (yellow.isChecked()) {
            tv.setTextColor(Color.YELLOW);
        }

    }

}