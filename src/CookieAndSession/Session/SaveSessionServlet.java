package CookieAndSession.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
/*
需要用到的知识点的API:
    1,setAttribute(String name,Object obj); 这个是设置参数和值（可以间接的理解成为是一个key和value）的方法
    2.getAttribute（string name） 得到属性的方法
    3.removeAttribute（String name）

一、如何得到浏览器的session的值
把值存到session中
    1. 拿到session对象
    2. 向session对象 里面存进去值用 setAttribute（）
取出session
    1. 先拿到session对象
    2  然后得到session的值， 用getAttribute()  返回的是一个字符串
    3. 从服务器中返回给浏览器客户端

二、 如何能在客户端浏览器关闭的时候，让session能够在服务器上的时间更加持久：
    1，原理就是因为session是基于cookie的基础上来完成的操作，但是在cookie的定义中，当浏览器关闭所有窗口的时候，默认的事cookie会自动销毁
    2，所有实现session的持久化本质上就是实现cookie的持久化，需要用到 cookie.setMaxAge(60*60);
实现的三个步骤：
    1. 也就是创建一个cookie 覆盖之前服务器自动生成的JSESSIONID
    2. 设置cookie的持久化
    3. 通过服务器把重新设置的cookie返回给浏览器
*
*
* */
@WebServlet(name = "SaveSessionServlet",urlPatterns = "/savesession")
public class SaveSessionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

                    HttpSession session= request.getSession();
                    session.setAttribute("goods","cup");

    }
}
