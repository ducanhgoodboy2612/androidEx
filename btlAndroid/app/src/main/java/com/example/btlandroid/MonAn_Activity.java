package com.example.btlandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MonAn_Activity extends AppCompatActivity {
    private RecyclerView recyclerView;
    Database database;
    ListView listViewMon;
    ArrayList<MonAn> arrayList;
    MonAnAdapter adapter;
    EditText editSearch;
    Button btnSearch, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thucdon);
        listViewMon =  findViewById(R.id.list_item);
        arrayList = new ArrayList<>();
        adapter = new MonAnAdapter(this, R.layout.dong_mon_an, arrayList);
        listViewMon.setAdapter(adapter);
        //create database
        database = new Database(this, "GhiChu.sql", null, 1);

        GetData();
        //GetTenMon(1);
        editSearch = findViewById(R.id.editTextSearch);
        btnBack = findViewById(R.id.btnBack);
        btnSearch = findViewById(R.id.buttonSearch);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String searchCont = String.valueOf(editSearch.getText());
                Cursor dataMon = database.getData("SELECT * FROM ThucDon WHERE TenMon LIKE '%" + searchCont + "%' COLLATE NOCASE");
                arrayList.clear();
                while (dataMon.moveToNext()){
                    String ten = dataMon.getString(1);
                    int id = dataMon.getInt(0);
                    int gia = Integer.parseInt(dataMon.getString(2));
                    int sldaban = Integer.parseInt(dataMon.getString(3));
                    arrayList.add(new MonAn(id, ten, gia, sldaban));
                    adapter.notifyDataSetChanged();

                }
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetData();
            }
        });

        //Toast.makeText(this, "Ten mon " + GetTenMon(1), Toast.LENGTH_SHORT).show();

    }
    public void GetTenMon(int maMon){
        Cursor dataMon = database.getData("SELECT * FROM ThucDon WHERE Id = '" + maMon + "'");
        if (dataMon != null && dataMon.moveToFirst()) {
            // Lấy giá trị từ cột có chỉ số 1 (cột thứ 2)
            String tenMon = dataMon.getString(1);
            Toast.makeText(this, tenMon, Toast.LENGTH_SHORT).show();
            // Đảm bảo đóng Cursor sau khi sử dụng
            dataMon.close();


        }

    }
    private void GetData(){
        Cursor dataMon = database.getData("SELECT * FROM ThucDon");
        arrayList.clear();
        while (dataMon.moveToNext()){
            String ten = dataMon.getString(1);
            int id = dataMon.getInt(0);
            int gia = Integer.parseInt(dataMon.getString(2));
            int sldaban = Integer.parseInt(dataMon.getString(3));
            arrayList.add(new MonAn(id, ten, gia, sldaban));
            adapter.notifyDataSetChanged();

        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_bar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.menuAdd){
            DialogThem();
        }

        return super.onOptionsItemSelected(item);
    }
    private void DialogThem(){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.add_monan_dialog);
        EditText edtTen = dialog.findViewById(R.id.edtTen);
        EditText edtGia = dialog.findViewById(R.id.edtGia);
        EditText edtslb = dialog.findViewById(R.id.edtSLdaban);
        Button btnAdd, btnCancel;
        btnAdd = dialog.findViewById(R.id.btnAdd);
        btnCancel = dialog.findViewById(R.id.btnCancel);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ten = edtTen.getText().toString();
                String gia = edtGia.getText().toString();
                String sldb = edtslb.getText().toString();
//
                if(ten.equals("") || gia.equals("") || sldb.equals("")){

                    Toast.makeText(MonAn_Activity.this, "Vui lòng nhập đầy đủ thông tin món.", Toast.LENGTH_SHORT).show();
                }
                else{
                    int Gia = Integer.parseInt(gia);
                    int Sldb = Integer.parseInt(sldb);
                    database.queryData("INSERT INTO ThucDon VALUES(null,'"+ten+"', '"+Gia+"', '"+Sldb+"')");
                    GetData();
                    Toast.makeText(MonAn_Activity.this, "Đã thêm", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                GetData();
            }
        });
        dialog.show();
    }
    public void DialogSua(String ten, int gia, int id){
        Toast.makeText(this, ten, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, String.valueOf(gia), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, String.valueOf(id), Toast.LENGTH_SHORT).show();
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.edit_mon_dialog);

        EditText edtTen = dialog.findViewById(R.id.edtTen);
        EditText edtGia = dialog.findViewById(R.id.edtGia);
        Button btnCapNhat, btnCapNhatCancel;
        btnCapNhat = dialog.findViewById(R.id.btnEdit);
        btnCapNhatCancel = dialog.findViewById(R.id.btnCancelEdit);
        edtTen.setText(ten);
        edtGia.setText(String.valueOf(gia));
        btnCapNhatCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        btnCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tenMoi = edtTen.getText().toString().trim();
                int giaMoi = Integer.parseInt(edtGia.getText().toString().trim());
                database.queryData("UPDATE ThucDon SET TenMon='"+tenMoi+"', Gia = '"+giaMoi+"'WHERE Id = '"+id+"'");
                Toast.makeText(MonAn_Activity.this, "Đã cập nhật", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                GetData();
            }
        });
        dialog.show();
    }
    public void DialogXoa(String tenMon, int maMon){
        AlertDialog.Builder dialogXoa = new AlertDialog.Builder(this);
        dialogXoa.setMessage("Bạn có chắc chắn muôn xóa " + tenMon + " không ?");
        dialogXoa.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                database.queryData("DELETE FROM ThucDon WHERE Id = '"+maMon+"'");
                Toast.makeText(MonAn_Activity.this, "Da xoa", Toast.LENGTH_SHORT).show();
                GetData();
            }
        });
        dialogXoa.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        dialogXoa.show();
    }
}
