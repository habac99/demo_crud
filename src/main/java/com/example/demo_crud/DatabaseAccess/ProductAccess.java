package com.example.demo_crud.DatabaseAccess;
import com.example.demo_crud.DatabaseAccess.DataAccess;
import com.example.demo_crud.Model.Product;
import com.example.demo_crud.Model.Type;
import scala.concurrent.impl.FutureConvertersImpl;

import javax.swing.plaf.nimbus.State;
import java.security.PublicKey;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductAccess {
    protected Connection getConnection() throws SQLException, ClassNotFoundException {
        Connection con = DataAccess.AccessDB();
        return con;
    }

    public ProductAccess() {

    }
    public List<Type> getAllType(){
        List<Type> allType = new ArrayList<>();
        try{
            Connection con = getConnection();
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("select idType, name from producttype");
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return allType;
    }

    public List<Product> getAllProduct() {
        List<Product> allProducts = new ArrayList<>();
        try {
            Connection con = getConnection();

            Statement statement = con.createStatement();


            ResultSet rs = statement.executeQuery("select * from products order by idproducts desc ");
            while (rs.next()) {
                Integer id = rs.getInt("idproducts");
                String productName = rs.getString("productname");
                Integer typeId = rs.getInt("idtype");
                double price = rs.getDouble("price");
                String image = rs.getString("image");
                Integer inStock = rs.getInt("instock");
                Product pr = new Product(id, productName, typeId, price, image, inStock);
                allProducts.add(pr);


            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        return allProducts;
    }

    public void insertProduct(Product product) {
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("insert into products (productName, idtype, price, image, instock) value (?,?,?,?,?)");
            ps.setString(1, product.getProductName());
            ps.setInt(2, product.getIdType());
            ps.setDouble(3, product.getPrice());
            ps.setString(4, product.getImage());
            ps.setInt(5, product.getInStock());
            System.out.println(ps);
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }


    public static void main(String[] args) {
        ProductAccess pa = new ProductAccess();
        Product product = new Product(1, "pr1", 1, 50.5, "empty", 50);
        pa.insertProduct(product);
        List<Product> all = pa.getAllProduct();
        System.out.println(all.get(2).getProductName());

    }
}
