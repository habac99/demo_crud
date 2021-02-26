<%@ page import="com.example.demo_crud.Model.User" %>
<%@ page import="com.example.demo_crud.Model.Order" %><%--
  Created by IntelliJ IDEA.
  User: gpdn_admin
  Date: 2/26/2021
  Time: 3:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

 <%
     User user = (User) request.getAttribute("user");
     Order order = (Order) request.getAttribute("order");
     String product_name = (String) request.getAttribute("product_name");
 %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

    <title>Order details</title>
</head>
<body>
<div class="container-fluid">
    <div class="container">
        <div class="form-group">
            <%--                <input type="hidden" value="<%= product.getIdProducts()%>" name = "product_id">--%>
            <label for="user_name" class="label col-form-label-lg">Name</label>
            <input type="text" id="user_name" required class="form-control" readonly name="user_name" value="<%= user.getName() %>">
        </div>
        <div class="form-group">
            <%--                <input type="hidden" value="<%= product.getIdProducts()%>" name = "product_id">--%>
            <label for="email" class="label col-form-label-lg">Email</label>
            <input type="text" id="email" required class="form-control" readonly name="email" value="<%= user.getEmail() %>">
        </div>
            <div class="form-group">

                <label for="product_name" class="label col-form-label-lg">Product Name</label>
                <input type="text" id="product_name" required class="form-control" readonly name="product_name" value="<%= product_name%>">
            </div>

            <div class="form-group">
                <label for="price" class="label col-form-label-lg">Product Price</label>
                <input type="text" id="price" required class="form-control" readonly name="price" value="<%= order.getPrice_each()%>">
            </div>
            <div class="form-group">
                <label for="QuantityOrder" class="label col-form-label-lg">Quantity</label>
                <input type="number" id="QuantityOrder" required class="form-control" readonly name="QuantityOrder" value="<%= order.getQuantity()%>" >
            </div>
        <div class="form-group">
            <label for="Total" class="label col-form-label-lg">Total</label>
            <input type="number" id="Total" required class="form-control" readonly name="Total" value="<%= order.getTotal()%>" >
        </div>
        <a href="${pageContext.request.contextPath}/Product"><input type="submit" value="Go back" class="btn btn-primary"></a>
<%--            <input type="submit" value="Confirm" class="btn btn-primary">--%>

    </div>
</div>

</body>
</html>
