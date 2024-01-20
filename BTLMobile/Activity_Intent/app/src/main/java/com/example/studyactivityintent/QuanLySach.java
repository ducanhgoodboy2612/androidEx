package com.example.studyactivityintent;

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

public class QuanLySach extends AppCompatActivity {
    EditText edtMaSach, edtTenSach, edtGiaBan;
    Button btnThem, btnXoa, btnSua, btnXem;
    ListView listView;
    ArrayList<String> myList; // Luu tru du lieu
    ArrayAdapter<String> adapter; // Cong cu lay du lieu do sang listview
    SQLiteDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quan_ly_sach);
        edtMaSach = findViewById(R.id.idMaSach);
        edtTenSach = findViewById(R.id.idTenSach);
        edtGiaBan = findViewById(R.id.idGiaBan);
        btnThem = findViewById(R.id.btnThem);
        btnSua = findViewById(R.id.btnSua);
        btnXoa = findViewById(R.id.btnXoa);
        btnXem = findViewById(R.id.btnXem);
        listView = findViewById(R.id.listView1);
        myList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, myList);
        listView.setAdapter(adapter);
        // Tao va thao tac voi CSDL SQLite
        database = openOrCreateDatabase("qlsach.sql",MODE_PRIVATE, null);
        // Tao TABLE chua du lieu
        try{
            String sql = "CREATE TABLE tblsach(masach TEXT PRIMARY KEY, tensach TEXT, giaban INTEGER)";
            database.execSQL(sql);
        }catch (Exception e){
            Log.e("Error","Bảng đã tồn tại");
        }
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String masach = edtMaSach.getText().toString();
                String tensach = edtTenSach.getText().toString();
                int giaban = Integer.parseInt(edtGiaBan.getText().toString());
                ContentValues myValues = new ContentValues();
                myValues.put("masach", masach);
                myValues.put("tensach", tensach);
                myValues.put("giaban", giaban);
                String message = "";
                if(database.insert("tblsach", null, myValues)==-1){
                    message = "Thêm dữ liệu thất bạt !";
                }else {
                    message = "Thêm dữ liệu thành công";
                    Toast.makeText(QuanLySach.this, message, Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String masach = edtMaSach.getText().toString();
                int n = database.delete("tblsach","masach = ?", new String[]{masach});
                String message = "";
                if(n ==0){
                    message = "Không có bản ghi nào được xóa";
                }else{
                    message = n + "bản ghi được xóa";
                    Toast.makeText(QuanLySach.this, message, Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnXem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myList.clear();
                Cursor cursor = database.query("tblsach", null,null,null,null,null,null);
                cursor.moveToNext();
                String data = "";
                while(cursor.isAfterLast()== false){
                    data = cursor.getString(0)+"-" + cursor.getString(1)+"-" + cursor.getString(2);
                    cursor.moveToNext();
                    myList.add(data);
                }
                cursor.close();
                adapter.notifyDataSetChanged();
            }
        });
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int giaban = Integer.parseInt(edtGiaBan.getText().toString());
                String masach = edtMaSach.getText().toString();
                ContentValues myValues = new ContentValues();
                myValues.put("giaban", giaban);
                int n = database.update("tblsach",myValues, "masach = ?",new String[]{masach});
                String message = "";
                if(n==0){
                    message = "Không có bản ghi nào được sửa";
                }else{
                    message = n + "bản ghi được sửa";
                }
                Toast.makeText(QuanLySach.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
