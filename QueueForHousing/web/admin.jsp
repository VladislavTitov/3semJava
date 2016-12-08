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
</head>
<body>
<h1>This is Admin page</h1>

<input type="button" value="Ajax" class="ajax-request">
<input type="button" value="Close" class="close_table">

<h2 class="result"></h2>

<table id="queue" width="100%" cellpadding="5" border="1" style="display: none"></table>

<script>
    $(document).ready(function () {
        /*$("#queue").animate({height:"hide"});*/
        $(".ajax-request").click(function () {
            $.ajax({
                type: "POST",
                url: "/admin",
                dataType: "html",
                success: function (msg) {
                    $("#queue").html(msg).animate({height:"show"});
                }
            });
        });
        $(".close_table").click(function () {
            $("#queue").animate({height:"hide"});
        });

    });

</script>
</body>
</html>
