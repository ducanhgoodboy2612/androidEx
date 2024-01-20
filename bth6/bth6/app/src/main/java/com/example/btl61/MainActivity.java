package com.example.btl61;

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

    EditText edtUserName, edtPass;
    Button btnIns, btnDel, btnUpd, btnView;
    ListView listView;
    ArrayList<String> myList;
    ArrayAdapter<String> adapter;
    SQLiteDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtUserName = findViewById(R.id.edtuseName);
        edtPass = findViewById(R.id.edtPass);
        
        btnIns = findViewById(R.id.btnIns);
        btnUpd = findViewById(R.id.btnUpd);
        btnDel = findViewById(R.id.btnDel);
        //btnView = findViewById(R.id.btnView);
        listView = findViewById(R.id.lvAcc);

        myList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, myList);
        listView.setAdapter(adapter);

        //tao va thao tac csdl SQLite
        database = openOrCreateDatabase("qlTaiKhoan.sql", MODE_PRIVATE, null);
        //create table
        try{
            String sql = "CREATE TABLE tblAcc (userName TEXT PRIMARY KEY , pass TEXT)";
            database.execSQL(sql);
        }
        catch (Exception e){
            Log.e("Error", "Bang da ton tai");
        }



        getAllData();

        btnIns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edtUserName.getText().toString();
                String pass = edtPass.getText().toString();

                ContentValues myValues = new ContentValues();
                myValues.put("userName", username);
                myValues.put("pass", pass);

                String message = "";
                if(database.insert("tblAcc", null, myValues) == -1){
                    message = "Loi them du lieu";
                }
                else {

                    message = "Them du lieu thanh cong";
                    getAllData();
                }
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edtUserName.getText().toString();
                int n = database.delete("tblAcc","userName = ?", new String[]{username});
                String mess = "";
                if(n==0){
                    mess = "Khong xoa duoc";
                }
                else {
                    mess = n + " ban ghi duoc xoa";
                    getAllData();
                }
                Toast.makeText(MainActivity.this, mess, Toast.LENGTH_SHORT).show();
            }
        });

        btnUpd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = edtUserName.getText().toString();
                String pass = edtPass.getText().toString();

                ContentValues myValues = new ContentValues();
                myValues.put("pass", pass);
                int n = database.update("tblAcc", myValues, "userName = ?", new String[]{userName});
                String mess = "";
                if(n == 0){
                    mess = "Khong the update";
                }
                else {

                    mess = n + " ban ghi duoc update";
                    getAllData();

                }
                Toast.makeText(MainActivity.this, mess, Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void getAllData() {
        myList.clear();
        Cursor cursor = database.query("tblAcc", null, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String data = cursor.getString(0) + "-" + cursor.getString(1);
            myList.add(data);
            cursor.moveToNext();
        }
        cursor.close();
        adapter.notifyDataSetChanged();
    }

}