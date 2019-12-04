<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:import url="header.jsp"/>
<div class="container" style="background-color:lavender;  margin-left: auto; margin-bottom: auto; margin-top: auto; margin-right: auto;
  display: flex;">

<table class="table table-bordered" style="margin-left: auto; margin-bottom: auto; margin-top: auto; margin-right: auto; width: 600px">
    <thead>
    <tr>
        <th>Login</th>
        <th>Email</th>
        <th>Country</th>
        <th>State</th>
        <th>City</th>
        <th>Phone</th>
    </tr>
    </thead>
    <tbody>
<c:forEach var="user" items="${list}" varStatus="loop">
    <tr>
        <td><small>${user.login}</small></td>
        <td><small>${user.email}</small></td>
        <td><small>${user.country}</small></td>
        <td><small>${user.state}</small></td>
        <td><small>${user.city}</small></td>
        <td><small>${user.phone}</small></td>
    </tr>
</c:forEach>
    </tbody>
</table>
</div>
<%--<ul class="list-group">--%>
<%--<c:forEach var="user" items="${list}" varStatus="loop">--%>
<%--    <li class="list-group-item">--%>
<%--  ${user.login}--%>
<%--    </li>--%>
<%--</c:forEach>--%>
<%--</ul>--%>
</body>
</html>
