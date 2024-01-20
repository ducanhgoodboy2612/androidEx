package com.example.qlnhahang;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Database database;
    ListView lvMon;
    ArrayList<Mon_An> monAnArrayList;
    MonAnAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMon =  findViewById(R.id.lvcv);
        monAnArrayList = new ArrayList<>();
        adapter = new MonAnAdapter(this, R.layout.dong_monan, monAnArrayList);
        lvMon.setAdapter(adapter);
        //create database
        database = new Database(this, "qlNhaHang.sql", null, 1);
        //create table
        database.queryData("CREATE TABLE IF NOT EXISTS MonAn(MaMon INTEGER PRIMARY KEY AUTOINCREMENT, TenMon VARCHAR(300), Gia INTEGER)");
        //INS
//        database.queryData("INSERT INTO MonAn VALUES(null,'Ga',50)");
//        database.queryData("INSERT INTO MonAn VALUES(null,'Ca', 45)");

        GetAllData();
    }

    private void GetAllData(){
        Cursor data = database.getData("SELECT * FROM MonAn");
        monAnArrayList.clear();
        while (data.moveToNext()){
            String ten = data.getString(1);
            int id = Integer.parseInt(data.getString(0));
            int gia = Integer.parseInt(data.getString(2));
            monAnArrayList.add(new Mon_An(id, ten, gia));
            adapter.notifyDataSetChanged();
            Toast.makeText(this, ten, Toast.LENGTH_SHORT).show();
        }
    }
//    private void DialogThem(){
//        Dialog dialog = new Dialog(this);
//        dialog.setContentView(R.layout.dialog_add);
//        EditText editText = dialog.findViewById(R.id.edtAdd);
//        Button btnAdd, btnCancel;
//        btnAdd = dialog.findViewById(R.id.btnAdd);
//        btnCancel = dialog.findViewById(R.id.btnCancel);
//        btnAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String tenCV = editText.getText().toString();
//                if(tenCV.equals("")){
//
//                    Toast.makeText(MainActivity.this, "Vui lòng nhập tên công việc", Toast.LENGTH_SHORT).show();
//                }
//                else{
//                    database.queryData("INSERT INTO MonAn VALUES(null,'"+tenCV+"', 30)");
//                    GetAllData();
//                    Toast.makeText(MainActivity.this, "Đã thêm", Toast.LENGTH_SHORT).show();
//                    dialog.dismiss();
//                }
//            }
//        });
//        btnCancel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                dialog.dismiss();
//                GetAllData();
//            }
//        });
//        dialog.show();
//    }
//    public void DialogSua(String tenMon, int maMon){
//        Dialog dialog = new Dialog(this);
//        dialog.setContentView(R.layout.dialog_edit);
//        EditText edtTenCV = dialog.findViewById(R.id.edtEdit);
//        Button btnCapNhatCV, btnCapNhatCancel;
//        btnCapNhatCV = dialog.findViewById(R.id.btnEdit);
//        btnCapNhatCancel = dialog.findViewById(R.id.btnCancelEdit);
//        btnCapNhatCancel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                dialog.dismiss();
//            }
//        });
//        edtTenCV.setText(tenCV);
//        btnCapNhatCV.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String tenMoi = edtTenCV.getText().toString().trim();
//                database.queryData("UPDATE MonAn SET TenMon='"+tenMoi+"'WHERE MaMon = '"+maMon+"'");
//                Toast.makeText(MainActivity.this, "Đã cập nhật", Toast.LENGTH_SHORT).show();
//                dialog.dismiss();
//                GetAllData();
//            }
//        });
//        dialog.show();
//    }

//    public void DialogXoa(String tenCV, int idCV){
//        AlertDialog.Builder dialogXoa = new AlertDialog.Builder(this);
//        dialogXoa.setMessage("Ban co muon xoa cong viec " + tenCV + " khong ?");
//        dialogXoa.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                database.queryData("DELETE FROM CongViec WHERE Id = '"+idCV+"'");
//                Toast.makeText(MainActivity.this, "Da xoa", Toast.LENGTH_SHORT).show();
//                GetAllData();
//            }
//        });
//        dialogXoa.setNegativeButton("No", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//
//            }
//        });
//        dialogXoa.show();
//    }
}