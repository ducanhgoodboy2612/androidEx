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

        database = new Database(this, "GhiChu.sql", null, 1);
        //create table

        database.queryData("CREATE TABLE IF NOT EXISTS ThucDon(Id INTEGER PRIMARY KEY AUTOINCREMENT, TenMon VARCHAR(300), Gia INTEGER, SlDaban INTEGER)");
        //INS
//        database.queryData("INSERT INTO ThucDon VALUES(null,'Burger Big Mac', 59000, 122)");
//        database.queryData("INSERT INTO ThucDon VALUES(null,'Burger bò', 58000, 124)");
//        database.queryData("INSERT INTO ThucDon VALUES(null,'Burger tôm', 45000, 141)");

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

    }
}
