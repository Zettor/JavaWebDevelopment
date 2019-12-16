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
<html lang="${lang}">
<head>
    <title>Genres</title>
</head>
<body>
<c:import url="header.jsp"/>
<div class="container" style="background-color:lavender; border-radius: 2rem;
  display: flex;
    width: 800px;">

    <form class="form-inline" action="/add_city.html"
          style="  margin-left: auto; margin-bottom: auto; margin-top: auto; margin-right: auto; ">
        <input type="hidden" name="id" value=${countryId}>
        <input type="text" id="genre" class="form-control" placeholder=<fmt:message key="city"/> required="" name="city"
               oninvalid="this.setCustomValidity('Please enter valid city')"
               oninput="setCustomValidity('')" autofocus="">
    </form>
    <table class="table table-bordered"
           style="margin-left: auto; margin-bottom: auto; margin-top: auto; margin-right: auto; width: 200px">

        <thead>
        <tr>
            <th><fmt:message key="city"/></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="city" items="${list}" varStatus="loop">
            <tr>
                <td>${city.name} </td>
                <td>
                    <form action="/delete_city.html" method="post">
                        <input type="hidden" name="id" value=${city.id}>
                        <input type="hidden" name="countryId" value=${countryId}>
                        <button type="submit" class="btn btn-warning "
                                style="height: 30px; width: 150px; text-align: center;"><fmt:message key="delete_city"/>
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
