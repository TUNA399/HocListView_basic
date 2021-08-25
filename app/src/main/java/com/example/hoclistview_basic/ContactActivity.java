package com.example.hoclistview_basic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.hoclistview_basic.adapter.ContactAdapter;
import com.example.hoclistview_basic.model.Contact;

public class ContactActivity extends AppCompatActivity {
    EditText edtMa,edtTen,edtSdt;
    Button btnNhan;
    ListView lvContact;
    ContactAdapter contactAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        addControls();
        addEvents();
    }

    private void addControls() {
        edtMa=(EditText) findViewById(R.id.edtMa);
        edtTen=(EditText) findViewById(R.id.edtTen);
        edtSdt=(EditText) findViewById(R.id.edtSdt);
        btnNhan=(Button) findViewById(R.id.btnNhan);
        lvContact=(ListView) findViewById(R.id.lvContact);
        contactAdapter=new ContactAdapter(ContactActivity.this,R.layout.item);
        lvContact.setAdapter(contactAdapter);
    }

    private void addEvents() {
        Toast.makeText(ContactActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
        btnNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xulythemContact();
            }
        });
    }

    private void xulythemContact() {
        Contact c=new Contact();
        c.setMa(Integer.parseInt(edtMa.getText().toString()));
        c.setTen(edtTen.getText().toString());
        c.setSdt(edtSdt.getText().toString());
        if(c.getTen().equals("Tuan"))
        c.setHinh(R.drawable.hinhnguoi);
        else c.setHinh(R.drawable.avatar);
        contactAdapter.add(c);//đẩy dữ liệu nhập vào ContactAdapter
    }
}