package com.example.listviewdemo;

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
        btnEdit = findViewById(R.id.btnEdit);
        btnDel = findViewById(R.id.btnDel);

        itemList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemList);
        listView.setAdapter(adapter);



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
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String updateItem = editText.getText().toString();
                if(selectedItemPosition != -1 && !updateItem.isEmpty()){
                    itemList.set(selectedItemPosition, updateItem);
                    adapter.notifyDataSetChanged();
                    editText.setText("");
                    selectedItemPosition = -1;

                }
                else {
                    Toast.makeText(MainActivity.this, "Ban phai chon muc muon sua va nhap du lieu moi", Toast.LENGTH_SHORT).show();
                }
            }
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

    //search
    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            adapter.getFilter().filter(charSequence.toString());
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
}