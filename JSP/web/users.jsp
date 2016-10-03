<%@ page import="java.util.List" %>
<%@ page import="dao.User" %>
<%--
  Created by IntelliJ IDEA.
  User: Vladislav
  Date: 19.09.2016
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
    <p>
        <%
            List<User> users = (List) request.getAttribute("userlist");
            for (User user :
                    users) {%>

                  <%=user.toString()%><br>

            <%}
        %>
    </p>
</body>
</html>
