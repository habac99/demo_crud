package com.example.demo_crud.Model;

import java.util.List;

public class Product {
    private Integer idProducts;
    private String productName;
    private Integer idType;
    private double price;
    private String image;
    private Integer inStock;

    public Product(){}
    public Product(Integer idProducts, String productName, Integer idType, double price, String image, Integer inStock) {
        this.idProducts = idProducts;
        this.productName = productName;
        this.idType = idType;
        this.price = price;
        this.image = image;
        this.inStock = inStock;
    }
    public Integer getIdProducts(){
        return this.idProducts;
    }
    public String getProductName(){
        return this.productName;
    }
    public Integer getIdType(){
        return this.idType;
    }
    public double getPrice(){
        return this.price;
    }
    public String getImage(){
        return this.image;
    }
    public  Integer getInStock(){
        return this.inStock;
    }

    public void setIdProducts(Integer idProducts) {
        this.idProducts = idProducts;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setInStock(Integer inStock) {
        this.inStock = inStock;
    }

    public void setPrice(Float price) {
        this.price = price;
    }


}
