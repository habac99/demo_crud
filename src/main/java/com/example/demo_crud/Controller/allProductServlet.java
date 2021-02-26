package com.example.demo_crud.Controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

import com.example.demo_crud.DatabaseAccess.ProductAccess;
import com.example.demo_crud.Model.Product;
import com.example.demo_crud.Model.Type;

@WebServlet(name = "allProductServlet", value = "/allProduct")
public class allProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        ProductAccess pa = new ProductAccess();
        List<Product> allProducts = pa.getAllProduct();
        List<Type> allType = pa.getAllType();
        request.setAttribute("allType",allType);
        request.setAttribute("allProducts",allProducts);
        request.getRequestDispatcher("AllProduct.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
