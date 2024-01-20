package com.example.sqlitedatabaseapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Database database;
    ListView lvCongViec;
    ArrayList<MonAn> arrayCongViec;
    MonAnAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvCongViec =  findViewById(R.id.lvcv);
        arrayCongViec = new ArrayList<>();
        adapter = new MonAnAdapter(this, R.layout.dong_cong_viec, arrayCongViec);
        lvCongViec.setAdapter(adapter);
        //create database
        database = new Database(this, "GhiChu.sql", null, 1);
        //create table
        database.queryData("CREATE TABLE IF NOT EXISTS CongViec(Id INTEGER PRIMARY KEY AUTOINCREMENT, TenCV VARCHAR(300))");
        database.queryData("CREATE TABLE IF NOT EXISTS ThucDon(Id INTEGER PRIMARY KEY AUTOINCREMENT, TenMon VARCHAR(300), Gia INTEGER, SlDaban INTEGER)");
        //INS
        //database.queryData("INSERT INTO CongViec VALUES(null,'Thực hành mobile')");
        //database.queryData("INSERT INTO CongViec VALUES(null,'Choi game')");
        //database.queryData("INSERT INTO ThucDon VALUES(null,'Burger bò', 58000, 12)");
        //database.queryData("INSERT INTO ThucDon VALUES(null,'Burger tôm', 45000, 41)");
        GetDataCongViec();



    }
    private void GetDataCongViec(){
        Cursor dataCongViec = database.getData("SELECT * FROM ThucDon");
        arrayCongViec.clear();
        while (dataCongViec.moveToNext()){
            String ten = dataCongViec.getString(1);
            int id = dataCongViec.getInt(0);
            arrayCongViec.add(new MonAn(id, ten, 0, 0));
            adapter.notifyDataSetChanged();
            //Toast.makeText(this, ten, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_congviec, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.menuAdd){
            DialogThem();
        }
        if(item.getItemId() == R.id.menuEdit){
            Toast.makeText(this, "Menu edit", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    private void DialogThem(){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialogcongviec);
        EditText editText = dialog.findViewById(R.id.edtAdd);
        Button btnAdd, btnCancel;
        btnAdd = dialog.findViewById(R.id.btnAdd);
        btnCancel = dialog.findViewById(R.id.btnCancel);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tenCV = editText.getText().toString();
                if(tenCV.equals("")){

                    Toast.makeText(MainActivity.this, "Vui lòng nhập tên công việc", Toast.LENGTH_SHORT).show();
                }
                else{
                    database.queryData("INSERT INTO CongViec VALUES(null,'"+tenCV+"')");
                    GetDataCongViec();
                    Toast.makeText(MainActivity.this, "Đã thêm", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                GetDataCongViec();
            }
        });
        dialog.show();
    }

    public void DialogSua(String tenCV, int idCV){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_edit);
        EditText edtTenCV = dialog.findViewById(R.id.edtEdit);
        Button btnCapNhatCV, btnCapNhatCancel;
        btnCapNhatCV = dialog.findViewById(R.id.btnEdit);
        btnCapNhatCancel = dialog.findViewById(R.id.btnCancelEdit);
        btnCapNhatCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        edtTenCV.setText(tenCV);
        btnCapNhatCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tenMoi = edtTenCV.getText().toString().trim();
                database.queryData("UPDATE CongViec SET TenCV='"+tenMoi+"'WHERE Id = '"+idCV+"'");
                Toast.makeText(MainActivity.this, "Đã cập nhật", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                GetDataCongViec();
            }
        });
        dialog.show();
    }

    public void DialogXoa(String tenCV, int idCV){
        AlertDialog.Builder dialogXoa = new AlertDialog.Builder(this);
        dialogXoa.setMessage("Ban co muon xoa cong viec " + tenCV + " khong ?");
        dialogXoa.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                database.queryData("DELETE FROM CongViec WHERE Id = '"+idCV+"'");
                Toast.makeText(MainActivity.this, "Da xoa", Toast.LENGTH_SHORT).show();
                GetDataCongViec();
            }
        });
        dialogXoa.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        dialogXoa.show();
    }

//    public void DialogSua(String tenCV, int idCV){
//        Dialog dialog = new Dialog(this);
//        dialog.setContentView(R.layout.dialog_edit);
//        EditText edtTenCV = dialog.findViewById(R.id.edtEdit);
//        Button btnEdit, btnCancel;
//        btnEdit = findViewById(R.id.btnEdit);
//        btnCancel = findViewById(R.id.btnCancelEdit);
//
//        btnEdit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String tenMoi = edtTenCV.getText().toString().trim();
//                database.queryData("UPDATE CongViec SET TenCV = '"+tenMoi+"' WHERE Id = '"+idCV+"'");
//                Toast.makeText(MainActivity.this, "Da cap nhat", Toast.LENGTH_SHORT).show();
//                dialog.dismiss();
//                GetDataCongViec();
//            }
//        });
//        btnCancel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                dialog.dismiss();
//            }
//        });
//        edtTenCV.setText(tenCV);
//        dialog.show();
//    }

//    private void dialogAdd(){
//        Dialog dialog = new Dialog(this);
//        dialog.setContentView(R.layout.dialogcongviec);
//        EditText edtTen = findViewById(R.id.edtAdd);
//        Button btnAdd, btnCancel;
//        btnAdd = findViewById(R.id.btnAdd);
//        btnCancel = findViewById(R.id.btnCancel);
//        btnAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String tenCV = edtTen.getText().toString();
//                if(tenCV.equals("")){
//                    Toast.makeText(MainActivity.this, "Vui long nhap ten cong viec", Toast.LENGTH_SHORT).show();
//                }
//                else {
//                    database.queryData("INSERT INTO CongViec VALUES(null,'"+edtTen+"')");
//                    Toast.makeText(MainActivity.this, "Da them", Toast.LENGTH_SHORT).show();
//                    dialog.dismiss();
//                }
//            }
//        });
////        btnCancel.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                dialog.dismiss();
////            }
////        });
//        dialog.show();
//    }
}