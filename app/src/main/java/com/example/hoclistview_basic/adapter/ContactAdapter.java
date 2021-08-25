package com.example.hoclistview_basic.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.hoclistview_basic.R;
import com.example.hoclistview_basic.model.Contact;

import java.util.List;

public class ContactAdapter extends ArrayAdapter<Contact> {
    //đối số 1 : màng hình sử dụng layout này (giao diện này)
    Activity context;
    //đối sô 2 : layout cho từng dòng muốn hiển thị(làm theo ý khác hàng)
    int resource;
    //đối số 3: danh sách nguồn dữ liệu muốn hiển thị lên giao diện
   // List<Contact> objects;

    public ContactAdapter(@NonNull Activity context, int resource) {
        super(context, resource);
        this.context=context;
        this.resource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflfater=this.context.getLayoutInflater();
        View row=inflfater.inflate(this.resource,null);

        TextView txtId=(TextView) row.findViewById(R.id.txtId);
        TextView txtName=(TextView) row.findViewById(R.id.txtName);
        TextView txtPhone=(TextView) row.findViewById(R.id.txtPhone);
        ImageView imgAvt=(ImageView) row.findViewById(R.id.imgAvt);

        //Trả về danh bạ hiện tại muốn vẽ
        Contact contact=getItem(position);
        imgAvt.setImageResource(contact.getHinh());
        txtId.setText(contact.getMa()+"");
        txtName.setText(contact.getTen());
        txtPhone.setText(contact.getSdt());

        return row;
    }
}
