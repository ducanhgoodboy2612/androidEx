package com.example.btlandroid;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
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
    int maHDglobal;
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
        maHDglobal = maHD;
        //maHD = ma_intent;
        //create database
        database = new Database(this, "GhiChu.sql", null, 1);

        GetCTHD(maHD);
        tinhTongHD(maHD);
        btnAdd = findViewById(R.id.btnAddCTHD);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),ThemCTHD_Activity.class);
                intent.putExtra("maHD", maHD);
                startActivity(intent);
                Toast.makeText(CTHD_Activity.this, "oke", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void GetCTHD(int maHD){

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
    public void tinhTongHD(int maHD){
        String sqlQuery = "SELECT SUM(ThucDon.Gia * CTHD.SoLuong) AS TongHoaDon " +
                "FROM CTHD " +
                "INNER JOIN ThucDon ON CTHD.TenMon = ThucDon.TenMon " +
                "WHERE CTHD.MaHD = " + maHD;

        Cursor cursor = database.getData(sqlQuery);
        if (cursor != null && cursor.moveToFirst()) {
            int total = cursor.getInt(0);
            cursor.close();

            TextView tvTongHD = findViewById(R.id.tvTongHD);
            tvTongHD.setText("Tổng hóa đơn " + maHD + ": " + total + " VNĐ");
        }
    }

//    public void tinhTongHD(int maHD){
//
//        Cursor cursor = database.getData("SELECT CTHD.TenMon, CTHD.SoLuong, ThucDon.Gia FROM CTHD INNER JOIN ThucDon ON CTHD.TenMon = ThucDon.TenMon WHERE CTHD.MaHD = '"+maHD+"'") ;
//
//        Toast.makeText(this, String.valueOf(maHD), Toast.LENGTH_SHORT).show();
//
//        if (cursor != null && cursor.moveToFirst()) {
//            int total = 0;
//            do {
//                int tongMon = 0;
//                String tenMon = cursor.getString(0);
//                int gia = cursor.getInt(2);
//                int soLuong = cursor.getInt(1);
//                Toast.makeText(this, String.valueOf(gia), Toast.LENGTH_SHORT).show();
//                Toast.makeText(this, String.valueOf(soLuong), Toast.LENGTH_SHORT).show();
//                Toast.makeText(this, "tong1mon", Toast.LENGTH_SHORT).show();
//                tongMon = gia * soLuong;
//                Toast.makeText(this, String.valueOf(tongMon), Toast.LENGTH_SHORT).show();
//                total += tongMon;
//                Toast.makeText(this, "tong", Toast.LENGTH_SHORT).show();
//                Toast.makeText(this, String.valueOf(total), Toast.LENGTH_SHORT).show();
//            } while (cursor.moveToNext());
//
//            cursor.close();
//        }
//
//        TextView tvTongHD = findViewById(R.id.tvTongHD);
//        Toast.makeText(this, "tong", Toast.LENGTH_SHORT).show();
//        Toast.makeText(this, String.valueOf(total), Toast.LENGTH_SHORT).show();
//        tvTongHD.setText("Tổng hóa đơn " + maHD +": " + total + " VNĐ");
//
//    }
    public void DialogSua(String ten, int sl){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.edit_cthd_dialog);
        TextView tvTenMon = dialog.findViewById(R.id.edtTen);
        EditText edtSl = dialog.findViewById(R.id.edtSl);
        Button btnCapNhat, btnCapNhatCancel;
        btnCapNhat = dialog.findViewById(R.id.btnEdit);
        btnCapNhatCancel = dialog.findViewById(R.id.btnCancelEdit);
        btnCapNhatCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        tvTenMon.setText(ten);
        edtSl.setText(String.valueOf(sl));
        btnCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int slMoi = Integer.parseInt(edtSl.getText().toString().trim());
                database.queryData("UPDATE CTHD SET SoLuong='"+slMoi+"' WHERE MaHD = '"+maHDglobal+"' AND TenMon = '"+ten+"'");
                Toast.makeText(CTHD_Activity.this, "Đã cập nhật", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                GetCTHD(maHDglobal);
                tinhTongHD(maHDglobal);
            }
        });
        dialog.show();
    }
    public void DialogXoa(String tenMon){
        AlertDialog.Builder dialogXoa = new AlertDialog.Builder(this);
        dialogXoa.setMessage("Bạn có chắc chắn muôn xóa " + tenMon + " không ?");
        dialogXoa.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                database.queryData("DELETE FROM CTHD WHERE MaHD = '"+maHDglobal+"' AND TenMon = '"+tenMon+"'");
                Toast.makeText(CTHD_Activity.this, "Da xoa", Toast.LENGTH_SHORT).show();
                GetCTHD(maHDglobal);
                tinhTongHD(maHDglobal);
            }
        });
        dialogXoa.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        dialogXoa.show();
    }
}
