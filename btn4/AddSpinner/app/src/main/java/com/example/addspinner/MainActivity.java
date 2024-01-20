package com.example.addspinner;

import java.util.ArrayList;
import java.util.List;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends Activity {

    List<String> li;
    Spinner sp1,sp2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        li=new ArrayList<String>();

        li.add("Data 1");
        li.add("Data 2");

        sp1=(Spinner) findViewById(R.id.spinner1);
        sp2=(Spinner) findViewById(R.id.spinner2);
        Button b=(Button) findViewById(R.id.button1);
        final EditText et=(EditText) findViewById(R.id.editText1);
        call();

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// TODO Auto-generated method stub
                li.add(et.getText().toString());
                et.setText(null);
                call();
            }
        });
    }

    public void call() {
// TODO Auto-generated method stub

        ArrayAdapter<String> adp=new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line,li);
        adp.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        sp1.setAdapter(adp);
        sp2.setAdapter(adp);
        sp1.setSelection((li.size()-1));


        sp1.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,int arg2, long arg3) {
// TODO Auto-generated method stub
                sp2.setSelection(arg2);
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
// TODO Auto-generated method stub
            }
        });
    }


}