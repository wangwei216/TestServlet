<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2018-01-27
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>手机商品商品列表</title>
    <style>
        ul li  p.p2{color: red; font-size: 16px}
        ul{list-style: none; float: left}
</style>

</head>
<h2 align="center">欢迎来到王伟的手机购物商城</h2>
<body>

<c:forEach items="${list}"  var="phone">
 <ul>
     <li>
         <img  src="${phone.image}"  width="170px" height="170px">


         <p align="center">
             <a style="color: green"> ${phone.name}</a>
         </p>

         <p class="p2" align="center">
             商城价：&yen;${phone.price}
         </p>
     </li>
 </ul>
</c:forEach>
</body>
</html>
