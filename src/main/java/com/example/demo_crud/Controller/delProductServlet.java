package com.example.demo_crud.Controller;

import com.example.demo_crud.DatabaseAccess.ProductAccess;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "delProductServlet", value = "/delProduct")
public class delProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        ProductAccess pa =new ProductAccess();

            pa.deleteProduct(id);
        response.sendRedirect("Product");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
