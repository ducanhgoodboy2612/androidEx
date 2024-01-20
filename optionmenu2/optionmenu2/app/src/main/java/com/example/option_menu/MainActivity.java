package com.example.option_menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText hsa, hsb, hsc;
    String ha = "", hb = "", hc="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btnPopup);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowMenu();
            }
        });
    }
    private void ShowMenu(){
        PopupMenu popupMenu = new PopupMenu(this,btn);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu,popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menuThem:btn.setText("Menu Thêm");
                        break;
                    case R.id.menuSua:btn.setText("Menu Sửa");
                    break;
                    case R.id.menuXoa:btn.setText("Menu Xóa");
                    break;
                }
                return false;
            }
        });
        popupMenu.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.one:
                setContentView(R.layout.activity_giaiptbac2);
                hsa = findViewById(R.id.hsa);
                hsb = findViewById(R.id.hsb);
                hsc = findViewById(R.id.hsc);
                so1Euqation();
                return true;
            case R.id.two:
                setContentView(R.layout.activity_hinhthang);
                Intent intent = getIntent();
                ha = intent.getStringExtra("hesoa");
                hb = intent.getStringExtra("hesob");
                hc = intent.getStringExtra("hesoc");
                hsa = findViewById(R.id.hsa);
                hsa.setText(ha, TextView.BufferType.EDITABLE);
                hsb = findViewById(R.id.hsb);
                hsb.setText(hb, TextView.BufferType.EDITABLE);
                hsc = findViewById(R.id.hsc);
                hsc.setText(hc, TextView.BufferType.EDITABLE);
                so1Euqation();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void so1Euqation(){
        Button answer = findViewById(R.id.btnAnswerPTB2);
        answer.setOnClickListener(onAnser);
        //Trở về giao diện chính
        Button returnMain = findViewById(R.id.btnback);
        returnMain.setOnClickListener(onReturn);
    }
    public View.OnClickListener onReturn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ha = hsa.getText().toString();
            hb = hsb.getText().toString();
            hc = hsc.getText().toString();
            Intent nextScreen = new Intent(getApplicationContext(), MainActivity.class);
            nextScreen.putExtra("hesoa",ha);
            nextScreen.putExtra("hesob",hb);
            nextScreen.putExtra("hesoc",hc);
            startActivity(nextScreen);

        }
    };
    public View.OnClickListener onAnser = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            double a,b,c;
            double x1=0.0, x2=0.0,x3=0.0, re=0.0, im =0.0;
            double delta;
            TextView textView;
            //Chuyển đổi hệ số a,b,c từ string sang double
            a = Double.parseDouble(hsa.getText().toString());
            b = Double.parseDouble(hsb.getText().toString());
            c = Double.parseDouble(hsc.getText().toString());

            //tính đelta và giải phương trình
            delta = b*b - 4*a*c;
            if(delta>=0){x1 = (-b+Math.sqrt(delta))/(2*a);
                x2 = (-b-Math.sqrt(delta))/(2*a);
            }else
            {
                re = -b/(2*a);
                im = Math.sqrt(-delta)/(2*a);
            }
            String chuoiKQ="";
            //định dạng hiển thị
            ha = hsa.getText().toString();
            if(delta>=0){
                chuoiKQ = "Delta >=0: x1 = "+ha+
                        String.format(Locale.US,"%5.2f",x1)+"x2 = "+
                        String.format(Locale.US,"%5.2f",x2);

            }
            else{
                chuoiKQ = "Delta <0: x1,x2 = "+ha+
                        String.format(Locale.US,"%5.2f",re)+" +-j"+
                        String.format(Locale.US,"%5.2f",im);
            }
            //Hiển thị kết quả
            textView = findViewById(R.id.idkq);
            textView.setText(chuoiKQ);
        }
    };
}