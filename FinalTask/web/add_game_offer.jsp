<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Zetto
  Date: 04.12.2019
  Time: 1:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
                    <img src="images/doom.jpg" alt="Games"
                         preserveAspectRatio="xMidYMid slice" focusable="false" role="img" width="100%"
                         height="100%">
                    </img>
                </div>
                <div class="col-sm-5" style="background-color:lavender; padding: unset; text-align: center">
                    <c:set var="game" value="${game}"/>
                    <h1>${game.name}</h1>
                    <c:choose>
                        <c:when test="${game.genre==null}">
                            <p>Genre: Other</p>
                        </c:when>
                        <c:otherwise>
                            <p>Genre: ${game.genre.name}</p>
                        </c:otherwise>
                    </c:choose>
                    <p>Release date: ${game.releaseDate}</p>
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
                <p>Input your cost:</p>
                <input class="form-control" name="cost" placeholder="Cost" required=""> </input>
                <br>
                <p>Choose currency of your cost:</p>
                <c:forEach var="currency" items="${currencies}" varStatus="loop">
                    <div class="custom-control custom-radio">
                        <input type="radio" class="custom-control-input" id=${currency.name} name="currency"
                               value=${currency.id} checked>
                        <label class="custom-control-label" for=${currency.name}>${currency.name}</label>
                    </div>

                    <input type="hidden" name="id" value=${game.id}>
                </c:forEach>
                <textarea class="form-control" rows="5" type="text" name="description" placeholder="description"
                          required=""></textarea>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
            </form>
        </div>
    </div>
</main>
</body>
</html>
