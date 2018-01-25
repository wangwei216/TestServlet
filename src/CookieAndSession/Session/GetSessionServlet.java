package CookieAndSession.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
//从存储的session中取出一个
@WebServlet(name = "GetSessionServlet", urlPatterns = "/getsession")
public class GetSessionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      HttpSession session= request.getSession();
      //也就是创建一个cookie 覆盖之前服务器自动生成的JSESSIONID
       Cookie cookie= new Cookie("JESESSIONID",session.getId());
       //设置cookie的持久化
        cookie.setMaxAge(60*60);
        //通过服务器把重新设置的cookie返回给浏览器
        response.addCookie(cookie);

      String goods= (String)session.getAttribute("goods");

      response.getWriter().write(goods);
    }
}
