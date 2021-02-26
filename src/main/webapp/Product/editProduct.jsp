<%@ page import="com.example.demo_crud.Model.Type" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.demo_crud.Model.Product" %><%--
  Created by IntelliJ IDEA.
  User: gpdn_admin
  Date: 2/26/2021
  Time: 10:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit product</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

</head>
<body>
<%
    if(session.getAttribute("email") == null)
        response.sendRedirect("login.jsp");
%>
    <div class="container-fluid">
        <div class="container">
            <div align="center">
                <p> Edit product</p>
            </div>

            <div class="justify-content-center">

                <form method="post" action="edit" >
                    <%
                        Product pr = (Product)request.getAttribute("product");
                    %>
                    <div class="form-group">
                        <input type="hidden" value="<%= pr.getIdProducts()%>" name = "product_id">
                        <label for="product_name" class="label col-form-label-lg">Product Name</label>
                        <input type="text" id="product_name" required class="form-control" placeholder="Enter product name" name="product_name" value="<%= pr.getProductName() %>">
                    </div>
                    <div class="form-group">
                        <label for="type_id" style="margin-right: 30px" class="label label-primary">Type</label>
                        <%
                            List<Type> allType = (List<Type>)request.getAttribute("allType");



                            for(Type type:allType){%>

                        <input   <%
                                        if(type.getIdType().equals(pr.getIdType())) %>
                                checked
                                type="radio" id="type_id" name="type_id" value="<%= type.getIdType() %>"  style="margin-left: 30px"><%= type.getName()%>
                        <%}

                        %>
                    </div>
                    <div class="form-group">
                        <label for="price" class="label col-form-label-lg">Product Price</label>
                        <input type="text" id="price" required class="form-control" placeholder="Enter price" name="price" value="<%= pr.getPrice()%>">
                    </div>
                    <div class="form-group">
                        <label for="inStock" class="label col-form-label-lg">Quantity</label>
                        <input type="text" id="inStock" required class="form-control" placeholder="Enter quantity" name="inStock" value="<%= pr.getInStock()%>">
                    </div>
                    <input type="submit" class="btn btn-primary">
                    <%--                        <button type="button" class="btn btn-secondary btn_dismiss" data-dismiss="modal">Close</button>--%>
                </form>
            </div>
        </div>
    </div>


</body>
</html>
