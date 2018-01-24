package CookieAndSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
一、Cookie常用的方法；
    1. cookie.setMaxAge(int s); 参数表示在客户端留存的时间长久,如果要是想要删除coolie的留存时间的话 就把时间设置成0
*   2.  cookie.setPath("/hello");
*   3.  response.addCookie(cookie); 向客户端发送一个cookie信息

二、怎么让服务器能从客户端浏览器上获得我们需要的数据呢：
    1. 得到一个cookie，并且返回的是一个数组
    2. 遍历cookie数组
    3. 得到cookie数组中的名字，并且用if看看是不是存
    4，然后输出数据
*
* */

@WebServlet(name = "GetCookieServlet",urlPatterns = "/getcookie")
public class GetCookieServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      Cookie[] cookies= request.getCookies();
        for (Cookie cookie : cookies) {
            String name= cookie.getName();
            if(name.equals("userName")){
                //那么userName是从哪里来的呢
                String cookieValue=cookie.getValue();
                response.getWriter().write("userName"+cookieValue);
            }
        }
    }
}
