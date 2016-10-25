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
        <form class="form-inline queue-form" role="form" action="/success">
            <!-- ROW -->
            <div class="row">
                <div class="label col-lg-1">
                    <label class="queue-label" for="surname-father-input">Отец</label>
                </div>
                <div class="form-group form-group-list">
                    <input type="text" class="form-control" id="surname-father-input" name="father_surname" placeholder="Фамилия">
                </div>
                <div class="form-group form-group-list">
                    <input type="text" class="form-control" id="name-father-input" name="father_name" placeholder="Имя">
                </div>
                <div class="form-group form-group-list">
                    <input type="text" class="form-control" id="patronymic-father-input" name="father_patronym" placeholder="Отчество">
                </div>
            </div>

            <!-- ROW -->
            <div class="row">
                <div class="label col-lg-1">
                    <label class="queue-label" for="surname-mother-input">Мать</label>
                </div>
                <div class="form-group form-group-list">
                    <input type="text" class="form-control" id="surname-mother-input" name="mother_surname" placeholder="Фамилия">
                </div>
                <div class="form-group form-group-list">
                    <input type="text" class="form-control" id="name-mother-input" name="mother-name" placeholder="Имя">
                </div>
                <div class="form-group form-group-list">
                    <input type="text" class="form-control" id="patronymic-mother-input" name="mother-patronym" placeholder="Отчество">
                </div>
            </div>
            <!-- ROW -->

<div class="row" id="child">
<div class="label col-lg-1">
<label class="queue-label" for="surname-child-input[0]">Дети</label>
</div>
<span id="child[0]">
<div class="form-group form-group-list">
<input type="text" class="form-control" id="surname-child-input[0]" name="child-surname[0]" placeholder="Фамилия">
</div>
<div class="form-group form-group-list">
<input type="text" class="form-control" id="name-child-input[0]" name="child-name[0]" placeholder="Имя">
</div>
<div class="form-group form-group-list">
<input type="text" class="form-control" id="patronymic-child-input[0]" name="child-patronym[0]" placeholder="Отчество">
</div>
<input class="btn btn-primary" type="button" name="subtraction" value="-" onclick="removeCh(0)">
</span><br>
<div class="row" style="margin-bottom: 30px;">
<div class="col-lg-1 col-lg-offset-10">
<div class="col-sm-offset-2 col-sm-10">
<input type="button" class="btn btn-primary" onclick="addChild()" value="+">
</div>
</div>
</div>
</div>



            <!-- ROW -->
            <div class="row">
                <div class="label col-lg-1">
                    <label class="queue-label" for="select-district">Прочее</label>
                </div>
                <div class="form-group form-group-list">
                    <!--  <textarea class="form-control" rows="3" cols="68" placeholder="Жилищные условия"></textarea> -->

                    <div class="form-group">
                        <label for="select-district" style="margin-right: 15px;">Район</label>

                        <select class="form-control" id="select-district" name="district">
                            <option value="center">Центр</option>
                            <option value="new">Новостройки</option>
                            <option value="sleep">Спальный район</option>
                        </select>
                    </div>

                    <div class="form-group" style="margin-top: 10px;">
                        <label for="select-count-rooms" style="margin-right: 15px;">Количество комнат</label>

                        <select class="form-control" id="select-count-rooms" name="rooms-count">
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                        </select>
                    </div>

                    <div class="form-group" style="margin-top: 10px;">
                        <label class="checkbox-inline">
                            <input name = "kindergarden" type="checkbox" id="inlineCheckbox1" value="true"> Детский сад/Ясли
                        </label>
                        <label class="checkbox-inline">
                            <input name = "school" type="checkbox" id="inlineCheckbox2" value="true"> Школа
                        </label>
                    </div>

                    <div class="form-group" style="margin-top: 10px;">
                        <label for="select-condition" style="margin-right: 10px;">Жилищные условия</label>
                        <select name="condition" id="select-condition" class="form-control">
                            <option value="1">Ужасное</option>
                            <option value="2">Плохое</option>
                            <option value="3">Среднее</option>
                            <option value="4">Хорошее</option>
                            <option value="0">Без жилья</option>
                        </select>
                    </div>
                    <!-- <textarea class="form-control" rows="3" cols="68" style="margin: 30px 0;" placeholder="Пожелания на район"></textarea> -->
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

<script type="application/javascript">
    var c = 0;
    function addChild() {
        c++;
        var s = document.getElementById('child').innerHTML;
        s = s.replace(/[\r\n]/g, '');
        var regexp = /(.*)(<span id=.*><\/span>)(<br>)(.*)/gi;
        s1 = s.replace(regexp, '$2');
        s2 = s1.replace(/\[\d\]/gi, '['+ c +']');
        s2 = s2.replace(/(removeCh\()(\d+\))/gi, '$1' + c + ')');
        s = s.replace(regexp, '$1$2' + s2 + '$3$4');
        document.getElementById('child').innerHTML = s;
    }
    function removeCh(q) {
        if (c==0) {
            return false;
        }else{
            c--;
        }
        s = document.getElementById('child').innerHTML;
        s = s.replace(/[\r\n]/g, '');
        re = new RegExp('<span id="?child\\['+q+'.*?<\\/span>', 'gi');
        s = s.replace(re, '');
        document.getElementById('child').innerHTML = s;
    }
    </script>

    </body>
</html>