<%--
  Created by IntelliJ IDEA.
  User: Vladislav
  Date: 13.10.2016
  Time: 23:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Регистрация На Очередь - Очередь На Жилье</title>

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
    <div class="col-lg-8 col-lg-offset-2 block join-form-block">
        <h2 class="form-header">Регистрация семьи на очередь</h2>
        <form class="form-inline queue-form" role="form">
            <!-- ROW -->
            <div class="row">
                <div class="label col-lg-1">
                    <label class="queue-label" for="surname-father-input">Отец</label>
                </div>
                <div class="form-group form-group-list">
                    <input type="text" class="form-control" id="surname-father-input" placeholder="Фамилия">
                </div>
                <div class="form-group form-group-list">
                    <input type="text" class="form-control" id="name-father-input" placeholder="Имя">
                </div>
                <div class="form-group form-group-list">
                    <input type="text" class="form-control" id="patronymic-father-input" placeholder="Отчество">
                </div>
            </div>

            <!-- ROW -->
            <div class="row">
                <div class="label col-lg-1">
                    <label class="queue-label" for="surname-father-input">Мать</label>
                </div>
                <div class="form-group form-group-list">
                    <input type="text" class="form-control" id="surname-mother-input" placeholder="Фамилия">
                </div>
                <div class="form-group form-group-list">
                    <input type="text" class="form-control" id="name-mother-input" placeholder="Имя">
                </div>
                <div class="form-group form-group-list">
                    <input type="text" class="form-control" id="patronymic-mother-input" placeholder="Отчество">
                </div>
            </div>
            <!-- ROW -->
            <div class="row">
                <div class="label col-lg-1">
                    <label class="queue-label" for="surname-father-input">Дети</label>
                </div>
                <div class="form-group form-group-list">
                    <input type="text" class="form-control" id="children-number-input" placeholder="Введите количество детей">
                </div>
            </div>

            <!-- ROW -->
            <div class="row">
                <div class="label col-lg-1">
                    <label class="queue-label" for="surname-father-input">Прочее</label>
                </div>
                <div class="form-group form-group-list">
                    <textarea class="form-control" rows="3" cols="68" placeholder="Жилищные условия"></textarea>
                    <textarea class="form-control" rows="3" cols="68" style="margin: 30px 0;" placeholder="Пожелания на район"></textarea>
                </div>
            </div>
            <div class="row" style="margin-bottom: 30px;">
                <div class="col-lg-3 col-lg-offset-9">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-primary" style="width: 100%;">Встать в очередь</button>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
<br>

<!-- <footer>
  <div class="col-lg-2 col-lg-offset-5" style="text-align: center;">
    <a class="author-link" href="https://github.com/VladislavTitov" target="_blank">Владислав Титов, 11-502</a>
  </div>
</footer> -->

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>