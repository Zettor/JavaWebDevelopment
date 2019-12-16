<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Zetto
  Date: 29.11.2019
  Time: 22:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ys" uri="ysenkoTag" %>
<c:set var="lang" value="${ys:langValue(locale, cookie['lang'].value)}"/>
<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="text"/>
<html lang=${lang}>
<head>
    <title>Currencies</title>
</head>
<body>
<c:import url="header.jsp"/>
<div class="container" style="background-color:lavender; border-radius: 2rem;
  display: flex;
    width: 800px;">

    <form  action="/add_currency.html" method="post"
          style="  margin-left: auto; margin-bottom: auto; margin-top: auto; margin-right: auto; ">
        <c:set var="message" value="${message}"/>
        <c:choose>
            <c:when test="${message!=null}">
                <p>${message}</p>
            </c:when>
            <c:otherwise></c:otherwise>
        </c:choose>

        <input type="text" id="genre" class="form-control" placeholder=<fmt:message key="currency"/> required="" name="currency"
               oninvalid="this.setCustomValidity('Please enter valid currency')"
               oninput="setCustomValidity('')" autofocus="">
    </form>
    <table class="table table-bordered"
           style="margin-left: auto; margin-bottom: auto; margin-top: auto; margin-right: auto; width: 200px">

        <thead>
        <tr>
            <th><fmt:message key="currency"/></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="currency" items="${currencies}" varStatus="loop">
            <tr>
                <td>${currency.name} </td>
                <td>
                    <form action="/delete_currency.html" method="post">
                        <input type="hidden" name="id" value=${currency.id}>
                        <button type="submit" class="btn btn-warning "
                                style="height: 30px; width: 150px; text-align: center;"><fmt:message key="delete_currency"/>
                        </button>
                    </form>
                </td>
                </form>

            </tr>

        </c:forEach>
        </tbody>
    </table>

</div>
</body>
</html>

