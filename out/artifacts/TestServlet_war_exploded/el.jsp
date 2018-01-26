<%@ page import="javax.jws.soap.SOAPBinding" %>
<%@ page import="CookieAndSession.Bean.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.sun.javafx.scene.control.skin.VirtualFlow" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2018-01-26
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>这是el的总结</title>
</head>
<body>

<%
    request.setAttribute("name","王伟");
    User user = new User();
    user.setName("王俊伟");
    user.setSex("男");
    session.setAttribute("user",user);

    List<User> list = new ArrayList<>();
    User user1 = new User();
    user1.setName("王杰");
    user1.setSex("男");

    User user2 = new User();
    user2.setName("王帅");
    user2.setSex("男");
    list.add(user1);
    list.add(user2);
    application.getAttribute("list");
%>

<%=request.getAttribute("name")
%>

<%
       User user3 = (User)session.getAttribute("user");
      String name =user3.getName();
      out.write(name);
%>

<%
          List<User> list1= (List<User>) application.getAttribute("list");
    User user4 = list1.get(0);
    out.write(user4.getName());

%>

${requestScope.name}
${sessionScope.user.name}
${applicationScope.list[0].name}
</body>
</html>
