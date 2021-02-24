package com.example.demo_crud.Model;

public class Product {
    private Integer idproducts;
    private String productname;
    private Integer idtype;
    private Float price;
    private String image;
    private Integer instock;

    public Product(Integer idproducts, String productname, Integer idtype, Float price, String image, Integer instock) {
        this.idproducts = idproducts;
        this.productname = productname;
        this.idtype = idtype;
        this.price = price;
        this.image = image;
        this.instock = instock;
    }
    public Integer getIdproducts(){
        return this.idproducts;
    }
    public String getProductname(){
        return this.productname;
    }

}
