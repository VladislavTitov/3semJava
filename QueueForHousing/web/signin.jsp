<%--
  Created by IntelliJ IDEA.
  User: Vladislav
  Date: 25.10.2016
  Time: 23:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Вход - Очередь На Жилье</title>

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
<div class="container-fluid">
    <div class="col-lg-6 col-lg-offset-3 banner block">
        <h1>Очередь на жилье</h1>
    </div>
</div>

<div class="container-fluid">
    <div class="col-lg-6 col-lg-offset-3 join-form-block block">
        <h2 class="form-header">Вход</h2>
        <form class="form-horizontal join-form col-lg-8 col-lg-offset-2" role="form" action="/signin" method="post" style='display: block;'>
            <div class="form-group">
                <label for="email-signin-field" class="col-sm-2 control-label">Email</label>
                <div class="col-sm-10">
                    <input type="email" class="form-control" id="email-signin-field" placeholder="Email" name="email">
                </div>
            </div>
            <div class="form-group">
                <label for="password-signin-field" class="col-sm-2 control-label">Пароль</label>
                <div class="col-sm-10">
                    <input type="password" class="form-control" id="password-signin-field" placeholder="Введите пароль" name="pass">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <div class="checkbox">
                        <label>
                            <input type="checkbox" name="remember" value="true">Запомнить меня
                        </label>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-primary">Войти</button>
                </div>
            </div>
            <a href="/signup" class="btn btn-link">Еще нет аккаунта?</a>
        </form>
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