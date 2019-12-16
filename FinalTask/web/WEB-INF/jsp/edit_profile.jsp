<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ys" uri="ysenkoTag" %>
<c:set var="lang" value="${ys:langValue(locale, cookie['lang'].value)}"/>
<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="text"/>
<html lang=${lang}>
<head>
    <title><fmt:message key="edit_profile"/></title>

    <style>
    </style>

</head>
<body>
<c:import url="header.jsp"/>
<main role="main">
    <div class="container" style="background-color:lavender; border-radius: 2rem;
display: flex;
align-items: center;
justify-content: center;
margin-right: auto;
width: 600px ">
        <form action="/edit_profile.html">


            <br>
            <p><fmt:message key="user_login"/>:</p>
            <p class="form-control">${sessionScope.user.login}</p>
            <br>
            <p><fmt:message key="user_email"/>:</p>
            <p class="form-control">${sessionScope.user.email}</p>
            <p><fmt:message key="user_location"/>:</p>
            <select name="country" class="form-control" id="countryId"  onchange="this.form.submit()">
                <option value=""><fmt:message key="select_country"/></option>
                <c:forEach var="country" items="${countries}" varStatus="loop">
                    <option value=${country.id}>${country.name}</option>
                </c:forEach>
            </select>
            <select name="city" class="cities form-control" id="cityId">
                <option value=""><fmt:message key="select_city"/></option>
                <c:forEach var="city" items="${cities}" varStatus="loop">
                    <option value=${city.id}>${city.name}</option>
                </c:forEach>
            </select>
            <br>
            <p><fmt:message key="user_phone"/></p>
            <input type="tel" id="phone" class="form-control" placeholder=
            <fmt:message key="phone"/> name="phone"
                   oninvalid="this.setCustomValidity('Please enter valid phone')"
                   oninput="setCustomValidity('')">
            <button  type="submit" name="save" value="1">
                <fmt:message key="submit"/></button>
        </form>
    </div>
</main>


</body>
</html>
