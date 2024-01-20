package com.example.bktth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    float a, b;
    ArrayList<Float> arrayList;
    ArrayAdapter adapter;
    private int selectedItemPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText hesoa, hesob;
        Button btn1, btn2, btn3, btn4, btnExit, btnDel;
        TextView tvketqua;
        ListView listView;
        hesoa = findViewById(R.id.edtA);
        hesob = findViewById(R.id.edtB);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btnExit = findViewById(R.id.btnExit);
        tvketqua = findViewById(R.id.txtKQ);
        listView = findViewById(R.id.lvKetQua);
        btnDel = findViewById(R.id.btnDel);

        arrayList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(adapter);



        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    a = Float.parseFloat(hesoa.getText().toString().trim());
                    b = Float.parseFloat(hesob.getText().toString().trim());
                    float kq = a + b;
                    String chuoikq = "" + a + " + " + b + " = " + kq;
                    tvketqua.setText(chuoikq);
                    arrayList.add(kq);
                    adapter.notifyDataSetChanged();
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
                    arrayList.add(kq);
                    adapter.notifyDataSetChanged();
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
                    arrayList.add(kq);
                    adapter.notifyDataSetChanged();
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
                    DecimalFormat df = new DecimalFormat("0.000");
                    kq = Float.parseFloat(df.format(kq));
                    String chuoikq = "" + a + " căn " + b + " = " + kq;
                    tvketqua.setText(chuoikq);
                    arrayList.add(kq);
                    adapter.notifyDataSetChanged();
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
        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            selectedItemPosition = i;
        });
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedItemPosition != -1){
                    arrayList.remove(selectedItemPosition);
                    adapter.notifyDataSetChanged();
                    selectedItemPosition = -1;
                }
            }
        });


    }
}