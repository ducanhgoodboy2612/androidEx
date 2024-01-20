package com.example.studyactivityintent;

public class SanPham {
    private String Ten;
    private String Gia;
    private int Hinh;
    private int Mua;

    public SanPham(String ten, String gia, int hinh, int mua) {
        Ten = ten;
        Gia = gia;
        Hinh = hinh;
        Mua = mua;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getGia() {
        return Gia;
    }

    public void setGia(String gia) {
        Gia = gia;
    }

    public int getHinh() {
        return Hinh;
    }

    public void setHinh(int hinh) {
        Hinh = hinh;
    }

    public int getMua() {
        return Mua;
    }

    public void setMua(int mua) {
        Mua = mua;
    }
}

