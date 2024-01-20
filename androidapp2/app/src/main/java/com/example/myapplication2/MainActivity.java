package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String answer1, answer2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button mbt = findViewById(R.id.btn);
        mbt.setOnClickListener(ketqua);
    }

//    public void onRadioButtonClicked1(View view){
//        boolean checked = ((RadioButton) view).isChecked();
//        switch (view.getId()){
//            case R.id.nam :
//                if(checked)
//                    answer1 = "nam";
//                break;
//
//            case R.id.nu :
//                if(checked)
//                    answer1 = "nu";
//                break;
//            default:
//                break;
//        }
//    }



    public View.OnClickListener ketqua = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            TextView textView;
            String hovaten;
            EditText name = (EditText) findViewById(R.id.hovaten);
            hovaten = name.getText().toString();
            String strKetQua = "";
            strKetQua = hovaten + "la" + answer1;

            textView = findViewById(R.id.kq);
            textView.setText(strKetQua);
        }
    };
}