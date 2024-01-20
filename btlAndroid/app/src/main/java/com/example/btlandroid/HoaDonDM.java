package com.example.btlandroid;

public class HoaDonDM {
    int MaHD;
    String TenNV;
    String NgayLap;

    public int getMaHD() {
        return MaHD;
    }

    public void setMaHD(int maHD) {
        MaHD = maHD;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String tenNV) {
        TenNV = tenNV;
    }

    public String getNgayLap() {
        return NgayLap;
    }

    public void setNgayLap(String ngayLap) {
        NgayLap = ngayLap;
    }



    public HoaDonDM(int maHD, String tenNV, String ngayLap) {
        MaHD = maHD;
        TenNV = tenNV;
        NgayLap = ngayLap;
    }



}
