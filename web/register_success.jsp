<%--
  Created by IntelliJ IDEA.
  User: hailongluu
  Date: 4/18/2019
  Time: 8:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register Success</title>
</head>
<body>
<% String username = (String) session.getAttribute("username");
    %>
<a><b>Welcome User!!!!</b></a>
<a>username: <%=username%></a>
</body>
</html>
