<%--
  Created by IntelliJ IDEA.
  User: Vladislav
  Date: 25.10.2016
  Time: 23:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Очередь На Жилье</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- main.css -->
    <link rel="stylesheet" href="css/main.css">
    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Russo+One" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

<nav role="navigation" class="navbar navbar-default">

    <div class="navbar-header">
        <button type="button" data-target="#navbarCollapse" data-toggle="collapse" class="navbar-toggle">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a href="#" class="navbar-brand"><%=request.getSession().getAttribute("current_user")%></a>
    </div>

    <div class="collapse navbar-collapse">
        <ul class="nav navbar-nav navbar-right">
            <li><a href="#">Выйти</a></li>
        </ul>
    </div>

</nav>

<div class="container-fluid">
    <div class="col-lg-6 col-lg-offset-3 banner block">
        <h1>Очередь на жилье</h1>
    </div>
</div>

<div class="container-fluid">
    <div class="col-lg-6 col-lg-offset-3 block">
        <h3>Наши поздравяления! Вы встали в очередь на жилье!</h3>
        <hr>
        <h4>Ваше место в очереди: <span class="success-info">2932</span></h4>
        <h4>Ваши льготы: <span class="success-info">первоочередное</span></h4>
        <h4>Ваш id: <span class="success-info"><тут айди></span></h4>
    </div>
</div>

<footer>
    <div class="col-lg-2 col-lg-offset-5" style="text-align: center;">
        <a class="author-link" href="https://github.com/VladislavTitov" target="_blank">Владислав Титов, 11-502</a>
    </div>
</footer>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>