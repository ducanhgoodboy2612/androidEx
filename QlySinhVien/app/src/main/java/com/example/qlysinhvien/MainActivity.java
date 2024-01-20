package com.example.qlysinhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edtMaLop, edtTenLop, edtSiso;
    Button btnIns, btnDel, btnUpd, btnView;
    ListView listView;
    ArrayList<String> myList;
    ArrayAdapter<String> adapter;
    SQLiteDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtMaLop = findViewById(R.id.edtMaLop);
        edtTenLop = findViewById(R.id.edtTenlop);
        edtSiso = findViewById(R.id.edtSiso);
        btnIns = findViewById(R.id.btnIns);
        btnUpd = findViewById(R.id.btnUpd);
        btnDel = findViewById(R.id.btnDel);
        btnView = findViewById(R.id.btnView);
        listView = findViewById(R.id.lvSinhVien);

        myList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, myList);
        listView.setAdapter(adapter);

        //tao va thao tac csdl SQLite
        database = openOrCreateDatabase("qlSinhVien.sql", MODE_PRIVATE, null);
        //create table
        try{
            String sql = "CREATE TABLE tblLop (maLop TEXT PRIMARY KEY, tenLop TEXT, siSo INTEGER)";
            database.execSQL(sql);
        }
        catch (Exception e){
            Log.e("Error", "Bang da ton tai");
        }

        //
        btnIns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String malop = edtMaLop.getText().toString();
                String tenlop = edtTenLop.getText().toString();
                int siso = Integer.parseInt(edtSiso.getText().toString());
                ContentValues myValues = new ContentValues();
                myValues.put("maLop", malop);
                myValues.put("tenLop", tenlop);
                myValues.put("siSo", siso);
                String message = "";
                if(database.insert("tblLop", null, myValues) == -1){
                    message = "Loi them du lieu";
                }
                else {
                    message = "Them du lieu thanh cong";
                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                }
            }
        });

        //
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String malop = edtMaLop.getText().toString();
                int n = database.delete("tblLop","maLop = ?", new String[]{malop});
                String mess = "";
                if(n==0){
                    mess = "Khong xoa duoc";
                }
                else {
                    mess = n + " ban ghi duoc xoa";
                }
                Toast.makeText(MainActivity.this, mess, Toast.LENGTH_SHORT).show();
            }
        });

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myList.clear();
                Cursor cursor = database.query("tblLop", null, null, null, null, null, null);
                cursor.moveToNext();
                String data = "";
                while(cursor.isAfterLast() == false){
                    data = cursor.getString(0) + "-" + cursor.getString(1) + "-" + cursor.getString(2);
                    cursor.moveToNext();
                    myList.add(data);
                }
                cursor.close();
                adapter.notifyDataSetChanged();
            }
        });

        btnUpd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String malop = edtMaLop.getText().toString();
                String tenlop = edtTenLop.getText().toString();
                int siso = Integer.parseInt(edtSiso.getText().toString());
                ContentValues myValues = new ContentValues();
                myValues.put("siSo", siso);
                int n = database.update("tblLop", myValues, "maLop = ?", new String[]{malop});
                String mess = "";
                if(n == 0){
                    mess = "Khong the update";
                }
                else {
                    mess = n + " ban ghi duoc update";
                    Toast.makeText(MainActivity.this, mess, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}