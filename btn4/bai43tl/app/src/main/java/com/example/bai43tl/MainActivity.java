package com.example.bai43tl;

import androidx.appcompat.app.AlertDialog;
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

public class MainActivity extends AppCompatActivity {

    private Spinner spCountry;
    private Spinner spList;
    private EditText edClass;
    private Button btInsert;
    private Button btSubmit;
    private ArrayList<String> countryList;

    private ArrayAdapter<String> countryAdapter;
    private ArrayAdapter<String> classAdapter;
//    private int selectedItemPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spCountry = findViewById(R.id.spCountry);
        spList = findViewById(R.id.spList);
        edClass = findViewById(R.id.edClass);
        btInsert = findViewById(R.id.btInsert);
        btSubmit = findViewById(R.id.btSubmit);

        countryList = new ArrayList<>(Arrays.asList("MALAYSIA", "USA", "INDONESIA ", "FRANCE"));

        countryAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, countryList);
        countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCountry.setAdapter(countryAdapter);


        classAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        classAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spList.setAdapter(classAdapter);

        // Bắt sự kiện chọn một mục trong Spinner Country
//        spCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                String selectedCountry = parent.getItemAtPosition(position).toString();
//                showAlertDialog(selectedCountry);
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });

        // Bắt sự kiện nhấn nút Insert Class
        btInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newClass = edClass.getText().toString().trim();
                if (!newClass.isEmpty()) {
                    classAdapter.add(newClass);
                    classAdapter.notifyDataSetChanged();
                    edClass.setText("");
                    showAlertDialog("Class " + newClass + " added.");
                }
            }
        });

        // Bắt sự kiện nhấn nút Submit
        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedItemPosition = spCountry.getSelectedItemPosition();

                if (selectedItemPosition != AdapterView.INVALID_POSITION) {
                    // Get
                    String selectedCountry = countryList.get(selectedItemPosition);
                    countryList.remove(selectedItemPosition);
                    countryAdapter.notifyDataSetChanged();

                    if (countryList.isEmpty()) {
                        spCountry.setSelection(0);
                    }
                }
            }
        });
    }

    private void showAlertDialog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message)
                .setTitle("Alert")
                .setPositiveButton("OK", null)
                .create()
                .show();
    }
}
