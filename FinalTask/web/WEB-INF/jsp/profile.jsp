<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Zetto
  Date: 06.12.2019
  Time: 2:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page isELIgnored="false" %>

<%@ taglib prefix="ys" uri="ysenkoTag" %>
<c:set var="lang" value="${ys:langValue(locale, cookie['lang'].value)}"/>
<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="text"/>
<html lang=${lang}>
<head>
    <title>Profile</title>
</head>
<body>
<c:import url="header.jsp"/>
<div class="container" style="background-color: lavender; display: flex;  width: 600px; align-items: center">

    <table width="300" border="0" cellspacing="2" cellpadding="8" class="font12">
        <tbody>
        <tr>
            <td width="100" class="rowB"><b><fmt:message key="login"/></b></td>
            <td width="100">${user.login}</td>

        </tr>
        <tr>
            <td width="100" class="rowB"><b><fmt:message key="email"/></b></td>
            <td width="100">${user.email}</td>

        </tr>

        <tr>
            <td width="100" class="rowB"><b><fmt:message key="country"/></b></td>
            <td width="200" class="rowB">${user.country.name}</td>
        </tr>

        <tr>
            <td width="100" class="rowB"><b><fmt:message key="city"/></b></td>
            <td width="200" class="rowB">${user.city.name}</td>

        </tr>

        <tr>
            <td class="rowB"><b><fmt:message key="phone"/></b>
            </td>
            <td class="rowB">${user.phone}</td>
        </tr>
        </tbody>
    </table>
    <br>
    <c:choose>
        <c:when test="${sessionScope.user.id==user.id}">
    <div class="btn-group-vertical" style="margin-left: auto; margin-bottom: auto; margin-top: auto; margin-right: auto; width: 200px">
        <form action="/choose_game.html" method="post">
            <button class="btn btn-lg btn-primary btn-block" type="submit"  ><fmt:message key="games"/></button>
        </form>
        <br>

        <form action="/to_edit_profile.html" method="post">
            <input type="hidden" name="id" value=${user.id}>
            <button class="btn btn-lg btn-primary btn-block" type="submit"  ><fmt:message key="edit_profile"/></button>
        </form>

        <br>
    </div>
        </c:when>
        <c:otherwise></c:otherwise>
    </c:choose>
</div>
</body>
</html>
