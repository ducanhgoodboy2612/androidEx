package com.example.sqlite125214;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Database database;
    ListView lvCongViec;
    ArrayList<CongViec> arrayCongViec;
    CongViecAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvCongViec = findViewById(R.id.listview);
        arrayCongViec = new ArrayList<>();
        //
        adapter = new CongViecAdapter(this, R.layout.dong_cong_viec,arrayCongViec);
        lvCongViec.setAdapter(adapter);


        //tạo database
        database = new Database(this,"thoigianbieu.sql",null,1);
        //tao bang CongViec
        database.QueryDate("CREATE TABLE IF NOT EXISTS CongViec(Id INTEGER PRIMARY KEY AUTOINCREMENT, TenCV VARCHAR(200))");
        //Chèn CSDL vào bảng
        //database.QueryDate("INSERT INTO CongViec VALUES(null,'Finish lesson and rest')");
        database.QueryDate("INSERT INTO CongViec VALUES(null,'Excersise')");
        database.QueryDate("INSERT INTO CongViec VALUES(null,'Repairing the car')");
        Cursor dataCongViec = database.GetData("SELECT * FROM CongViec");
        while(dataCongViec.moveToNext()){
            String tenCV = dataCongViec.getString(1);
            int id = dataCongViec.getInt(0);
            arrayCongViec.add(new CongViec(id,tenCV));
            adapter.notifyDataSetChanged();
            Toast.makeText(this, "Tên công việc bạn phải làm là: "+tenCV, Toast.LENGTH_SHORT).show();
        }

    }
}