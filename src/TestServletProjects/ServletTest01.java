package TestServletProjects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletTest01",urlPatterns = "/test")
public class ServletTest01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


      response.getWriter().print("zheshiyijuhua ");
      response.setHeader("refresh" ,"3;url=http:/www.baidu.com");//可以设置一个自动更新


    }
}
