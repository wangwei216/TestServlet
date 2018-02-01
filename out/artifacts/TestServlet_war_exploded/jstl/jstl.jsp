<%@ page import="CookieAndSession.Bean.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.sun.java.util.jar.pack.ConstantPool" %>
<%@ page import="javax.sound.midi.Soundbank" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2018-01-27
  Time: 13:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType=" text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c "%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>这个是测试jstl</title>
</head>
<body>

<c:if test="${requestScope.follow eq 1}">
    等于1的话说明已经关注了  显示的就是《取消关注》按钮
    在JSTL下需要配合使用EL的内容才能实现此功能， 如果要是想实现else里面的东西 还需要从新在建一个if标签

</c:if>
    <c:if test="${requestScope.follow eq 0}">
        如果没有等于0的话就说明没有关注，此时显示的就是《关注》按钮
    </c:if>

    <%
        List<User> list = new ArrayList<>();
        User user1 = new User();
        user1.setName("王杰");
        user1.setSex("男");

        User user2 = new User();
        user2.setName("王帅");
        user2.setSex("男");
        list.add(user1);
        list.add(user2);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(i);
        }

        for (User user : list) {
            System.out.println(user.getName());
        }
/*如何比较 java循环和JSTL循环的区别，需要用到list的时候，需要先把list放到域对象里*/
        request.setAttribute("list",list);
    %>

    <c:forEach begin="0" end="${list.size()}" var="i">
        ${i}
    </c:forEach>

    <%-- items表示 是一个数组或者是一个集合--%>
    <c:forEach items="${list}"  var="user">
        ${user.name}
    </c:forEach>
</body>
</html>
