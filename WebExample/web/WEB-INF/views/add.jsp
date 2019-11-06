<%--
  Created by IntelliJ IDEA.
  User: Zetto
  Date: 01.11.2019
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new user</title>
</head>

<body >
        <form  action="/add">
            <label>Name:
                <input type="text" name="name"><br />
            </label>
            <label>Password:
                <input type="password" name="pass" ><br />
            </label>
            <button type="submit">Submit</button>
        </form>
    <button class="w3-btn w3-round-large" onclick="location.href='http://localhost:8080/WebExample_war_exploded'">Back to main</button>
</body>
</html>