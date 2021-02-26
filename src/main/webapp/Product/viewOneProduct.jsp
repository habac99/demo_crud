<%@ page import="com.example.demo_crud.Model.Product" %><%--
  Created by IntelliJ IDEA.
  User: gpdn_admin
  Date: 2/26/2021
  Time: 2:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if(session.getAttribute("email") == null)
        response.sendRedirect("login.jsp");
    Product product = (Product)request.getAttribute("product");
%>

<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

    <title> <%= product.getProductName() %></title>
</head>
<body>
    <div class="container-fluid">
        <div class="container">
            <form method="post" >
                <div class="form-group">
                    <input type="hidden" value="<%= product.getIdProducts()%>" name = "product_id">
                    <label for="product_name" class="label col-form-label-lg">Product Name</label>
                    <input type="text" id="product_name" required class="form-control" placeholder="Enter product name" name="product_name" value="<%= product.getProductName() %>">
                </div>

                <div class="form-group">
                    <label for="price" class="label col-form-label-lg">Product Price</label>
                    <input type="text" id="price" required class="form-control" placeholder="Enter price" name="price" value="<%= product.getPrice()%>">
                </div>
                <div class="form-group">
                    <label for="QuantityOrder" class="label col-form-label-lg">Quantity</label>
                    <input type="number" id="QuantityOrder" required class="form-control" placeholder="Enter quantity" name="QuantityOrder" >
                </div>
                <input type="submit" value="Order" class="btn btn-primary">
            </form>
        </div>
    </div>

</body>
</html>
