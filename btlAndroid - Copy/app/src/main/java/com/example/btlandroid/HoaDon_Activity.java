package com.example.btlandroid;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

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
        //INS

//        database.queryData("INSERT INTO ThucDon VALUES(null,'Burger bò', 58000, 12)");
//        database.queryData("INSERT INTO HoaDon VALUES(null,'Trần Minh', '20/10/2023')");
//        database.queryData("INSERT INTO HoaDon VALUES(null,'Trần Minh', '20/10/2023')");
//        database.queryData("INSERT INTO HoaDon VALUES(null,'Trần Minh', '20/10/2023')");
//        database.queryData("INSERT INTO HoaDon VALUES(null,'Trần Linh', '22/10/2023')");
        GetData();
        Toast.makeText(this, "Oke ", Toast.LENGTH_SHORT).show();

    }
    public String GetTenMon(int maMon){
        Cursor dataMon = database.getData("SELECT * FROM ThucDon WHERE Id = '"+maMon+"'");
        return  dataMon.getString(1);
    }
    private void GetData(){
        Cursor dataMon = database.getData("SELECT * FROM HoaDon");
        arrayList.clear();
        while (dataMon.moveToNext()){
            String tennv = dataMon.getString(1);
            int id = dataMon.getInt(0);
            String ngaylap = dataMon.getString(2);
            arrayList.add(new HoaDonDM(id, tennv, ngaylap));
            adapter.notifyDataSetChanged();
            //Toast.makeText(this, String.valueOf(sldaban), Toast.LENGTH_SHORT).show();
        }
    }
}
