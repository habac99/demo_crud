package com.example.demo_crud.DatabaseAccess;

import com.example.demo_crud.Model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderAccess {
    protected Connection getConnection() throws SQLException, ClassNotFoundException {
        Connection con = DataAccess.AccessDB();
        return con;
    }

    public void addOrder(Order order){
        try {
            Connection con =getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "insert into orders ( iduser, idproducts, quantity, price_each, total) value (?, ?, ?, ?, ?) ");
            ps.setInt(1,order.getIdUser());
            ps.setInt(2,order.getIdProducts());
            ps.setInt(3,order.getQuantity());
            ps.setDouble(4,order.getPrice_each());
            ps.setDouble(5,order.getTotal());
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
}
