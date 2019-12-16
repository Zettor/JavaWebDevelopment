<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Zetto
  Date: 04.12.2019
  Time: 1:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ys" uri="ysenkoTag" %>
<c:set var="lang" value="${ys:langValue(locale, cookie['lang'].value)}"/><fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="text"/>
<html lang="${lang}">
<head>
    <title><fmt:message key="adding_game_offer"/></title>
</head>
<body>
<c:import url="header.jsp"/>
<main role="main">
    <div class="row">
        <div class="col-sm-8" style="position: absolute; background-color:lavender;
                 font-family: Arial; font-size:150%; display: flex;
  align-items: center;
  justify-content: center;  margin-left: 215px;  ">
            <div class="row" style="position: absolute; top: 0; bottom: 0 ; left: 0; ">

                <div class="col-sm-6" style="padding: unset">
                    <img src="../../images/doom.jpg" alt="Games"
                         preserveAspectRatio="xMidYMid slice" focusable="false" role="img" width="100%"
                         height="100%">
                    </img>
                </div>
                <div class="col-sm-5" style="background-color:lavender; padding: unset; text-align: center">
                    <c:set var="game" value="${game}"/>
                    <h1>${game.name}</h1>
                    <p><fmt:message key="genre"/>: ${game.genre.name}</p>
                    <p><fmt:message key="release_date"/>: <fmt:formatDate
                            pattern="yyyy-MM-dd" value="${game.releaseDate}"/></p>
                    <%--                    </div>--%>
                </div>
            </div>
        </div>

        <div class="col-sm-8" style="background-color:lavender; border-radius: 2rem; border-radius: 2rem;
  display: flex;
  align-items: center;
  justify-content: center;
    margin-left: auto;
    margin-right: auto;
    margin-top: 200px;
    margin-bottom: auto;
    width: 600px ">
            <form action="/add_game_offer.html" method="post">
                <p><fmt:message key="input_cost"/></p>
                <input class="form-control" name="cost" placeholder=
                <fmt:message key="cost"/> required=""> </input>
                <br>
                <p><fmt:message key="choose_currency"/></p>
                <select class="form-control" name="currency">
                    <c:forEach var="currency" items="${currencies}" varStatus="loop">
                        <option value=${currency.id}>${currency.name}</option>
                    </c:forEach>
                </select>
                <input type="hidden" name="game_id" value=${game.id}>
                <input type="hidden" name="genre_id" value=${game.genre.id}>
                <textarea class="form-control" rows="5" type="text" name="description" placeholder=
                <fmt:message key="description"/>
                        required=""></textarea>
                <button class="btn btn-lg btn-primary btn-block" type="submit"><fmt:message key="submit"/></button>
            </form>
        </div>
    </div>
</main>
</body>
</html>
