<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Zetto
  Date: 28.11.2019
  Time: 18:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Пример на bootstrap 4: Карусель, навигационная панель и новые компоненты.">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<c:import url="header.jsp"/>
<div class="container" style="background-color:lavender; border-radius: 2rem;
  display: flex;
    width: 600px; height: 350px">


        <div class="btn-group-vertical" style="margin-left: auto; margin-bottom: auto; margin-top: auto; margin-right: auto" >
            <a href="/users.html" class="btn btn-info" role="button">Users</a>
            <br>
            <a role="button" href="/genres.html" class="btn btn-info">Edit genres</a>
            <br>
            <a role="button" href="/categories.html" class="btn btn-info">Edit categories of accessory</a>
            <br>
            <a role="button" href="/games.html" class="btn btn-info">Edit games</a>
            <br>
            <a role="button" href="/currencies.html" class="btn btn-info">Edit currencies</a>
        </div>
</div>
</body>
</html>
