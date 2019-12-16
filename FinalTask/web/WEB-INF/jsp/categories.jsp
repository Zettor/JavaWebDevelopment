<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Zetto
  Date: 30.11.2019
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ys" uri="ysenkoTag" %>
<c:set var="lang" value="${ys:langValue(locale, cookie['lang'].value)}"/>
<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="text"/>
<html lang="${lang}">
<head>
    <title>Categories</title>
</head>
<body>
<c:import url="header.jsp"/>
<div class="container" style="background-color:lavender; border-radius: 2rem;
  display: flex;
    width: 800px;">
    <form class="form-inline" action="/add_category.html" method="post"   style="  margin-left: auto; margin-bottom: auto; margin-top: auto; margin-right: auto; ">
        <input type="text" id="categories" class="form-control" placeholder=<fmt:message key="category"/>  required="" name="category"
               oninvalid="this.setCustomValidity('Please enter valid category')"
               oninput="setCustomValidity('')" autofocus="">

    </form>
    <table class="table table-bordered"
           style="margin-left: auto; margin-bottom: auto; margin-top: auto; margin-right: auto; width: 200px">

        <thead>
        <tr>
            <th><fmt:message key="category"/></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="category" items="${list}" varStatus="loop">
            <tr>
                <td>${category.category} </td>
                <td>
                    <form action="/delete_category.html" method="post">
                        <input type="hidden" name="id" value=${category.id}>
                        <button type="submit" class="btn btn-warning "
                                style="height: 30px; width: 170px; text-align: center;"><fmt:message key="delete_category"/>
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
