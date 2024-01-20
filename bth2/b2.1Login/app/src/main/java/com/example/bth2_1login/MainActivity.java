package com.example.bth2_1login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

        EditText acc, pass;
        acc = findViewById(R.id.acc);
        pass = findViewById(R.id.pass);
        Button btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String account = acc.getText().toString();
                String password = pass.getText().toString();
                TextView txtmes = findViewById(R.id.message);
                if(account.equals("FIT")&&password.equals("123")) {
                    txtmes.setText("DANG NHAP THANH CONG");
                }
                else
                    txtmes.setText("DANG NHAP THAT BAI");

                Intent intent = new Intent(view.getContext(),HomeAct.class);
                startActivity(intent);
            }

        });
    }
}