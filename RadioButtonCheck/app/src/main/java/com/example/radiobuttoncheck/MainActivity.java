package com.example.radiobuttoncheck;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int a, b;
    TextView txtkq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ptbac1_inputdialog);

        Button btn = findViewById(R.id.btnInput);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputDialog(view);
            }
        });
    }

    public void InputDialog(View v) {
        //final EditText result = (EditText) findViewById(R.id.edtInput);
        final EditText input = new EditText(this);
        // Hiển thị MessageBox nhập a
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage("Nhập hệ số a: ");
        alert.setView(input);
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                String value = input.getText() + "";
                a = Integer.parseInt(value);
            }
        });
        alert.create().show();
        // Hiển thị MessageBox nhập b
        final EditText input2 = new EditText(this);
        AlertDialog.Builder alert2 = new AlertDialog.Builder(this);
        alert2.setMessage("Nhập hệ số b:");
        alert2.setView(input2);
        alert2.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                String value = input2.getText() + "";
                b = Integer.parseInt(value);
            }
        });
        alert2.create().show();
    }
    public void solveEquation() {
        if (a == 0) {
            // Phương trình vô nghiệm
            showAlert("Phương trình vô nghiệm");
        } else {
            double x = -b / (double) a;
            showAlert("Nghiệm của phương trình: x = " + x);
        }
        txtkq = findViewById(R.id.txtKq);
        txtkq.setText("Nghiem x = " + a);
    }

    private void showAlert(String message) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage(message);
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                // Đóng dialog
            }
        });
        alert.create().show();
    }
    public void ClickEvent(View v){
        boolean b = ((RadioButton)v).isChecked();
        AlertDialog.Builder al= new AlertDialog.Builder(this);
        al.setMessage("RadioButton");

        int id = v.getId();
        if (id == R.id.rbAnswerA) {
            al.setMessage("You selected Answer A");
            Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.rbAnswerB) {
            al.setMessage("You selected Answer B");
        } else if (id == R.id.rbAnswerC) {
            al.setMessage("You selected Answer C");
        } else if (id == R.id.rbAnswerD) {
            Toast.makeText(this, "True", Toast.LENGTH_SHORT).show();
        }
        al.create().show();
    }

}