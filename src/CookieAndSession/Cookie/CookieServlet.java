package CookieAndSession.Cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
一、 cookie的概念：
cookie就是可以把客户端从服务器获取到的资源放到了本地的硬盘中，而session则是把资源放到了服务器上
　假设在用户请求访问您的网站  上的某个页面时，您的应用程序发送给该用户的不仅仅是一个页面，
还有一个包含日期和时间的 Cookie。用户的浏览器在获得页面的同时还得到了这个   Cookie，并且将它保存在用户硬盘上的某个文件夹中。

二、 cookie的用法
1. 首先需要创建一个cookie的对象
    a。 Cookie cookie= new Cookie("goods","cap");
2. 向和客户端发送cookie（不能是中文）
    b。  response.addCookie(cookie);
*
* */
@WebServlet(name = "CookieServlet", urlPatterns = "/cookie")
public class CookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


//创建cookie对象
        Cookie cookie= new Cookie("goods","cap");
        cookie.setMaxAge(0);
        cookie.setPath("/hello/getCookie");
        //向客户端发送cookie

        Cookie cookie1 = new Cookie("userName" ,"wangwei");

        response.addCookie(cookie);
        response.addCookie(cookie1);
    }
}
