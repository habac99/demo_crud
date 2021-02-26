package com.example.demo_crud.Model;

import scala.Int;

public class Order {
    private Integer idOrders;
    private Integer idUser;
    private Integer idProducts;
    private Integer quantity;
    private Double price_each;
    private Double total;

    public void setIdProducts(Integer idProducts) {
        this.idProducts = idProducts;
    }

    public void setIdOrders(Integer idOrders) {
        this.idOrders = idOrders;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public void setPrice_each(Double price_each) {
        this.price_each = price_each;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getIdOrders() {
        return this.idOrders;
    }

    public Integer getIdProducts() {
        return this.idProducts;
    }

    public Integer getIdUser() {
        return this.idUser;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public Double getPrice_each() {
        return this.price_each;
    }

    public Double getTotal() {
        return this.total;
    }
}
