<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ys" uri="ysenkoTag" %>
<c:set var="lang" value="${ys:langValue(locale, cookie['lang'].value)}"/>
<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="text"/>
<html lang=${lang}>
<head>
    <title>Users</title>
</head>
<body>
<c:import url="header.jsp"/>
<div class="container" style="background-color:lavender;  margin-left: auto; margin-bottom: auto; margin-top: auto; margin-right: auto;
  display: flex;">

    <table class="table table-bordered"
           style="margin-left: auto; margin-bottom: auto; margin-top: auto; margin-right: auto; width: 600px">
        <thead>
        <tr>
            <th><fmt:message key="login" /> </th>
            <th><fmt:message key="email" /></th>
            <th><fmt:message key="phone" /></th>
            <th><fmt:message key="country" /></th>
            <th><fmt:message key="city" /></th>
            <th><fmt:message key="role" /></th>
            <th><fmt:message key="status" /></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${list}" varStatus="loop">
            <tr>
                <td><small>${user.login}</small></td>
                <td><small>${user.email}</small></td>
                <td><small>${user.phone}</small></td>
                <td><small>${user.country.name}</small></td>
                <td><small>${user.city.name }</small></td>
                <td>
                    <form action="/set_user_role.html" method="post">
                        <c:choose>
                            <c:when test="${user.role==1}">
                                <input type="hidden" name="id" value=${user.id}>
                                <input type="hidden" name="role" value="0">
                                <button type="submit" class="btn btn-warning "
                                        style="height: 30px; width: 150px; text-align: center;"><fmt:message key="admin"/>
                                </button>
                            </c:when>
                            <c:when test="${user.role==0}">
                                <input type="hidden" name="id" value=${user.id}>
                                <input type="hidden" name="role" value="1">
                                <button type="submit" class="btn btn-warning "
                                        style="height: 30px; width: 150px; text-align: center;"><fmt:message key="user"/>
                                </button>
                            </c:when>
                        </c:choose>
                    </form>
                </td>
                <td>
                    <form action="/set_user_status.html" method="post">
                        <c:choose>
                            <c:when test="${user.status==1}">
                                <input type="hidden" name="id" value=${user.id}>
                                <input type="hidden" name="status" value="0">
                                <button type="submit" class="btn btn-warning "
                                        style="height: 30px; width: 170px; text-align: center;"><fmt:message key="blocked_user"/>
                                </button>
                            </c:when>
                            <c:when test="${user.status==0}">
                                <input type="hidden" name="id" value=${user.id}>
                                <input type="hidden" name="status" value="1">
                                <button type="submit" class="btn btn-warning "
                                        style="height: 30px; width: 170px; text-align: center;"><fmt:message key="not blocked"/>
                                </button>
                            </c:when>
                        </c:choose>
                    </form>
                </td>
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
