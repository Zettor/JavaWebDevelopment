<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Zetto
  Date: 01.12.2019
  Time: 12:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <title>Title</title>
</head>
<body>
<c:import url="header.jsp"/>
<div class="container" style="background-color:lavender; border-radius: 2rem;
  display: flex;
    ">
    <form action="/add_game.html" method="post"
          style="  margin-left: auto; margin-bottom: auto; margin-top: auto; margin-right: auto; width: 200px">
        <input type="text" id="games" class="form-control" placeholder="game" required="" name="name"
               oninvalid="this.setCustomValidity('Please enter valid name')"
               oninput="setCustomValidity('')" autofocus="">

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
        <textarea class="form-control" rows="5" type="text" name="description" placeholder="description"  required=""></textarea>

        <button class="btn btn-primary " type="submit">Add game</button>
    </form>
    <table class="table table-bordered"
           style="margin-left: auto; margin-bottom: auto; margin-top: auto; margin-right: auto; width: 200px">

        <thead>
        <tr>
            <th>Name</th>
            <th>Genre</th>
            <th>Exclusivity</th>
            <th>Release date</th>
            <th>Description</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="game" items="${list}" varStatus="loop">
            <tr>
                <td>${game.name} </td>
                <td><c:choose>
                    <c:when test="${game.genre==null}">
                        <p>Other</p>
                    </c:when>
                    <c:otherwise>
                        ${game.genre.name}
                    </c:otherwise>
                </c:choose></td>
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
                                style="height: 30px; width: 150px; text-align: center;">Delete
                            category
                        </button>
                    </form>
                </td>

            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<%--<div class="modal" id="myModal">--%>
<%--    <div class="modal-dialog">--%>
<%--        <div class="modal-content">--%>

<%--            <!-- Modal Header -->--%>
<%--            <div class="modal-header">--%>
<%--                <h4 class="modal-title">Description</h4>--%>
<%--                <button type="button" class="close" data-dismiss="modal">&times;</button>--%>
<%--            </div>--%>

<%--            <!-- Modal body -->--%>
<%--            <div class="modal-body">--%>
<%--                ${game.description}--%>
<%--            </div>--%>

<%--            <!-- Modal footer -->--%>
<%--            <div class="modal-footer">--%>
<%--                <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>--%>
<%--            </div>--%>

<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
</body>
</html>
