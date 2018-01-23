<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2018-01-22
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
        <h2>这是一个实现请求转发功能跳转过来的用户名和密码错误的提示页面的JSP</h2>
</head>
<body>

<center>
    <h1>用户名登录错误提示界面</h1>
    <div>
        <%=request.getAttribute("errorMessage")%>
    </div>
</center>
</body>
</html>
