<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Zetto
  Date: 05.12.2019
  Time: 1:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ys" uri="ysenkoTag" %>
<c:set var="lang" value="${ys:langValue(locale, cookie['lang'].value)}"/>
<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="text"/>
<html lang=${lang}>
<head>
    <title><fmt:message key="game_offers"/> </title>
</head>
<body>
<c:import url="header.jsp"/>
<div class="container">

    <div class="row" style="position: relative; ">
        <c:forEach var="offer" items="${offers}" varStatus="loop">
            <div class="col-sm-8">
                <div class="row" style="position: relative;
                 font-family: Arial; font-size:90%;  left: 100px ">
                    <div class="col-sm-2" style="padding: unset; ">
                        <img src="../../images/doom.jpg" alt="Games"
                             preserveAspectRatio="xMidYMid slice" focusable="false" role="img" width="100%"
                             height="100%">
                        </img>
                    </div>
                    <div class="col-sm-4" style="background-color:lavender; padding: unset; text-align: left">
                        <p style="margin-bottom: 3px"> ${offer.game.name}</p>

                        <p style="margin-bottom: 3px"><fmt:message key="genre"/>: ${offer.game.genre.name}</p>


                        <c:choose>
                            <c:when test="${offer.game.exclusivity==0}">
                                <p style="margin-bottom: 3px"><fmt:message key="exclusivity"/>: PS4 </p>
                            </c:when>
                            <c:when test="${offer.game.exclusivity==1}">
                                <p style="margin-bottom: 3px"><fmt:message key="exclusivity"/> XBOX ONE X </p>
                            </c:when>
                            <c:otherwise>
                            </c:otherwise>
                        </c:choose>
                        <p style="margin-bottom: 3px"> <fmt:message key="create_at"/>:<fmt:formatDate
                                pattern="yyyy-MM-dd" value="${offer.createDate}"/></p>
                        <p><fmt:message key="cost"/>: ${offer.cost} ${offer.currency.name}</p>
                    </div>
                    <div class="col-sm-4" style="background-color:lavender; padding: unset; text-align: right">
                        <form action="/game_offer.html" style="margin-top: 20px; margin-right: 30px">
                            <input type="hidden" name="id" value=${offer.id}>
                            <button type="submit" class="btn btn-warning">
                                <fmt:message key="go_to_offer"/>
                            </button>
                        </form>
                    </div>
                </div>
                <br>
            </div>

        </c:forEach>
    </div>
</div>
</body>
</html>
