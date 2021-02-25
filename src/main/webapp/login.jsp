<%--
  Created by IntelliJ IDEA.
  User: gpdn_admin
  Date: 2/24/2021
  Time: 1:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
</head>
<body>
 <%
     if(session.getAttribute("email") != null)
         response.sendRedirect("Home.jsp");
 %>
<div align="center">
    <h1>Login</h1>
    <form action="Login" method="post">

        <label for="email"></label><input type="email" required id="email" name="email" placeholder="Enter email"/>

        <br>

        <label for="password"></label><input type="password" id="password" required name="password" style="margin-top: 10px" placeholder="Enter password"/>
        <br>
        <button type="submit" style="margin-top: 20px">Đăng nhập</button>

    </form>
</div>


</body>
</html>
