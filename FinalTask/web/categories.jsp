<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Zetto
  Date: 30.11.2019
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:import url="header.jsp"/>
<div class="container" style="background-color:lavender; border-radius: 2rem;
  display: flex;
    width: 800px;">
    <form class="form-inline" action="/add_category.html" method="post"   style="  margin-left: auto; margin-bottom: auto; margin-top: auto; margin-right: auto; "">
        <input type="text" id="categories" class="form-control" placeholder="category" required="" name="category"
               oninvalid="this.setCustomValidity('Please enter valid genre')"
               oninput="setCustomValidity('')" autofocus="">
        <button class="btn btn-primary  " type="submit">Add category</button>
    </form>
    <table class="table table-bordered"
           style="margin-left: auto; margin-bottom: auto; margin-top: auto; margin-right: auto; width: 200px">

        <thead>
        <tr>
            <th>Category of accessory</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="category" items="${list}" varStatus="loop">
            <tr>
                <td>${category.category} </td>
                <td>
                    <form action="/delete_category.html" method="post">
                        <input type="hidden" name="id" value=${category.id}>
                        <button type="submit" class="btn btn-warning "
                                style="height: 30px; width: 150px; text-align: center;">Delete
                            category
                        </button>
                    </form>
                </td>
                </form>

            </tr>

        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
