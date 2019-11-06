<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <head>
        <title>Upload result</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    </head>
</head>
<body>
<div class="table-responsive">
    <h1>Blossom's</h1>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Soil</th>
            <th>Origin</th>
            <th>Temperature</th>
            <th>Lighting</th>
            <th>Watering</th>
            <th>Stem color</th>
            <th>Size</th>
            <th>Leaf color</th>
            <th>Fruits</th>
            <th>Multiplying</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach var="flower" items="${list}">
            <c:if test="${flower['class'].name eq 'by.ysenko.task4.bean.Blossom'}">
                <tr>
                    <td>${flower.id}</td>
                    <td>${flower.name}</td>
                    <td>${flower.soil}</td>
                    <td>${flower.origin}</td>
                    <td>${flower.grovingTips.temperature}</td>
                    <td>${flower.grovingTips.lighting}</td>
                    <td>${flower.grovingTips.watering}</td>
                    <td>${flower.visualParameters.stemColor}</td>
                    <td>${flower.visualParameters.size}</td>
                    <td>${flower.visualParameters.leafColor}</td>
                    <td>${flower.fruits}</td>
                    <td>${flower.multiplying}</td>
                </tr>
            </c:if>
        </c:forEach>
        </tbody>
    </table>
</div>

<div class="table-responsive">
    <h1>Lian's</h1>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Soil</th>
            <th>Origin</th>
            <th>Temperature</th>
            <th>Lighting</th>
            <th>Watering</th>
            <th>Stem color</th>
            <th>Size</th>
            <th>Leaf type</th>
            <th>Liana type</th>
            <th>Multiplying</th>
        </tr>
        </thead>
        <tbody>
        <td>${flower.id}</td>
        <td>${flower.name}</td>
        <td>${flower.soil}</td>
        <td>${flower.origin}</td>
        <td>${flower.grovingTips.temperature}</td>
        <td>${flower.grovingTips.lighting}</td>
        <c:forEach var="flower" items="${list}">
            <c:if test="${flower['class'].name eq 'by.ysenko.task4.bean.Liana'}">
                <tr>
                    <td>${flower.id}</td>
                    <td>${flower.name}</td>
                    <td>${flower.soil}</td>
                    <td>${flower.origin}</td>
                    <td>${flower.grovingTips.temperature}</td>
                    <td>${flower.grovingTips.lighting}</td>
                    <td>${flower.grovingTips.watering}</td>
                    <td>${flower.visualParameters.stemColor}</td>
                    <td>${flower.visualParameters.size}</td>
                    <td>${flower.visualParameters.leafType}</td>
                    <td>${flower.type}</td>
                    <td>${flower.multiplying}</td>
                </tr>
            </c:if>
        </c:forEach>

        </tbody>
    </table>
</div>

<div class="table-responsive">
    <h1>Сacti</h1>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Soil</th>
            <th>Origin</th>
            <th>Temperature</th>
            <th>Lighting</th>
            <th>Watering</th>
            <th>Stem color</th>
            <th>Size</th>
            <th>Subfamily</th>
            <th>Multiplying</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="flower" items="${list}">
            <c:if test="${flower['class'].name eq 'by.ysenko.task4.bean.Cactus'}">
                <tr>
                    <td>${flower.id}</td>
                    <td>${flower.name}</td>
                    <td>${flower.soil}</td>
                    <td>${flower.origin}</td>
                    <td>${flower.grovingTips.temperature}</td>
                    <td>${flower.grovingTips.lighting}</td>
                    <td>${flower.grovingTips.watering}</td>
                    <td>${flower.visualParameters.stemColor}</td>
                    <td>${flower.visualParameters.size}</td>
                    <td>${flower.subfamily}</td>
                    <td>${flower.multiplying}</td>
                </tr>
            </c:if>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>

