package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvTraiCay;
    ArrayList<TraiCay> arrtraicay;
    TraiCayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        adapter = new TraiCayAdapter(this,R.layout.dong_trai_cay,arrtraicay);
        lvTraiCay.setAdapter(adapter);
    }
    private void AnhXa(){
        lvTraiCay = findViewById(R.id.listview);
        arrtraicay = new ArrayList<>();
        arrtraicay.add(new TraiCay("Cam ngon","Vinh",R.drawable.camngon));
        arrtraicay.add(new TraiCay("Cherry","Không biết",R.drawable.cherryngon));
        arrtraicay.add(new TraiCay("Dâu tây","Lạng sơn",R.drawable.dautay));
        arrtraicay.add(new TraiCay("Dừa","Bến tre",R.drawable.camngon));
        arrtraicay.add(new TraiCay("Kiwi","Đố biết", R.drawable.anh1));
        arrtraicay.add(new TraiCay("Kiwi","Đố biết", R.drawable.dautay));
    }
}