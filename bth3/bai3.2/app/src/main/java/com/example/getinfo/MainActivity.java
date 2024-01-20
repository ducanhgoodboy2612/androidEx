package com.example.getinfo;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.*;


public class MainActivity extends AppCompatActivity {

    EditText edht, edcmt, edbm;
    CheckBox cbds, cbdb, cbdc;
    RadioButton rbdh, rbcd, rbtc;
    RadioGroup rdbc;
    Button btok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    public void init()

    {
        edht=(EditText)findViewById(R.id.edthoten);
        edcmt=(EditText)findViewById(R.id.edtcmt);
        edbm = (EditText)findViewById(R.id.edbm);
        cbds=(CheckBox)findViewById(R.id.cbds);
        cbdb=(CheckBox)findViewById(R.id.cbdb);
        cbdc=(CheckBox)findViewById(R.id.cbdc);
        rbdh=(RadioButton)findViewById(R.id.rbdh);
        rbcd=(RadioButton)findViewById(R.id.rbcd);
        rbtc=(RadioButton)findViewById(R.id.rbtc);
        rdbc=(RadioGroup)findViewById(R.id.rgbc);
//        edbm=(EditText)findViewById(R.id.edtbomon);
        btok=(Button)findViewById(R.id.btnok);

    }

    public void clickok(View view)

    {
        AlertDialog.Builder al=new AlertDialog.Builder(this);
        al.setTitle("Thông tin bạn vừa nhập!");
        String s="",bc="",st="";

        //Lay TT bang cap
        int isCheck=rdbc.getCheckedRadioButtonId();
        if (isCheck == R.id.rbdh) {
            bc = bc + "Đại học"
            ;
        } else if (isCheck == R.id.rbcd) {
            bc = bc + "Cao đẳng"
            ;
        } else if (isCheck == R.id.rbtc) {
            bc = bc + "Trung cấp";
        }

        if(cbds.isChecked())
            st=st+"Đọc sách-";
        if(cbdb.isChecked())
            st=st+"Đọc báo-";
        if(cbdc.isChecked())
            st=st+"Đọc code";
        s="\nHọ tên: "+edht.getText();
        s=s+"\n Số CMTND: "+edcmt.getText();
        s=s+"\nSở thích: "+st;
        s=s+"\nBằng cấp:"+bc;
        s=s+"\nNơi công tác: Bộ môn " + edbm.getText() + "\nKhoa CNTT - UTEHY";
        al.setMessage(s);
        al.create().show();
    }
}