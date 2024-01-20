package com.example.btlandroid;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class ThemCTHD_Activity extends AppCompatActivity {
    Database database;
    Spinner spinnerThucDon;
    ArrayList<String> thucDonList;
    ArrayList<MonAn> fullListMon;
    TextView txtgia;
    EditText sl;
    Button btnAddtoBill, btnCancel;
    String selectedValue;
    ArrayList<CTHD> arrCTHD;
    ArrayAdapter ctAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_cthd);
        spinnerThucDon = findViewById(R.id.spinnerThucDon);
        thucDonList = new ArrayList<>();
        fullListMon = new ArrayList<>();
        database = new Database(this, "GhiChu.sql", null, 1);
//        database.queryData("CREATE TABLE IF NOT EXISTS ThucDon(Id INTEGER PRIMARY KEY AUTOINCREMENT, TenMon VARCHAR(300), Gia INTEGER, SlDaban INTEGER)");
//        database.queryData("INSERT INTO ThucDon VALUES(null,'Burger bò', 58000, 12)");
//        database.queryData("INSERT INTO ThucDon VALUES(null,'Burger tôm', 45000, 41)");
//        database.queryData("INSERT INTO ThucDon VALUES(null,'Burger Big Mac', 49000, 49)");
        Cursor cursor = database.getData("SELECT Id, TenMon, Gia FROM ThucDon");
        if (cursor != null && cursor.moveToFirst()) {
            do {
                String tenMon = cursor.getString(1);
                int id = cursor.getInt(0);
                int gia = cursor.getInt(2);
                MonAn item = new MonAn(id, tenMon, gia, 0);
                thucDonList.add(tenMon);
                fullListMon.add(item);
            } while (cursor.moveToNext());
            cursor.close();
        }
        Intent intent = getIntent();
        int maHD = intent.getIntExtra("maHD", 1);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, thucDonList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerThucDon.setAdapter(adapter);
        spinnerThucDon.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedValue = (String) adapterView.getItemAtPosition(i);
                Toast.makeText(ThemCTHD_Activity.this, selectedValue, Toast.LENGTH_SHORT).show();
                int gia = fullListMon.get(i).getGia();
                txtgia = findViewById(R.id.txtGia);
                txtgia.setText(String.valueOf(gia));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });
        btnCancel = findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),HoaDon_Activity.class);
                startActivity(intent);
            }
        });
        btnAddtoBill = findViewById(R.id.btnAddtoBill);
        EditText sl = findViewById(R.id.slThem);

        btnAddtoBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int maHDon = maHD;
                int sluong = Integer.parseInt(sl.getText().toString());
                if(selectedValue.equals(null) || String.valueOf(sluong).equals(null)){

                    Toast.makeText(ThemCTHD_Activity.this, "Vui lòng nhập đầy đủ thông tin món.", Toast.LENGTH_SHORT).show();
                }
                else{

                    database.queryData("INSERT INTO CTHD VALUES('"+maHD+"','"+selectedValue+"', '"+sluong+"')");

                    Toast.makeText(ThemCTHD_Activity.this, "Đã thêm", Toast.LENGTH_SHORT).show();

                }
            }
        });


    }
    public int GetPrice(String tenMon){
        Cursor cursor = database.getData("SELECT Gia FROM ThucDon WHERE TenMon = '"+tenMon+"'");
        if (cursor != null && cursor.moveToFirst()) {
            return cursor.getInt(0);
        }
        return 0;
    }
}
