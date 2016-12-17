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

    <div class='collapse navbar-collapse'>
        <ul class='nav navbar-nav navbar-right'>
            <li class='dropdown'>
                <a href='#' id='options-drop' class='dropdown-toggle' data-toggle='dropdown' role='button'>Опции</a>
                <ul class='dropdown-menu' role='menu' aria-labelledby='options-drop'>
                    <li role='presentation'><a href='#'>Изменить данные</a></li>
                    <li role='presentation' class='divider'></li>
                    <li role='presentation'><a href='#'>Удалить аккаунт</a></li>
                    <li role='presentation' class='divider'></li>
                    <li role='presentation'><a href='/signout'>Выйти</a></li>
                </ul>
            </li>
        </ul>
    </div>

</nav>

<body>
<div class="container-fluid">
    <div class="col-lg-6 col-lg-offset-3 banner block">
        <h1>Регистрация на очередь</h1>
    </div>
</div>

<div class='container'>
    <div class='col-lg-8 col-lg-offset-2 block join-form-block'>
        <h2 class='form-header'>Отец</h2>
        <form class='form-inline queue-form' role='form' action='/queue' method="post" id="father-form">
            <div class='form-group form-group-list'>
                <input type='text' class='form-control' id='surname-father-input' name='father_surname' placeholder='Фамилия'>
            </div>
            <div class='form-group form-group-list'>
                <input type='text' class='form-control' id='name-father-input' name='father_name' placeholder='Имя'>
            </div>
            <div class='form-group form-group-list'>
                <input type='text' class='form-control' id='patronymic-father-input' name='father_patronym' placeholder='Отчество'>
            </div>
            <div class='col-lg-3 col-lg-offset-9'>
                <div class='col-sm-offset-2 col-sm-10'>
                    <input type='submit' name='Отправить' id='enter-father' class='btn btn-primary' style='width: 100%;'
                           data-container="body" data-toggle="popover" data-placement="top" data-content="Успешно!"/>
                </div>
            </div>
        </form>
    </div>
</div>

<div class='container'>
    <div class='col-lg-8 col-lg-offset-2 block join-form-block'>
        <h2 class='form-header'>Мать</h2>
        <form class='form-inline queue-form' role='form' action='/queue' id="mother-form">
            <!-- ROW -->
            <div class='row'>
                <div class='form-group form-group-list'>
                    <input type='text' class='form-control' id='surname-mother-input' name='mother_surname' placeholder='Фамилия'>
                </div>
                <div class='form-group form-group-list'>
                    <input type='text' class='form-control' id='name-mother-input' name='mother-name' placeholder='Имя'>
                </div>
                <div class='form-group form-group-list'>
                    <input type='text' class='form-control' id='patronymic-mother-input' name='mother-patronym' placeholder='Отчество'>
                </div>
            </div>
            <!-- ROW -->
            <div class='col-lg-3 col-lg-offset-9'>
                <div class='col-sm-offset-2 col-sm-10'>
                    <input type='submit' name='Отправить' id='enter-mother' class='btn btn-primary' style='width: 100%;'
                           data-container="body" data-toggle="popover" data-placement="top" data-content="Успешно!"/>
                </div>
            </div>
        </form>
    </div>
</div>

<div class='container'>
    <div class='col-lg-8 col-lg-offset-2 block join-form-block'>
        <h2 class='form-header'>Дети</h2>
        <form id="children-form" class='form-inline queue-form' role='form' >

            <div class='row child'>
                <div class='form-group form-group-list'>
                    <input type='text' class='form-control child-surname' id='surname-child-input-0' name='child-surname-0' placeholder='Фамилия'>
                </div>
                <div class='form-group form-group-list'>
                    <input type='text' class='form-control child-name' id='name-child-input-0' name='child-name-0' placeholder='Имя'>
                </div>
                <div class='form-group form-group-list'>
                    <input type='text' class='form-control child-patronym' id='patronymic-child-input-0' name='child-patronym-0' placeholder='Отчество'>
                </div>
                <button class='btn btn-primary' type='button' onclick="removeCh(this)"><span class='glyphicon glyphicon-minus'></span></button>
            </div>

            <div class='row' >
                <div class='col-lg-1 col-lg-offset-10'>
                    <div class='col-sm-offset-2 col-sm-10'>
                        <button type='button' class='btn btn-primary' onclick="addChild()" style="padding: 5px 10px;"><span class='glyphicon glyphicon-plus'></span></button>
                    </div>
                </div>
            </div>

            <input type="text" name="children-count" value="1" id="children-count" style="display: none;" />

            <div class='col-lg-3 col-lg-offset-9'>
                <div class='col-sm-offset-2 col-sm-10'>
                    <input type='submit' name='Отправить' id='enter-children' class='btn btn-primary' style='width: 100%;'
                           data-container="body" data-toggle="popover" data-placement="top" data-content="Успешно!"/>
                </div>
            </div>
        </form>
    </div>
