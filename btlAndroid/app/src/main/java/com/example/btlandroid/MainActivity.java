package com.example.btlandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn2, btn3;
    Database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_home);

//        database = new Database(this, "GhiChu.sql", null, 1);
//
//        database.queryData("CREATE TABLE IF NOT EXISTS ThucDon(Id INTEGER PRIMARY KEY AUTOINCREMENT, TenMon VARCHAR(300), Gia INTEGER, SlDaban INTEGER)");
//        database.queryData("CREATE TABLE IF NOT EXISTS HoaDon(Id INTEGER PRIMARY KEY AUTOINCREMENT, TenNV VARCHAR(300), NgayLap VARCHAR(100))");
//        database.queryData("CREATE TABLE IF NOT EXISTS CTHD(MaHD INTEGER, TenMon VARCHAR(300), SoLuong INTEGER)");
//
//        database.queryData("INSERT INTO ThucDon VALUES(null,'Burger Big Mac', 59000, 122)");
//        database.queryData("INSERT INTO ThucDon VALUES(null,'Burger bò', 48000, 124)");
//        database.queryData("INSERT INTO ThucDon VALUES(null,'Burger bò phomai đặc biệt', 50000, 125)");
//        database.queryData("INSERT INTO ThucDon VALUES(null,'Burger bò 2 lớp', 58000, 124)");
//        database.queryData("INSERT INTO ThucDon VALUES(null,'Burger gà sốt cay', 48000, 154)");
//        database.queryData("INSERT INTO ThucDon VALUES(null,'Burger gà Hoàng Gia', 53000, 198)");
//        database.queryData("INSERT INTO ThucDon VALUES(null,'Burger tôm chiên', 45000, 141)");
//
//        database.queryData("INSERT INTO HoaDon VALUES(null,'Trần Bình Minh', '20/10/2023')");
//        database.queryData("INSERT INTO HoaDon VALUES(null,'Trần Bình Minh', '20/10/2023')");
//        database.queryData("INSERT INTO HoaDon VALUES(null,'Nguyễn Văn Khang', '20/10/2023')");
//        database.queryData("INSERT INTO CTHD VALUES(1,'Burger tôm chiên', 2)");
//        database.queryData("INSERT INTO CTHD VALUES(1,'Burger BigMac', 3)");
//        database.queryData("INSERT INTO CTHD VALUES(2,'Burger bò', 4)");
//        database.queryData("INSERT INTO CTHD VALUES(3,'Burger bò', 2)");

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(),MonAn_Activity.class);
                startActivity(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),HoaDon_Activity.class);
                startActivity(intent);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),TrangSP.class);
                startActivity(intent);
            }
        });

    }
}
