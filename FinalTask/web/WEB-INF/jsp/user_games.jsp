<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Zetto
  Date: 03.12.2019
  Time: 18:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ys" uri="ysenkoTag" %>
<c:set var="lang" value="${ys:langValue(locale, cookie['lang'].value)}"/>
<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="text"/>
<html lang="${lang}">
<head>

    <title><fmt:message key="choose_game"/></title>
</head>
<body>
<c:import url="header.jsp"/>
<div class="container">

    <div class="row" style="position: relative; ">
        <c:forEach var="game" items="${list}" varStatus="loop">
            <div class="col-sm-8">
                <div class="row" style="position: relative;
                 font-family: Arial; font-size:90%;  left: 100px ">
                    <div class="col-sm-2" style="padding: unset; ">
                        <img src=${game.imgPath} alt="Games"
                             preserveAspectRatio="xMidYMid slice" focusable="false" role="img" width="100%"
                             height="100%">
                        </img>
                    </div>
                    <div class="col-sm-4" style="background-color:lavender; padding: unset; text-align: left;">
                        <p style="margin-bottom: 3px"> ${game.name}</p>
                        <p style="margin-bottom: 3px"><fmt:message key="genre"/>: ${game.genre.name}</p>
                        <c:choose>
                            <c:when test="${game.exclusivity==0}">
                                <p style="margin-bottom: 3px"><fmt:message key="exclusivity"/>: PS4 </p>
                            </c:when>
                            <c:when test="${game.exclusivity==1}">
                                <p style="margin-bottom: 3px"><fmt:message key="exclusivity"/>: XBOX ONE X </p>
                            </c:when>
                            <c:otherwise>
                            </c:otherwise>
                        </c:choose>

                        <p style="margin-bottom: 3px"><fmt:message key="release_date"/>: <fmt:formatDate
                                pattern="yyyy-MM-dd" value="${game.releaseDate}"/></p>
                    </div>
                    <div class="col-sm-3" style="background-color:lavender; padding: unset; text-align: right">
                        <form action="to_adding_game_offer.html"
                              style="margin-top: 20px; margin-right: 30px">
                            <input type="hidden" name="id" value=${game.id}>
                            <button type="submit" class="btn btn-warning">
                                <fmt:message key="create_offer"/>
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