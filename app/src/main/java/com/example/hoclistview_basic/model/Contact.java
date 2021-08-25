package com.example.hoclistview_basic.model;

import java.io.Serializable;

public class Contact implements Serializable {
    private int ma;
    private String ten;
    private String sdt;
    private  int hinh;

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }

    public Contact() {
    }

    public Contact(int ma, String ten, String sdt,int hinh) {
        this.ma = ma;
        this.ten = ten;
        this.sdt = sdt;
        this.hinh=hinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    //@Override
  /*  public String toString() {
        return this.ma+"/"+this.ten+"/"+this.sdt;
    }*/
}