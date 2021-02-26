package com.example.demo_crud.Controller;

import com.example.demo_crud.DatabaseAccess.ProductAccess;
import com.example.demo_crud.Model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "addProductServlet", value = "/addProduct")
public class addProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NumberFormatException {
        String productName = request.getParameter("product_name");
        String sTypeId = request.getParameter("type_id");
        Integer typeId = Integer.parseInt(sTypeId) ;
        Double price = Double.parseDouble(request.getParameter("price"));
        Integer inStock = Integer.parseInt(request.getParameter("inStock"));
        Product product = new Product(1,productName, typeId,price, "empty", inStock);
        ProductAccess pa = new ProductAccess();
        pa.insertProduct(product);
        response.sendRedirect("allProduct");


    }
}
