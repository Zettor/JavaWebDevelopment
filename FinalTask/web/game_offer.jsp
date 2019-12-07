<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Zetto
  Date: 05.12.2019
  Time: 12:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
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
    <title>Title</title>
</head>
<body>
<c:import url="header.jsp"/>
<div class="container" style="background-color: lavender;  width: 600px">
    <table width="720" border="0" cellspacing="0" cellpadding="0">
        <tbody>
        <tr>
            <td width="10" valign="top"><img alt="Grand Theft Auto V" width="200" height="200" class="ramka"
                                             src="images/doom.jpg"></td>
            <td>
                <p class="font12">
                <h1>${offer.game.name}</h1>
                <b>Genre:</b> <a>${offer.game.genre.name}</a><br>
                <c:choose>
                    <c:when test="${offer.game.exclusivity==0}">
                        <b>Exclusivity:</b> <a>PS4</a>
                    </c:when>
                    <c:when test="${offer.game.exclusivity==1}">
                        <b>Exclusivity:</b> <a>XBOX ONE X</a>
                    </c:when>
                    <c:otherwise>
                    </c:otherwise>
                </c:choose>
                <br>
                <b>Release date:</b> ${offer.game.releaseDate}<br>
                <h1>Cost ${offer.cost} ${offer.currency.name}</h1>
                <br>
                </p><br>
            </td>
        </tr>
        </tbody>

    </table>
    <b>Description: </b></b><a>${offer.game.description}</a>
    <br>
    <table width="300" border="0" cellspacing="2" cellpadding="8" class="font12">
        <tbody>
        <tr>
            <td width="100" class="rowB"><b>User</b></td>
            <%--            <td width="100">${offer.user.email}</td>--%>
            <td width="100">
                <form action="/profile.html" method="post">
                    <input type="hidden" name="id" value=${offer.user.id}>
                    <button type="submit">${offer.user.login}</button>
                </form>
                </td>
        </tr>
        <tr>
            <td width="100" class="rowB"><b>Email</b></td>
            <td width="100">${offer.user.email}</td>

        </tr>

        <tr>
            <td width="100" class="rowB"><b>Country</b></td>
            <td width="200" class="rowB">${offer.user.country}</td>
        </tr>

        <tr>
            <td width="100" class="rowB"><b>City</b></td>
            <td width="200" class="rowB">${offer.user.city}</td>

        </tr>

        <tr>
            <td class="rowB"><b> Phone</b>
            </td>
            <td class="rowB">${offer.user.phone}</td>

        </tr>
        </tbody>
    </table>
    <br>
    <b class="font12">Description:</b>
    <p class="font12">${offer.description}</p>
</div>
</body>
</html>
