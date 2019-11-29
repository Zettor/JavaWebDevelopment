<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>

    <style>
    </style>

</head>
<body>
<c:import url="header.jsp"/>
<main role="main">
    <div class="container" style="background-color:lavender; border-radius: 2rem;
  display: flex;
  align-items: center;
  justify-content: center;
    margin-right: auto;
    width: 600px ">
        <form action="/edit_profile.html" method="post" >
            <p>Your login</p>
            <p class="form-control">${sessionScope.user.login}</p>
            <br>
            <p>Your email</p>
            <p class="form-control">${sessionScope.user.email}</p>
            <p>Edit your country, state and city for improved search of your offers</p>
            <select  name="country" class="countries form-control" id="countryId">
                <option value="">Select Country</option>
            </select>
            <select  name="state" class="states form-control" id="stateId">
                <option value="">Select State</option>
            </select>
            <select  name="city" class="cities form-control" id="cityId">
                <option value="">Select City</option>

            </select>
            <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
            <script src="//geodata.solutions/includes/countrystatecity.js"></script>
            <br>
            <p>Edit your telephone</p>
            <input type="tel" id="phone" class="form-control" placeholder="phone" name="phone"
                   oninvalid="this.setCustomValidity('Please enter valid phone')"
                   oninput="setCustomValidity('')">
            <br>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
        </form>
    </div>
</main>


</body>
</html>
