package com.example.bai44;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private EditText editText;
    private Button btnAdd, btnEdit, btnDel;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> itemList;

    private int selectedItemPosition = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        btnDel = findViewById(R.id.btnDelete);

        itemList = new ArrayList<>(Arrays.asList("Apple", "Cherry", "Jack-fruit", "Mango"));
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemList);
        listView.setAdapter(adapter);



        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            selectedItemPosition = i;
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedItemPosition != -1){
                    itemList.remove(selectedItemPosition);
                    adapter.notifyDataSetChanged();
                    selectedItemPosition = -1;
                }
                else {
                    Toast.makeText(MainActivity.this, "Ban can chon muc can xoa ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}