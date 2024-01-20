package com.example.btlandroid;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class HoaDon_Activity extends AppCompatActivity {
    Database database;
    ListView listViewHoaDon;

    ArrayList<HoaDonDM> arrayList;
    HoaDonAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hoadon);
        listViewHoaDon =  findViewById(R.id.list_hoadon);
        arrayList = new ArrayList<>();
        adapter = new HoaDonAdapter(this, R.layout.dong_hoadon, arrayList);
        listViewHoaDon.setAdapter(adapter);
        //create database
        database = new Database(this, "GhiChu.sql", null, 1);
        //create table

        database.queryData("CREATE TABLE IF NOT EXISTS HoaDon(Id INTEGER PRIMARY KEY AUTOINCREMENT, TenNV VARCHAR(300), NgayLap VARCHAR(100))");
        database.queryData("CREATE TABLE IF NOT EXISTS CTHD(MaHD INTEGER, TenMon VARCHAR(300), SoLuong INTEGER)");
        //INS

//        database.queryData("INSERT INTO ThucDon VALUES(null,'Burger bò', 58000, 12)");
//        database.queryData("INSERT INTO HoaDon VALUES(null,'Trần Minh', '20/10/2023')");
//        database.queryData("INSERT INTO HoaDon VALUES(null,'Trần Minh', '20/10/2023')");
//        database.queryData("INSERT INTO HoaDon VALUES(null,'Trần Minh', '20/10/2023')");
//        database.queryData("INSERT INTO CTHD VALUES(1,'Burger tôm', 2)");
//        database.queryData("INSERT INTO CTHD VALUES(1,'Burger BigMac', 3)");
//        database.queryData("INSERT INTO CTHD VALUES(2,'Burger bò', 4)");
        GetData();


    }
//    public String GetTenMon(int maMon){
//        Cursor dataMon = database.getData("SELECT * FROM ThucDon WHERE Id = '"+maMon+"'");
//        return  dataMon.getString(1);
//    }
    private void GetData(){
        Cursor dataMon = database.getData("SELECT * FROM HoaDon ");
        arrayList.clear();
        while (dataMon.moveToNext()){
            String tennv = dataMon.getString(1);
            int id = dataMon.getInt(0);
            String ngaylap = dataMon.getString(2);
            arrayList.add(new HoaDonDM(id, tennv, ngaylap));
            adapter.notifyDataSetChanged();
            Toast.makeText(this, String.valueOf(id), Toast.LENGTH_SHORT).show();
        }
    }
    public void GetCTHD(int maHD){
        Intent intent = new Intent(this, CTHD_Activity.class);
        intent.putExtra("maHD", maHD);
        startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_bar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.menuAdd){
            DialogThem();
        }

        return super.onOptionsItemSelected(item);
    }
    private void ChonNgay(){
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DATE);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                calendar.set(i, i1, i2);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                edtNgay.setText(simpleDateFormat.format(calendar.getTime()));
            }
        }, year, month, day);
        datePickerDialog.show();

    }
    EditText edtNgay;
    private void DialogThem(){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.add_hoadon);
        EditText edtTen = dialog.findViewById(R.id.edtTen);
        edtNgay = dialog.findViewById(R.id.edtNgay);

        Button btnAdd, btnCancel;
        btnAdd = dialog.findViewById(R.id.btnAdd);
        btnCancel = dialog.findViewById(R.id.btnCancel);

        edtNgay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChonNgay();
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ten = edtTen.getText().toString();
                String ngayLap = edtNgay.getText().toString();
                if(ten.equals("")){

                    Toast.makeText(HoaDon_Activity.this, "Vui lòng nhập đầy đủ thông tin món.", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(HoaDon_Activity.this, ngayLap, Toast.LENGTH_SHORT).show();
                    database.queryData("INSERT INTO HoaDon VALUES(null,'"+ten+"', '"+ngayLap+"')");
                    GetData();
                    Toast.makeText(HoaDon_Activity.this, "Đã thêm", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                GetData();
            }
        });
        dialog.show();
    }
}








