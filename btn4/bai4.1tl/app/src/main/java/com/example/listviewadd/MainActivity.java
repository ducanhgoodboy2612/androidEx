package com.example.listviewadd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import android.os.Bundle;

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
        editText = findViewById(R.id.idEdt);
        btnAdd = findViewById(R.id.btnAdd);


        itemList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String selectedItem = (String) parent.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, "Ban" + selectedItem, Toast.LENGTH_SHORT).show();

                editText.setText(selectedItem);
            }
        });


        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            selectedItemPosition = i;
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newItem = editText.getText().toString();
                if(!newItem.isEmpty()){
                    itemList.add(newItem);
                    adapter.notifyDataSetChanged();
                    editText.setText("");
                }
                else {
                    Toast.makeText(MainActivity.this, "Ban phai nhap noi dung truoc", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}