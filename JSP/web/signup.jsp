<%--
  Created by IntelliJ IDEA.
  User: Vladislav
  Date: 29.09.2016
  Time: 18:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign up</title>
</head>
<body>
<form id="login-form">
    <label for="name-field">Enter your name:</label>
    <input type="text" id="name-field" name = "name"><br>
    <label for="age-field">Enter your age:</label>
    <input type="text" id = "age-field" name = "age"><br>
    <label for="city-field">Enter your own city:</label>
    <input type="text" id = "city-field" name = "city"><br>
</form>
<input type="button" value = "Log in" id="ok" onclick="loginRequest()">
<div id="out"></div>

<script>
    function createRequest() {
        var Request = new XMLHttpRequest();
        if (!Request) {
            alert("Невозможно создать Request");
        }
        return Request;
    }

    function loginRequest() {
        var Request = createRequest();
        Request.onreadystatechange = function() {
            if (Request.readyState == 4) {
                if (Request.status == 200) {
                    responseHandler(Request);
                } else {
                    alert("Error with data transmission!");
                }
            } else {
                document.getElementById("out").innerText = "Please, wait! Loading..."
            }
        };
        var body = 'name=' + encodeURIComponent(document.getElementById("name-field").value) +
                '&age=' + encodeURIComponent(document.getElementById("age-field").value) +
                '&city=' + encodeURIComponent(document.getElementById("city-field").value);
//        var formData = new FormData(document.getElementById("login-form"));
        Request.open("POST", "/signup", true);
        Request.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        Request.send(body);
    }

    function responseHandler(Request) {
        document.getElementById("out").innerText = Request.responseText;
    }

</script>

</body>
</html>
