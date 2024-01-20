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

public class QuanLySanPham extends AppCompatActivity {
    EditText edtMaSP, edtTenSP, edtGiaSP;
    Button btnThem, btnXoa, btnSua, btnXem;
    ListView listView;
    ArrayList<String> myList; // Luu tru du lieu
    ArrayAdapter<String> adapter; // Cong cu lay du lieu do sang listview
    SQLiteDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quan_ly_san_pham);
        edtMaSP = findViewById(R.id.edtMaSP);
        edtTenSP = findViewById(R.id.edtTenSP);
        edtGiaSP = findViewById(R.id.edtGiaSP);
        btnThem = findViewById(R.id.btnThem);
        btnSua = findViewById(R.id.btnSua);
        btnXoa = findViewById(R.id.btnXoa);
        btnXem = findViewById(R.id.btnXem);
        listView = findViewById(R.id.idlistView);
        myList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, myList);
        listView.setAdapter(adapter);
        // Tao va thao tac voi CSDL SQLite
        database = openOrCreateDatabase("qlsanpham.sql",MODE_PRIVATE, null);
        // Tao TABLE chua du lieu
        try{
            String sql = "CREATE TABLE tblsanpham(maSP TEXT PRIMARY KEY, tenSP TEXT, giaSP INTEGER)";
            database.execSQL(sql);
        }catch (Exception e){
            Log.e("Error","Bảng đã tồn tại");
        }
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String maSP = edtMaSP.getText().toString();
                String tenSP = edtTenSP.getText().toString();
                int giaSP = Integer.parseInt(edtGiaSP.getText().toString());
                ContentValues myValues = new ContentValues();
                myValues.put("maSP", maSP);
                myValues.put("tenSP", tenSP);
                myValues.put("giaSP", giaSP);
                String message = "";
                if(database.insert("tblsanpham", null, myValues)==-1){
                    message = "Error !!!";
                }else {
                    message = "Đã thêm dữ liệu";
                    Toast.makeText(QuanLySanPham.this, message, Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String maSP = edtMaSP.getText().toString();
                int n = database.delete("tblsanpham","maSP = ?", new String[]{maSP});
                String message = "";
                if(n ==0){
                    message = "Không có bản ghi nào được xóa";
                }else{
                    message = n + "bản ghi được xóa";
                    Toast.makeText(QuanLySanPham.this, message, Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnXem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myList.clear();
                Cursor cursor = database.query("tblsanpham", null,null,null,null,null,null);
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
                int giaSP = Integer.parseInt(edtGiaSP.getText().toString());
                String tenSP = edtTenSP.getText().toString();
                String maSP = edtMaSP.getText().toString();
                ContentValues myValues = new ContentValues();
                myValues.put("giaSP", giaSP);
                myValues.put("tenSP", tenSP);
                int n = database.update("tblsanpham",myValues, "maSP = ?",new String[]{maSP});
                String message = "";
                if(n==0){
                    message = "Không có bản ghi nào được sửa";
                }else{
                    message = n + " bản ghi được sửa";
                }
                Toast.makeText(QuanLySanPham.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
