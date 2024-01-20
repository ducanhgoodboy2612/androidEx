package com.example.activity_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Layout2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout2);
        Button btnback;
//        btnback = findViewById(R.id.btnBack);
//        btnback.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(view.getContext(),MainActivity.class);
//                startActivity(intent);
//            }
//        });
        EditText dl, dn, cc;
        dl = findViewById(R.id.idDaylon);
        dn = findViewById(R.id.idDaynho);
        cc = findViewById(R.id.idChieucao);
        Button btnchange;
        btnchange = findViewById(R.id.btnHCN);
        btnchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),Layout1.class);
                intent.putExtra("dn", dn.getText().toString());
                intent.putExtra("dl", dl.getText().toString());
                startActivity(intent);
            }
        });
        Button btnAns;
        btnAns = findViewById(R.id.btnHinhThang);
        btnAns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double daynho = Double.parseDouble((dn.getText().toString()));
                Double daylon = Double.parseDouble((dl.getText().toString()));
                Double ccao = Double.parseDouble((cc.getText().toString()));
               double dientich = (daynho + daylon)*ccao /2;
                TextView ans;
                ans = findViewById(R.id.ketqua);
                ans.setText("Dien tich hinh thang " + dientich);
            }
        });
    }
}