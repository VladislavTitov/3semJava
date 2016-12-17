<%--
  Created by IntelliJ IDEA.
  User: Vladislav
  Date: 04.12.2016
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin - Очередь на жилье</title>
    <script src="js/jquery-3.1.1.js"></script>
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
        <h1>This is Admin page</h1>
    </div>
</div>

<div class="container-fluid">
    <div class="row">
        <input type="button" value="Ajax" class="ajax-request">
        <input type="button" value="Close" class="close_table">
    </div>
    <table id="queue" width="100%" cellpadding="5" border="1" style="display: none" class="table"></table>
</div>

<input type="button" id="delaj" value="DelAjax">
<input type="button" id="delclose" value="Close">

<table id="deleted_queue" width="100%" cellpadding="5" border="1" style="display: none" class="table"></table>

<script>
    $(document).ready(function () {
        /*$("#queue").animate({height:"hide"});*/
        $(".ajax-request").click(function () {
            $.ajax({
                type: "POST",
                url: "/admin",
                data:"deleted=false",
                dataType: "html",
                success: function (msg) {
                    $("#queue").html(msg).animate({height:"show"});
                }
            });
        });
        $(".close_table").click(function () {
            $("#queue").slideUp();
        });
        $("#delaj").click(function () {
            $.ajax({
                type: "POST",
                url: "/admin",
                data:"deleted=true",
                dataType: "html",
                success: function (msg) {
                    $("#deleted_queue").html(msg).animate({height:"show"});
                }
            });
        });
        $("#delclose").click(function () {
            $("#deleted_queue").slideUp();
        });

        $("div>table>tr>td>a").click(function () {
            alert("It's a normal link");
        });

        $(".deleted").click(function () {
            alert("It's a deleted link");
        });

        function deleteRow(link) {
            alert("it's deleteRow");
            if ($(link).attr("class") === "normal"){
                alert("It's a normal link");
            }else if ($(link).attr("class") === "deleted"){
                alert("It's a deleted link");
            }
        }

    });

</script>
</body>
</html>
