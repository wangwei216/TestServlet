package CookieAndSession.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/*
一、得到购物车里面的数据
*   1， 先得到一个session 对象
*   2. 得到session对象里面的集合
*   3. 遍历集合
*   4. 从服务器把集合内容返回给浏览器
*   5，因为添加购物车的中有汉字显示，所以需要设置一下编码格式
*
*
* */
@WebServlet(name = "GetCartServlet",urlPatterns = "/getcart")
public class GetCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");

        HttpSession session= request.getSession();
        List<String> list= (List<String>) session.getAttribute("list");
        for (String s : list) {
            response.getWriter().write(s+"<br/>");
        }
    }
}
