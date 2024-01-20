package com.example.bmi_act;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText heightEditText, weightEditText;
        Button calculateButton;
        TextView bmiTextView, danhgiaTextView;

        heightEditText = findViewById(R.id.height);
        weightEditText = findViewById(R.id.weigh);
        bmiTextView = findViewById(R.id.kqbmi);
        danhgiaTextView = findViewById(R.id.danhgia);
        calculateButton = findViewById(R.id.calculate);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Float height = Float.parseFloat(heightEditText.getText().toString());
                Float weight = Float.parseFloat(weightEditText.getText().toString());
                float bmi = weight / (height * height);

                bmiTextView.setText(String.format("%.2f", bmi));
                if (bmi < 18) {
                    danhgiaTextView.setText("Gầy");
                } else if (bmi >= 18 && bmi <= 25) {
                    danhgiaTextView.setText("Bình thường");
                } else {
                    danhgiaTextView.setText("Béo");
                }
            }
        });
    }
}