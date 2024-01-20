package com.materialuiux.store.model;

public class glasses {

    private int urlImage;
    private String brand;


    public glasses(int urlImage, String brand) {
        this.urlImage = urlImage;
        this.brand = brand;
    }

    public int getUrlImage() {
        return urlImage;
    }

    public String getBrand() {
        return brand;
    }
}
