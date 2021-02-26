package com.example.demo_crud.Controller;

import com.example.demo_crud.DatabaseAccess.OrderAccess;
import com.example.demo_crud.DatabaseAccess.ProductAccess;
import com.example.demo_crud.Model.Order;
import com.example.demo_crud.Model.Product;
import com.example.demo_crud.Model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "viewOneProductServlet", value = "/Product/")
public class viewOneProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       Integer id = Integer.parseInt(request.getParameter("id"));
        ProductAccess pa = new ProductAccess();
        Product pr = pa.getOneProduct(id);
        request.setAttribute("product",pr);
        request.getRequestDispatcher("viewOneProduct.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            HttpSession session = request.getSession();
            String email = session.getAttribute("email").toString();
            Integer id = Integer.parseInt(request.getParameter("product_id"));
            String productName = request.getParameter("product_name");
            Integer quantity = Integer.parseInt(request.getParameter("QuantityOrder"));
            Double price_each = Double.parseDouble(request.getParameter("price"));
            Double total = quantity * price_each;

            UserController uc = new UserController();
            User user = uc.getOneUser(email);
            OrderAccess oc = new OrderAccess();
            Order order = new Order();
            order.setIdProducts(id);
            order.setIdUser(user.getId());
            order.setQuantity(quantity);
            order.setPrice_each(price_each);
            order.setTotal(total);
            oc.addOrder(order);
            request.setAttribute("order", order);
            request.setAttribute("user",user);
            request.setAttribute("product_name", productName);

            request.getRequestDispatcher( "orderDetail.jsp").forward(request,response);


    }
}
