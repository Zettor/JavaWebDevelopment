<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Zetto
  Date: 01.12.2019
  Time: 12:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ys" uri="ysenkoTag" %>
<c:set var="lang" value="${ys:langValue(locale, cookie['lang'].value)}"/>
<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="text"/>
<html lang=${lang}>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <title>Games</title>
</head>
<body>
<c:import url="header.jsp"/>
<div class="row"  style="background-color:lavender; border-radius: 2rem;
  display: flex; " >
    <div class="col-sm-3">
    <form action="/add_game.html"  enctype="multipart/form-data" method="post"
          style="  margin-left: auto; margin-bottom: auto; margin-top: auto; margin-right: auto  ">

        <input type="text" id="games" class="form-control" placeholder=<fmt:message key="game"/> required="" name="name"
               oninvalid="this.setCustomValidity('Please enter valid name')"
               oninput="setCustomValidity('')" autofocus="">


            <div class="custom-file">
                <input type="file" name="uploadFile" class="custom-file-input" id="customFile"/>
                <label class="custom-file-label" for="customFile"><fmt:message key="choose_img"/></label>
            </div>

        <script>
            // Add the following code if you want the name of the file appear on select
            $(".custom-file-input").on("change", function() {
                var fileName = $(this).val().split("\\").pop();
                $(this).siblings(".custom-file-label").addClass("selected").html(fileName);
            });
        </script>

        <select class="form-control" name="genre">
            <c:forEach var="genre" items="${genres}" varStatus="loop">
                <option value=${genre.id}>${genre.name}</option>
            </c:forEach>
        </select>

        <select class="form-control" name="exclusivity" required="">
            <option value="1">XBOX ONE X</option>
            <option value="0">PS4</option>
        </select>
        <input class="form-control" type="date" name="date"  required="">
        <textarea class="form-control" rows="5" type="text" name="description" placeholder=<fmt:message key="description"/>  required=""></textarea>

        <button class="btn btn-primary " type="submit">Add game</button>
    </form>
    </div>
    <div class="col-sm-7">
    <table class="table table-bordered"
           style="margin-left: auto; margin-bottom: auto; margin-top: auto; margin-right: auto; width: 200px">

        <thead>
        <tr>
            <th><fmt:message key="game"/></th>
            <th><fmt:message key="genre"/></th>
            <th><fmt:message key="exclusivity"/></th>
            <th><fmt:message key="release_date"/></th>
            <th><fmt:message key="description"/></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="game" items="${list}" varStatus="loop">
            <tr>
                <td>${game.name} </td>
                <td>
                        ${game.genre.name}
                   </td>
                <td><c:choose>
                    <c:when test="${game.exclusivity==0}">PS4
                    </c:when>
                    <c:otherwise>
                        XBOX ONE
                    </c:otherwise>
                </c:choose>
                </td>
                <td>${game.releaseDate} </td>

                <td>
                    <div style="  width: 150px;
    height: 70px;
    overflow: scroll;"><p>${game.description}</p></div>
                </td>
                <td>
                    <form action="/delete_game.html" method="post">
                        <input type="hidden" name="id" value=${game.id}>
                        <button type="submit" class="btn btn-warning "
                                style="height: 30px; width: 150px; text-align: center;"><fmt:message key="delete_game"/>
                        </button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    </div>
</div>

</body>
</html>
