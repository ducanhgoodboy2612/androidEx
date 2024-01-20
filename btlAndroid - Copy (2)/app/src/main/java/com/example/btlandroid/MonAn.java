package com.example.btlandroid;

public class MonAn {
    int MaMon;
    String TenMon;

    public MonAn(int maMon, String tenMon, int gia, int slban) {
        MaMon = maMon;
        TenMon = tenMon;
        Gia = gia;
        Slban = slban;
    }

    int Gia;
    int Slban;

    public int getMaMon() {
        return MaMon;
    }

    public void setMaMon(int maMon) {
        MaMon = maMon;
    }

    public String getTenMon() {
        return TenMon;
    }

    public void setTenMon(String tenMon) {
        TenMon = tenMon;
    }

    public int getGia() {
        return Gia;
    }

    public void setGia(int gia) {
        Gia = gia;
    }

    public int getSlban() {
        return Slban;
    }

    public void setSlban(int slban) {
        Slban = slban;
    }


}
