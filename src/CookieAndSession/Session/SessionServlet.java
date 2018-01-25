package CookieAndSession.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
/*
一、 session就是基于cookie技术的基础上实现的一种在服务器上存储数据的技术
     1， 先创建一个 HttpSession session = request.getSession(); 这个方法就是获得当前session的对象，如果服务器端没有这个浏览器端的session对象，
        他就会重新创建一个session对象，如果有的话就直接返回已经有的session对象给浏览器（其实使用JSESSIONID= 来判断是不是存在session的）
     2. 返回一个字符串的getSessionID方法的字符串
*
*
* */
@WebServlet(name = "SessionServlet",urlPatterns = "/session")
public class SessionServlet extends HttpServlet {

    private HttpSession session;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession session = request.getSession();
        String sessionid=session.getId();
        response.getWriter().write(sessionid);
    }
}
