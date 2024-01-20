package com.example.bai42tl;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private ArrayList<String> colorList;
    String[] bankNames = {};
    Spinner spinner;
    ArrayAdapter<String> aa;

    EditText colorEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.simpleSpinner);
        spinner.setOnItemSelectedListener(this);

        colorList = new ArrayList<>(Arrays.asList("GREEN", "YELLOW", "RED", "VIOLET", "BLACK"));
        aa = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, colorList);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(aa);

        Button btn = findViewById(R.id.btnAdd);
        colorEditText = findViewById(R.id.idEdt);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addColor();
            }
        });
    }

    private void addColor() {
        String newColor = colorEditText.getText().toString().trim();

        if (!newColor.isEmpty()) {
            colorList.add(newColor);
            aa.notifyDataSetChanged();

            // Chọn màu mới được thêm
            spinner.setSelection(colorList.size() - 1);
        }
    }

    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        Toast.makeText(getApplicationContext(), bankNames[position], Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    // Hàm thêm một phần tử vào mảng
    private String[] addItemToArray(String[] arr, String item) {
        String[] newArr = new String[arr.length + 1];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        newArr[arr.length] = item;
        return newArr;
    }
}
