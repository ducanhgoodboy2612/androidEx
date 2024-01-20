package com.materialuiux.store.model;

public class Clothes {
    private int urlImage;
    private String Titlle;
    private String Brand;
    private int Price;

    public Clothes(int urlImage, String titlle, String brand, int price) {
        this.urlImage = urlImage;
        Titlle = titlle;
        Brand = brand;
        Price = price;
    }


    public int getUrlImage() {
        return urlImage;
    }

    public String getTitlle() {
        return Titlle;
    }

    public String getBrand() {
        return Brand;
    }

    public int getPrice() {
        return Price;
    }
}