</div>

<div class='container'>
    <div class='col-lg-8 col-lg-offset-2 block join-form-block'>
        <h2 class='form-header'>Прочее</h2>
        <form id="others-form" class='form-inline queue-form' role='form' >

            <div class='form-group form-group-list'>

                <div class='form-group'>
                    <label for='select-district' style='margin-right: 15px;'>Район</label>
                    <select class='form-control' id='select-district' name='district'>
                        <option value='center'>Центр</option>
                        <option value='new'>Новостройки</option>
                        <option value='sleep'>Спальный район</option>
                    </select>
                </div>

                <div class='form-group' style='margin-top: 10px;'>
                    <label for='select-count-rooms' style='margin-right: 15px;'>Количество комнат</label>
                    <select class='form-control' id='select-count-rooms' name='rooms-count'>
                        <option value='1'>1</option>
                        <option value='2'>2</option>
                        <option value='3'>3</option>
                        <option value='4'>4</option>
                        <option value='5'>5</option>
                    </select>
                </div>

                <div class='row'>
                    <label class='checkbox-inline'>
                        <input name = 'kindergarden' type='checkbox' id='kindergarden-checkbox' value='true'> Детский сад/Ясли
                    </label>
                    <label class='checkbox-inline'>
                        <input name = 'school' type='checkbox' id='school-checkbox' value='true'> Школа
                    </label>
                </div>

                <div class='form-group' style='margin-top: 10px;'>
                    <label for='select-condition' style='margin-right: 10px;'>Жилищные условия</label>
                    <select name='condition' id='select-condition' class='form-control'>
                        <option value='1'>Ужасное</option>
                        <option value='2'>Плохое</option>
                        <option value='3'>Среднее</option>
                        <option value='4'>Хорошее</option>
                        <option value='0'>Без жилья</option>
                    </select>
                </div>

            </div>

            <div class='col-lg-3 col-lg-offset-9'>
                <div class='col-sm-offset-2 col-sm-10'>
                    <input type='submit' name='Отправить' id='enter-others' class='btn btn-primary' style='width: 100%;'
                           data-container="body" data-toggle="popover" data-placement="top" data-content="Успешно!"/>
                </div>
            </div>
        </form>
    </div>
</div>
<div class="container">
    <div class="col-lg-8 col-lg-offset-2">
        <div class="col-lg-offset-4 col-lg-4">
            <input id="save-btn" type="button" name="save" class="btn btn-primary" value="Сохранить" style="width: 100%;">
        </div>
    </div>
</div>

<!-- <footer>
  <div class="col-lg-2 col-lg-offset-5" style="text-align: center;">
    <a class="author-link" href="https://github.com/VladislavTitov" target="_blank">Владислав Титов, 11-502</a>
  </div>
</footer> -->

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>

