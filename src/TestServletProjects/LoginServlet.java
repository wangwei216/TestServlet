package TestServletProjects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/*
一、测试请求转发的功能总结：

* 1. 使用getParameter(String s)方法是能够获取某个指定名称的的参数值，如果如果请求中没有包含指定参数的值的时候，返回的是null。
*     如果有指定参数但是没有给设置值的话会返回空串“ ”。
* 2. 用HTML里面获取到的用户的密码和用户名的name，跟servlet中定义的用户名。密码用equals()方法来进行比较
* 3. 需要得到RequestDispatcher对象再去用这个对象去调用forward()方法就可以实现转发功能，
*       request.getRequestDispatcher(这个参数是一个jsp的路径).forward(request,response);
* 4.
*
* 注意：request也是一个域对象, request可以携带数据传递给其他web资源
*
二、重定向的意思就是：
    1. 当客户端向servletA发送一个请求的时候，而servletA会先向客户端做出一个响应在响应的时候会返回一个状态码 302或者301
    2. 并且返回的过程中会携带一个新的地址，这时候客户端会重新向新地址的那个servletB发起请求，servletB再做出相应的响应

三、重定向有两种方式：
    （1）1. 调用setStatus() 的方法，需要穿进去的参数也就是状态码
         2 . 用response调用后面的方法response.setHeader()的方法，传进来的都是字符串 前者是“Location”后面的是重定向的URL地址
    （2）就是相当于把前两个的方法结合成一种调用方法response.sendRedirect(参数就是重定向的URL字符串地址)
注意：如果重定向的是我们自己的Tomcat服务器的话，需要在文件夹映射前 还要加上项目的映射名字才可以访问的到

四、重定向和请求转发的区别：
    1. 请求转发的时候地址栏不会改变，而重定向的时候地址栏是会改变的
    2. 请求转发中只有一次request和response响应，而重定向则出现两次
    3. 请求转发只能是在一个项目下面的包中进行的请求转发，而重定向可以在不同个项目或者包中进行的请求转发（但是在不同的包下或者项目下都要加上该项目的映射名）

* */
@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userName="wangwei";
        String userPass="123456";
         String name = request.getParameter("userName");
         String passWord = request.getParameter("passWord");

      if(!name.equals(userName)){

          //用户名错误
          request.setAttribute("errorMessage","用户名 错误");
          request.getRequestDispatcher("/loginError.jsp").forward(request,response);
      }
        else if(!passWord.equals(userPass)){
            //密码错误
            request.setAttribute("errorMessage" ,"密码登录错误");
            request.getRequestDispatcher("/loginError.jsp").forward(request,response);
        }

      else {
//          response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
//          response.setHeader("Location","http://www.baidu.com/");
          response.sendRedirect("http://www.jd.com/");
      }
    }
}
