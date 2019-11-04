<%@ page import="by.ysenko.task4.bean.Flower" %>
<%@ page import="java.util.Set" %>
<%@ page import="by.ysenko.task4.bean.Blossom" %>
<%@ page import="by.ysenko.task4.bean.visual.BlossomVisualParameters" %>
<%@ page import="by.ysenko.task4.bean.Liana" %>
<%@ page import="by.ysenko.task4.bean.visual.LianaVisualParameters" %>
<%@ page import="by.ysenko.task4.bean.Cactus" %><%--
  Created by IntelliJ IDEA.
  User: Zetto
  Date: 01.11.2019
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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

        <%
            Set<Flower> flowers = (Set<Flower>) request.getAttribute("list");

            if (flowers != null && !flowers.isEmpty()) {
                for (Flower flower : flowers) {
                    if (flower instanceof Blossom) {
                        out.println("<tr>");
                        out.println("<td>" + flower.getId() + "</td>");
                        out.println("<td>" + flower.getName() + "</td>");
                        out.println("<td>" + flower.getSoil() + "</td>");
                        out.println("<td>" + flower.getOrigin() + "</td>");
                        out.println("<td>" + flower.getGrovingTips().getTemperature() + "</td>");
                        out.println("<td>" + flower.getGrovingTips().isLighting() + "</td>");
                        out.println("<td>" + flower.getGrovingTips().getWatering() + "</td>");
                        out.println("<td>" + ((Blossom) flower).getVisualParameters().getStemColor() + "</td>");
                        out.println("<td>" + ((Blossom) flower).getVisualParameters().getSize() + "</td>");
                        out.println("<td>" + ((BlossomVisualParameters) ((Blossom) flower).getVisualParameters()).getLeafColor() + "</td>");
                        out.println("<td>" + ((Blossom) flower).isFruits() + "</td>");
                        out.println("<td>" + flower.getMultiplying() + "</td>");
                        out.println("</tr>");
                    }


                }
            } else out.println("<p>There are no tariffs, List is empty!</p>");
        %>
        </tbody>
    </table>
</div>

<div class="table-responsive">
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

        <%
            flowers = (Set<Flower>) request.getAttribute("list");

            if (flowers != null && !flowers.isEmpty()) {
                for (Flower flower : flowers) {
                    if (flower instanceof Liana) {
                        out.println("<tr>");
                        out.println("<td>" + flower.getId() + "</td>");
                        out.println("<td>" + flower.getName() + "</td>");
                        out.println("<td>" + flower.getSoil() + "</td>");
                        out.println("<td>" + flower.getOrigin() + "</td>");
                        out.println("<td>" + flower.getGrovingTips().getTemperature() + "</td>");
                        out.println("<td>" + flower.getGrovingTips().isLighting() + "</td>");
                        out.println("<td>" + flower.getGrovingTips().getWatering() + "</td>");

                        out.println("<td>" + ((Liana) flower).getVisualParameters().getStemColor() + "</td>");
                        out.println("<td>" + ((Liana) flower).getVisualParameters().getSize() + "</td>");
                        out.println("<td>" + ((LianaVisualParameters) ((Liana) flower).getVisualParameters()).getLeafType() + "</td>");
                        out.println("<td>" + ((Liana) flower).getType() + "</td>");
                        out.println("<td>" + flower.getMultiplying() + "</td>");
                        out.println("</tr>");
                    }

                }
            } else out.println("<p>There are no tariffs, List is empty!</p>");
        %>
        </tbody>
    </table>
</div>

<div class="table-responsive">
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

        <%
            flowers = (Set<Flower>) request.getAttribute("list");

            if (flowers != null && !flowers.isEmpty()) {
                for (Flower flower : flowers) {
                    if (flower instanceof Cactus) {
                        out.println("<tr>");
                        out.println("<td>" + flower.getId() + "</td>");
                        out.println("<td>" + flower.getName() + "</td>");
                        out.println("<td>" + flower.getSoil() + "</td>");
                        out.println("<td>" + flower.getOrigin() + "</td>");
                        out.println("<td>" + flower.getGrovingTips().getTemperature() + "</td>");
                        out.println("<td>" + flower.getGrovingTips().isLighting() + "</td>");
                        out.println("<td>" + flower.getGrovingTips().getWatering() + "</td>");
                        out.println("<td>" + ((Cactus) flower).getVisualParameters().getStemColor() + "</td>");
                        out.println("<td>" + ((Cactus) flower).getVisualParameters().getSize() + "</td>");
                        out.println("<td>" + ((Cactus) flower).getSubfamily() + "</td>");
                        out.println("<td>" + flower.getMultiplying() + "</td>");
                        out.println("</tr>");
                    }
                }
            } else out.println("<p>There are no tariffs, List is empty!</p>");
        %>
        </tbody>
    </table>
</div>
</body>
</html>