<script>
    var count = 0;
    $(document).ready(function () {

        $("#save-btn").click(function () {
            $.ajax({
                url:"/queue",
                type:"post",
                data:"save=true",
                success:function (response) {
                    document.location.href = response;
                }
            });
        });

        $("h2").click(function () {
            $(this).next().slideToggle();
        });
        
        $("#father-form").submit(function (e) {
            e.preventDefault();
            var m_data = "father-surname="+$("#surname-father-input").val() +
                            "&father-name"+ $("#name-father-input").val()+
                            "&father-patronymic"+ $("#patronymic-father-input").val()+
                            "&mode=father";

            $.ajax({
                type:"POST",
                url:"/queue",
                data:m_data,
                success:function (response) {
                    $("#enter-father").popover("show");

                },
                error:function () {
                    alert("Вы ввели неверные данные! Попытайтесь снова...");
                }
            });
        });

        $("#mother-form").submit(function (e) {
            e.preventDefault();
            var m_data = "mother-surname="+$("#surname-mother-input").val() +
                "&mother-name"+ $("#name-mother-input").val()+
                "&mother-patronymic"+ $("#patronymic-mother-input").val()+
                "&mode=mother";

            $.ajax({
                type:"POST",
                url:"/queue",
                data:m_data,
                success:function (response) {
                    $("#enter-mother").popover("show");
                },
                error:function () {
                    alert("Вы ввели неверные данные! Попытайтесь снова...");
                }
            });
        });

        $("#children-form").submit(function (e) {
            e.preventDefault();
            var m_data = "children-count=" + $("#children-count").val();
            for (var i = 0; i < count + 1; i++) {
                m_data += "&child-surname["+i+"]=" + $("#surname-child-input-"+i).val() +
                    "&child-name["+i+"]=" + $("#name-child-input-"+i).val() +
                    "&child-patronymic["+i+"]=" + $("#patronymic-child-input-"+i).val();
            }

            m_data += "&mode=children";

            $.ajax({
                type:"POST",
                url:"/queue",
                data:m_data,
                success:function (response) {
                    $("#enter-children").popover("show");
                },
                error:function () {
                    alert("Вы ввели неверные данные! Попытайтесь снова...");
                }
            });
        });

        $("#others-form").submit(function (e) {
            e.preventDefault();
            var m_data = "district=" + $("#select-district").change().val()+
                    "&rooms-count=" + $("#select-count-rooms").change().val() +
                    "&condition=" + $("#select-condition").change().val() +
                    "&kindergarden=" + $("#kindergarden-checkbox").prop("checked") +
                    "&school=" + $("#school-checkbox").prop("checked") +
                    "&mode=others";

            $.ajax({
                type:"POST",
                url:"/queue",
                data:m_data,
                success:function (response) {
                    $("#enter-others").popover("show");
                },
                error:function () {
                    alert("Вы ввели неверные данные! Попытайтесь снова...");
                }
            });
        });

        $("input").keyup(function (key) {
            var value = $(this).val();
            if (value.search(/[^a-zA-Zа-яА-Я]/i) == -1) {
                $(this).parent().removeClass("has-error");
                $(this).parent().addClass("has-success");
                $("input[type=submit]").attr('disabled', false);
            }else{
                $(this).parent().removeClass("has-success");
                $(this).parent().addClass("has-error");
                $("input[type=submit]").attr('disabled', true);
            }
        });

    });

    function removeCh(btnRemove) {
        $(document).ready(function () {
            count--;
            console.log("removeCh");
            $(btnRemove).parent().detach();
            $("div.child").each(function (i, elem) {
                $(this).find(".child-surname").attr("name", "child-surname["+ i +"]").attr("id", "surname-child-input["+ i +"]");
                $(this).find(".child-name").attr("name", "child-name["+ i +"]").attr("id", "name-child-input["+ i +"]");
                $(this).find(".child-patronym").attr("name", "child-patronym["+ i +"]").attr("id", "patronymic-child-input["+ i +"]");
            });

        });
    };

    function addChild() {
        $(document).ready(function () {
            count++;
            console.log("addChild");
            var child = "<div class='row child'.><div class='form-group form-group-list'><input type='text' class='form-control child-surname' id='surname-child-input-"+ count +"' name='child-surname-"+ count +"' placeholder='Фамилия'></div><div class='form-group form-group-list'><input type='text' class='form-control child-name' id='name-child-input-"+ count +"' name='child-name-"+ count +"' placeholder='Имя'></div><div class='form-group form-group-list'><input type='text' class='form-control child-patronym' id='patronymic-child-input-"+ count +"' name='child-patronym-"+ count +"' placeholder='Отчество'></div><button class='btn btn-primary' type='button' value='-' onclick=\"removeCh(this)\"><span class='glyphicon glyphicon-minus'></button></div>"
            if ($(".child").is(":last")) {
                $('.child:last').after(child);
            }else{
                $("#children-form").prepend(child);
            }
        });
    };

</script>

</body>
</html>