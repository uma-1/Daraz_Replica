package com.example.darazreplica.model;

import com.example.darazreplica.api.ProductApi;

public class Item {
    String imgName;
    String ProductName;
    float price;

    public Item(String imgName, String productName, float price) {
        this.imgName = imgName;
        ProductName = productName;
        this.price = price;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
