package CookieAndSession.JSP;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/*
一、 实现一个微博上的关注和取消功能的
    1. 先获取到follow按钮的参数
    2. 给follow设置key 和value，也就是用setAttribute（）方法
    3. 然后转发给jsp页面

* */
@WebServlet(name = "FollowServlet",urlPatterns = "/follow")
public class FollowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       String follow= request.getParameter("follow");
        request.setAttribute("follow", follow);
        request.getRequestDispatcher("/jstl/jstl.jsp").forward(request,response);

    }
}
