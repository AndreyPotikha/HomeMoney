<%--
  Created by IntelliJ IDEA.
  User: andrey
  Date: 15.02.18
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Money</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"  session="true" %>

<%
    long status = (long) session.getAttribute("userId");
%>

<%@include file="header/header.jsp"%>

</body>
</html>
