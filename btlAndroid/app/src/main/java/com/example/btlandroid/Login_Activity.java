package com.example.btlandroid;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
public class Login_Activity extends AppCompatActivity {
    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;
    Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.btnLogin);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if (username.equals("abc") && password.equals("123")) {
                    //DatabaseInit();
                    Intent intent = new Intent(v.getContext(),MainActivity.class);
                    startActivity(intent);
                } else {
                    showErrorMessageDialog();
                }
            }
        });
    }

    private void showErrorMessageDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Lỗi");
        builder.setMessage("Tên tài khoản hoặc mật khẩu không chính xác.");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }
    private void DatabaseInit(){
        database = new Database(this, "GhiChu.sql", null, 1);

        database.queryData("CREATE TABLE IF NOT EXISTS ThucDon(Id INTEGER PRIMARY KEY AUTOINCREMENT, TenMon VARCHAR(300), Gia INTEGER, SlDaban INTEGER)");
        database.queryData("CREATE TABLE IF NOT EXISTS HoaDon(Id INTEGER PRIMARY KEY AUTOINCREMENT, TenNV VARCHAR(300), NgayLap VARCHAR(100))");
        database.queryData("CREATE TABLE IF NOT EXISTS CTHD(MaHD INTEGER, TenMon VARCHAR(300), SoLuong INTEGER)");

        database.queryData("INSERT INTO ThucDon VALUES(null,'Burger Big Mac', 59000, 122)");
        database.queryData("INSERT INTO ThucDon VALUES(null,'Burger bò', 48000, 124)");
        database.queryData("INSERT INTO ThucDon VALUES(null,'Burger bò phomai đặc biệt', 50000, 125)");
        database.queryData("INSERT INTO ThucDon VALUES(null,'Burger bò 2 lớp', 58000, 124)");
        database.queryData("INSERT INTO ThucDon VALUES(null,'Burger gà sốt cay', 48000, 154)");
        database.queryData("INSERT INTO ThucDon VALUES(null,'Burger gà Hoàng Gia', 53000, 198)");
        database.queryData("INSERT INTO ThucDon VALUES(null,'Burger tôm chiên', 45000, 141)");

        database.queryData("INSERT INTO HoaDon VALUES(null,'Trần Bình Minh', '20/10/2023')");
        database.queryData("INSERT INTO HoaDon VALUES(null,'Trần Bình Minh', '20/10/2023')");
        database.queryData("INSERT INTO HoaDon VALUES(null,'Nguyễn Văn Khang', '20/10/2023')");
        database.queryData("INSERT INTO HoaDon VALUES(null,'Nguyễn Văn Khang', '20/10/2023')");
        database.queryData("INSERT INTO HoaDon VALUES(null,'Nguyễn Văn Khang', '23/10/2023')");

//        database.queryData("INSERT INTO CTHD VALUES(1,'Burger tôm chiên', 2)");
        //database.queryData("INSERT INTO CTHD VALUES(1,'Burger BigMac', 3)");
        database.queryData("INSERT INTO CTHD VALUES(2,'Burger bò', 4)");
        database.queryData("INSERT INTO CTHD VALUES(3,'Burger bò', 2)");
        database.queryData("INSERT INTO CTHD VALUES(4,'Burger gà sốt cay', 1)");
        database.queryData("INSERT INTO CTHD VALUES(4,'Burger Big Mac', 1)");
        database.queryData("INSERT INTO CTHD VALUES(5,'Burger gà Hoàng Gia', 1)");
        database.queryData("INSERT INTO CTHD VALUES(5,'Burger Big Mac', 1)");
    }
}
