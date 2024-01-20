package com.example.activity_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Layout1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout1);
        Button btnback;
//        btnback = findViewById(R.id.btnBack);
//        btnback.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(view.getContext(),MainActivity.class);
//                startActivity(intent);
//            }
//        });
        Intent intent = getIntent();
        String crong = intent.getStringExtra("dn");
        String cdai = intent.getStringExtra("dl");
        TextView txtchieurong = findViewById(R.id.idcdai);
        TextView txtchieudai = findViewById(R.id.idcrong);
        txtchieurong.setText(crong);
        txtchieudai.setText(cdai);

        Button btnChuyenHT;
        btnChuyenHT =findViewById(R.id.btnChuyenHT);
        btnChuyenHT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),Layout2.class);
                startActivity(intent);
            }
        });
        Button btnAns;
        btnAns = findViewById(R.id.btnHCN);
        btnAns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String chieurongDisplay = txtchieurong.getText().toString();
                String chieudaiDisplay = txtchieudai.getText().toString();
                double dientichHCN = Double.parseDouble(chieurongDisplay)*Double.parseDouble(chieudaiDisplay);
                String inKQ = "Diện tích HCN =" +String.format("%5.2f",dientichHCN);
                TextView textView = findViewById(R.id.ketqua);
                textView.setText(inKQ);
            }
        });

    }
}