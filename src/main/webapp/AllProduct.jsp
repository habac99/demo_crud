<%@ page import="com.example.demo_crud.Model.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.demo_crud.Model.Type" %><%--
  Created by IntelliJ IDEA.
  User: gpdn_admin
  Date: 2/25/2021
  Time: 10:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All product</title>
    <link rel="stylesheet" href="Style/Style.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
</head>
<body>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>
<%
    if(session.getAttribute("email") == null)
        response.sendRedirect("login.jsp");
%>
<div class="justify-content-center">
    <div align="center">
        <p> This is product page</p>
    </div>
    <button type="button" id="abcd" class="btn btn-primary" data-toggle="modal" data-target="#add_product_form" data-backdrop="static">
       Add new
    </button>

    <div id="add_product_form" class="modal fade">
        <div class="modal-dialog modal-dialog-scrollable modal-xl "  role="document">
            <div class=" modal-content">
                <div class="modal-header">
                    <h1 class="modal-title">Add Product</h1>
                </div>
                <div class="modal-body">
                    <form method="post" action="addProduct" >
                    <div class="form-group">
                        <label for="product_name" class="label col-form-label-lg">Product Name</label>
                        <input type="text" id="product_name" required class="form-control" placeholder="Enter product name" name="product_name">
                    </div>
                    <div class="form-group">
                        <label for="type_id" style="margin-right: 30px" class="label label-primary">Type</label>
                        <%
                            List<Type> allType = (List<Type>)request.getAttribute("allType");


                            for(Type type:allType){%>
                                <input type="radio" id="type_id" name="type_id" value="<%= type.getIdType() %>" style="margin-left: 30px"><%= type.getName()%>
                            <%}

                        %>
                    </div>
                    <div class="form-group">
                        <label for="price" class="label col-form-label-lg">Product Price</label>
                        <input type="text" id="price" required class="form-control" placeholder="Enter price" name="price">
                    </div>
                    <div class="form-group">
                        <label for="inStock" class="label col-form-label-lg">Quantity</label>
                        <input type="text" id="inStock" required class="form-control" placeholder="Enter quantity" name="inStock">
                    </div>
                    <input type="submit" class="btn btn-primary">
                    <button type="button" class="btn btn-secondary btn_dismiss" data-dismiss="modal">Close</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <table class="table table-striped table-bordered" style="margin-top: 30px">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">Type</th>
            <th scope="col">Image</th>
            <th scope="col">Price</th>
            <th scope="col">InStock</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
    <%
            List<Product> Products =
        (List<Product>)request.getAttribute("allProducts");
        for(Product product:Products){%>
            <tr>
<%--                <td class="autoIncre"><%=product.getIdProducts()%></td>--%>
                <td class="autoIncre"></td>
                <td> <a href="Product/?id=<%=product.getIdProducts()%>"><%=product.getProductName()%></a>  </td>
                <td><%=product.getIdType()%></td>
                <td><%=product.getImage()%></td>
                <td><%=product.getPrice()%></td>
                <td><%=product.getInStock()%></td>
                <td>
                    <a href="Product/edit?id=<%= product.getIdProducts()%>">Edit</a>
                    <a href="delProduct?id=<%= product.getIdProducts()%>">Delete</a>
                </td>
            </tr>

    <%}%>



        </tbody>
    </table>

</div>
</body>

</html>
