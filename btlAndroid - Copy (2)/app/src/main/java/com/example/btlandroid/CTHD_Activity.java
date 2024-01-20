package com.example.btlandroid;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CTHD_Activity extends AppCompatActivity {
    ListView listViewcthd;
    ArrayList<CTHD> arrCT;
    CTHDAdapter cthdAdapter;
    Database database;
    Button btnAdd;
    String maHD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cthd);

        listViewcthd = findViewById(R.id.list_cthd);
        arrCT = new ArrayList<>();
        cthdAdapter = new CTHDAdapter(this, R.layout.dong_cthd, arrCT);
        listViewcthd.setAdapter(cthdAdapter);
        Intent intent = getIntent();
        int maHD = intent.getIntExtra("maHD", 1);
        //maHD = ma_intent;
        //create database
        database = new Database(this, "GhiChu.sql", null, 1);
        GetCTHD(maHD);
        btnAdd = findViewById(R.id.btnAddCTHD);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),ThemCTHD_Activity.class);
                startActivity(intent);
                Toast.makeText(CTHD_Activity.this, "oke", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void GetCTHD(int maHD){
        Toast.makeText(this, "cthd", Toast.LENGTH_SHORT).show();
        Cursor cursor = database.getData("SELECT * FROM CTHD WHERE MaHD = '"+maHD+"'");
        arrCT.clear();
        while (cursor.moveToNext()){
            String tenmon = cursor.getString(1);
            int mahd_ct = cursor.getInt(0);
            int sl = cursor.getInt(2);
//            Toast.makeText(this, tenmon, Toast.LENGTH_SHORT).show();
            arrCT.add(new CTHD(mahd_ct, tenmon, sl));
            cthdAdapter.notifyDataSetChanged();
       }
    }
}
