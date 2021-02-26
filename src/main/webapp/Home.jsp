<%--
  Created by IntelliJ IDEA.
  User: gpdn_admin
  Date: 2/24/2021
  Time: 2:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>

</head>
<body>
<%
    if(session.getAttribute("email") == null)
        response.sendRedirect("login.jsp");
%>
    <div align="center">
        <p1>Welcome to my website, <%=session.getAttribute("email")%>   </p1>
        <br>
       <a href="LogoutServlet"><button  type="button" style="margin-top: 20px" >Logout</button></a>
        <a href="Product"><button  type="button" style="margin-top: 20px;margin-left: 20px" >View All Product</button></a>
    </div>


</body>
</html>
