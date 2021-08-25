package com.example.hoclistview_basic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtDangNhap, edtMatKhau;
    Button btnDangNhap;
    Spinner spGioiTinh;
    CheckBox chkLuu;
    ArrayAdapter<String> adapter ;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        //tạo tệp tin để lưu vào...lưu ý không khởi tạo ở phạm vi toàn cục
        sharedPreferences=getSharedPreferences("DuLieuDangNHap",MODE_PRIVATE);
        docData();
        addEvents();
    }

    private void docData() {
        String tenDangNhap=sharedPreferences.getString("TenDangNhap","");
        String matKhau=sharedPreferences.getString("MatKhau","");
        boolean checked=sharedPreferences.getBoolean("TrangThaiChecked",false);
        edtDangNhap.setText(tenDangNhap);
        edtMatKhau.setText(matKhau);
        if(checked) chkLuu.setChecked(true);
    }

    private void addEvents() {
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kiemtradangnhap();
            }
        });
        spGioiTinh.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Giới tính "+adapter.getItem(i), Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    private void kiemtradangnhap() {
        if (edtDangNhap.getText().toString().equals("Tuan399") && edtMatKhau.getText().toString().equals("20200399")) {
            Intent intent = new Intent(MainActivity.this, ContactActivity.class);
            startActivity(intent);
            if(chkLuu.isChecked()){
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("TenDangNhap",edtDangNhap.getText().toString());
                editor.putString("MatKhau",edtMatKhau.getText().toString());
                editor.putBoolean("TrangThaiChecked",true);
                editor.commit();
            }
            else{
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.remove("TenDangNhap");
                editor.remove("MatKhau");
                editor.remove("TrangThaiChecked");
                editor.commit();
            }
        } else Toast.makeText(MainActivity.this, "Đăng nhập thất bại", Toast.LENGTH_LONG).show();
    }

    private void addControls() {
        edtDangNhap = (EditText) findViewById(R.id.edtDangNhap);
        edtMatKhau = (EditText) findViewById(R.id.edtMatKhau);
        btnDangNhap = (Button) findViewById(R.id.btnDangNhap);
        spGioiTinh=(Spinner) findViewById(R.id.spGioiTinh);
        adapter=new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_spinner_item
                );
        adapter.add("Nam");
        adapter.add("Nữ");
        adapter.add("Khác");
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spGioiTinh.setAdapter(adapter);
        chkLuu=(CheckBox) findViewById(R.id.chkLuu);
    }
}