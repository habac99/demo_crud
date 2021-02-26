package com.example.demo_crud.Controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import com.example.demo_crud.Controller.UserController;
import com.example.demo_crud.Model.User;

@WebServlet(name = "LoginServlet", value = "/Login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request,response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if(UserController.ValidateLogin(email,password)){

            HttpSession session = request.getSession();
            session.setAttribute("email",email);
            response.sendRedirect("Home.jsp");
//            out.println("welcome "+ email);
        }else{
            out.println("Wrong email or password");
            response.sendRedirect("login.jsp");
        }
    }
}
