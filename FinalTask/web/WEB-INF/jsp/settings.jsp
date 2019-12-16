<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Zetto
  Date: 28.11.2019
  Time: 18:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ys" uri="ysenkoTag" %>
<c:set var="lang" value="${ys:langValue(locale, cookie['lang'].value)}"/>
<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="text"/>
<html lang=${lang}>
<head>
    <title><fmt:message key="settings"/></title>
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
            <a href="/users.html" class="btn btn-info" role="button"><fmt:message key="edit_users"/></a>
            <br>
            <a role="button" href="/genres.html" class="btn btn-info"><fmt:message key="edit_genres"/> </a>
            <br>
            <a role="button" href="/categories.html" class="btn btn-info"><fmt:message key="edit_categories"/> </a>
            <br>
            <a role="button" href="/games.html" class="btn btn-info"><fmt:message key="edit_games"/></a>
            <br>
            <a role="button" href="/currencies.html" class="btn btn-info"><fmt:message key="edit_currencies"/></a>
            <br>
            <a role="button" href="/countries.html" class="btn btn-info"><fmt:message key="edit_countries"/></a>
        </div>
</div>
</body>
</html>
