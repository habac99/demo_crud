package com.example.demo_crud.Controller;

import com.example.demo_crud.DatabaseAccess.ProductAccess;
import com.example.demo_crud.Model.Product;
import com.example.demo_crud.Model.Type;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "editProductServlet", value = "/Product/edit")
public class editProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.sendRedirect("editProduct.jsp");
        Integer id = Integer.parseInt(request.getParameter("id"));
        ProductAccess pa =new ProductAccess();
        Product pr = pa.getOneProduct(id);
        List<Type> allType = pa.getAllType();
        request.setAttribute("product",pr);
        request.setAttribute("allType", allType);
        request.getRequestDispatcher("editProduct.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer productId = Integer.parseInt(request.getParameter("product_id"));
        String productName = request.getParameter("product_name");
        Integer typeId = Integer.parseInt(request.getParameter("type_id")) ;
        Double price = Double.parseDouble(request.getParameter("price"));
        Integer inStock = Integer.parseInt(request.getParameter("inStock"));
        Product product = new Product(productId,productName, typeId,price,"emmpty",inStock);
        ProductAccess pa = new ProductAccess();
        Boolean result =  pa.editProduct(product);
        HttpSession session = request.getSession();
        response.sendRedirect(request.getContextPath()+"/Product");
    }
}
