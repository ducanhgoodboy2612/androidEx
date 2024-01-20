package com.example.qlnhahang;

public class Mon_An {
    public Mon_An(int maMon, String tenMon, int gia) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.gia = gia;
    }

    public int maMon;
    public String tenMon;
    public int gia;

    public int getMaMon() {
        return maMon;
    }

    public void setMaMon(int maMon) {
        this.maMon = maMon;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }


}
