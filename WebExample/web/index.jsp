<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>File Upload Demo</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
</head>

<body>
<div>Apache FileUpload</div>
<form action="result" method="post">
    <input type="file" id="xmlFile" name="xmlFile" required>
    <label for="xmlFile">Choose XML file</label>

    </div>

    <br/><br/><br/><br/>

    <div class="custom-file">
        <input type="file" id="xsdFile" name="xsdFile" required>
        <label for="xsdFile">Choose XSD file</label>
    </div>
    </div>

    <br/> <br/>
    <br/> <br/>


    <div class="form-group">
        <label for="exampleFormControlSelect1">Select Parser</label>
        <select class="form-control" id="exampleFormControlSelect1" name="parser">
            <option>DOM</option>
            <option>SAX</option>
            <option>StAX</option>
        </select>
    </div>


    <br/> <br/>
    <br/>
    <br/>

    <div class="row">
        <button type="submit" value="result">Default</button>

    </div>


</form>
</body>
</html>