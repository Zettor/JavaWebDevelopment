<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ys" uri="ysenkoTag" %>
<c:set var="lang" value="${ys:langValue(locale, cookie['lang'].value)}"/>
<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="text"/>
<html lang=${lang}>
<head>

    <style>
        .cl {
            font-size: 0;
            line-height: 0;
            clear: both;
            display: block;
            height: 0;
        }

        .font12 {
            font-size: 20px;
        }

        .ramka {
            padding: 5px;
            background: #f5f5f5;
            border: 1px solid #b0b0b0;
        }</style>
    <title>Game offer</title>
</head>
<body>
<c:import url="header.jsp"/>
<div class="container" style="background-color: lavender; width: 600px">
<table width="720" border="0" cellspacing="0" cellpadding="0">
<tbody>
<tr>
<td width="10" valign="top"><img alt="Game" width="200" height="200" class="ramka"
                                 src=${offer.game.imgPath}></td>
<td>
<p class="font12">
<h1>${offer.game.name}</h1>
<b><fmt:message key="genre"/>:</b> <a>${offer.game.genre.name}</a><br>
    <c:choose>
        <c:when test="${offer.game.exclusivity==0}">
            <b><fmt:message key="exclusivity"/>:</b> <a>PS4</a>
        </c:when>
        <c:when test="${offer.game.exclusivity==1}">
            <b><fmt:message key="exclusivity"/>:</b> <a>XBOX ONE X</a>
        </c:when>
        <c:otherwise>
        </c:otherwise>
    </c:choose>
    <br>
    <b><fmt:message key="release_date"/>:</b> <fmt:formatDate
            pattern="yyyy-MM-dd" value="${offer.game.releaseDate}"/><br>


    <h1><fmt:message key="cost"/>: ${offer.cost} ${offer.currency.name}</h1>
    <br>
    </p><br>
    </td>
    </tr>
    </tbody>

    </table>
    <b><fmt:message key="description"/>: </b></b><a>${offer.game.description}</a>
    <br>
    <table width="300" border="0" cellspacing="2" cellpadding="8" class="font12">
    <tbody>
    <tr>
    <td width="100" class="rowB"><b><fmt:message key="user"/></b></td>
    <%--            <td width="100">${offer.user.email}</td>--%>
    <td width="100">
    <form action="/profile.html">
    <input type="hidden" name="id" value=${offer.user.id}>
    <button type="submit">${offer.user.login}</button>
    </form>
    </td>
    </tr>
    <tr>
    <td width="100" class="rowB"><b><fmt:message key="email"/></b></td>
    <td width="100">${offer.user.email}</td>

    </tr>

    <tr>
    <td width="100" class="rowB"><b><fmt:message key="country"/></b></td>
    <td width="200" class="rowB">${offer.user.country}</td>
    </tr>

    <tr>
    <td width="100" class="rowB"><b><fmt:message key="city"/></b></td>
    <td width="200" class="rowB">${offer.user.city}</td>

    </tr>

    <tr>
    <td class="rowB"><b><fmt:message key="phone"/></b>
    </td>
    <td class="rowB">${offer.user.phone}</td>

    </tr>
    </tbody>
    </table>
    <br>
    <b class="font12"><fmt:message key="description"/>:</b>
    <p class="font12">${offer.description}</p>
    </div>
    </body>
    </html>
