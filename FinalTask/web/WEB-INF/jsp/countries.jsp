<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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

    <form class="form-inline" action="/add_country.html" method="post"
          style="  margin-left: auto; margin-bottom: auto; margin-top: auto; margin-right: auto; ">
        <input type="text" id="genre" class="form-control" placeholder=
        <fmt:message key="country"/> required="" name="country"
               oninvalid="this.setCustomValidity('Please enter valid country')"
               oninput="setCustomValidity('')" autofocus="">

    </form>
    <table class="table table-bordered"
           style="margin-left: auto; margin-bottom: auto; margin-top: auto; margin-right: auto; width: 200px">

        <thead>
        <tr>
            <th><fmt:message key="country"/></th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="country" items="${list}" varStatus="loop">
            <tr>
                <td>${country.name} </td>
                <td>
                    <form action="/delete_country.html" method="post">
                        <input type="hidden" name="id" value=${country.id}>
                        <button type="submit" class="btn btn-warning "
                                style="height: 30px; width: 150px; text-align: center;"><fmt:message key="delete_country"/>
                        </button>
                    </form>
                </td>
                <td>
                    <form action="/cities.html">
                        <input type="hidden" name="id" value=${country.id}>
                        <button type="submit" class="btn btn-warning "
                                style="height: 30px; width: 170px; text-align: center;"><fmt:message key="edit_city"/>
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


