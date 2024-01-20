package com.example.btlandroid;

public class CTHD {
    public CTHD(int maHD, String tenMon, int soluong) {
        MaHD = maHD;
        TenMon = tenMon;
        Soluong = soluong;
    }

    int MaHD;
    String TenMon;
    int Soluong;

    public int getMaHD() {
        return MaHD;
    }

    public void setMaHD(int maHD) {
        MaHD = maHD;
    }

    public String getTenMon() {
        return TenMon;
    }

    public void setTenMon(String tenMon) {
        TenMon = tenMon;
    }

    public int getSoluong() {
        return Soluong;
    }

    public void setSoluong(int soluong) {
        Soluong = soluong;
    }


}
