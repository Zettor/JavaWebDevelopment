<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Zetto
  Date: 03.12.2019
  Time: 18:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Title</title>
</head>
<c:import url="header.jsp"/>
<div class="container">


    <div class="row" style="position: relative; ">
        <c:forEach var="game" items="${list}" varStatus="loop">
            <div class="col-sm-8">
                <div class="row" style="position: relative;
                 font-family: Arial; font-size:90%;  left: 100px ">
                    <div class="col-sm-2" style="padding: unset; ">
                        <img src="images/doom.jpg" alt="Games"
                             preserveAspectRatio="xMidYMid slice" focusable="false" role="img" width="100%"
                             height="100%">
                        </img>
                    </div>
                    <div class="col-sm-3" style="background-color:lavender; padding: unset; text-align: left">
                        <p style="margin-bottom: 3px"> ${game.name}</p>
                        <c:choose>
                            <c:when test="${game.genre==null}">
                                <p style="margin-bottom: 3px">Genre: Other</p>
                            </c:when>
                            <c:otherwise>
                                <p style="margin-bottom: 3px">Genre: ${game.genre.name}</p>
                            </c:otherwise>
                        </c:choose>
                        <p style="margin-bottom: 3px"> ${game.exclusivity}</p>
                        <p style="margin-bottom: 3px">${game.releaseDate}</p>
                    </div>
                    <div class="col-sm-3" style="background-color:lavender; padding: unset; text-align: right">
                        <form action="to_adding_game_offer.html" method="post" style="margin-top: 20px; margin-right: 30px">
                            <input type="hidden" name="id" value=${game.id}>
                            <button type="submit"  class="btn btn-warning" >
                                Create offer
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
