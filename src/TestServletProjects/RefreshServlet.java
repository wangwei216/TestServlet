package TestServletProjects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/*
                这个servlet是实现自动跳转的功能
 一、 通过setRefresh（"refresh","多少时间后刷新的参数"）这个响应头来实现自动刷新
       1. 通过 response.setHeader("refresh","3;URL='/hello/home.html'");第一个参数固定的，第二个参数是自动刷新的时间和自动转到的url
       2. request.setAttribute("message",message);用来在同一个request周期中保存变量使用。
       3. 用调度分发器 也就是实现转发功能request.getRequestDispatcher("/index.jsp").forward(request,response);
 二、想要实现跳转网页的时候自动跳转刷新的话，需要用到<mete http-equiv='refresh' content='3:url=/hello/home.html'>

扩展：-利用RequestDispatcher对象，可以将请求转发给另外一个Servlet或JSP页面，甚至是HTML页面，来处理对请求的响应。
一，RequestDispatcher接口方法简介
     1，RequestDispatcher对象由Servlet容器来创建，封装一个由路径所标识的服务器资源。
     2，RequestDispatcher接口中定义了二种方法用于请求转发：
           forward（ServletRequest，ServletResponse）方法：
                   将请求转发给服务器上另外一个Servlet，JSP页面，或者HTML文件      这个方法必须在响应被提交给客户端之前调用，否则抛出异常。
                  方法调用后在响应中的没有提交的内容被自动消除。
           include（ServletRequest，ServletResponse）方法 ：
                 用于在响应中包含其他资源(Servlet，JSP页面或HTML文件)的内容。
                 即请求转发后，原先的Servlet还可以继续输出响应信息，转发到的Servlet对请求做出的响应将并入原先Servlet的响应对象中。
      3，forward方法和include方法的区别：
                  forward方法调用后在响应中的没有提交的内容被自动消除。   include方法使原先的Servlet和转发到的Servlet都可以输出响应信息。

二，得到RequestDispatcher对象
      三种方法可以得到RequestDispatcher对象：
             1，利用ServletRequest接口中的getRequestDispatcher（String  path）方法。
             2，ServletContext接口中getNamedDispatcher（String  path）和getRequestDispatcher（String  path）方法。
     ServletRequest接口和ServletContext接口中getRequestDispatcher方法区别：
              1，参数的区别
                      参数虽然都是资源路径名，ServletContext接口的中参数路径必须以“/”开始，是相对于当前Servlet上下文根，    ServletRequest接口中的参数路径不仅可以相对于当前Servlet上下文根，还可以相对与当前Servlet路径
             2，跨WEB应用程序访问资源
                      通过ServletContext.getContext（）方法获取另个WEB应用程序的上下文环境对象来    调用getRequestDispatcher（String  path）方法 将请求转发到另个WEB应用程序的资源。
                     还需要在当前WEB应用程序配置中设置<context>元素，指定crossContext属性值为true。
三，ServletResqonse接口中的sendReadirect()方法和forward()方法的区别
       二个方法都是用于请求转发的方法，转发给另外的资源为客户端服务。但二者有本质的区别
       sendReadirect()方法原理：
              1，客户端发送请求，Servlet1做出处理。
              2，Servlet1调用sendReadirect()方法，将客户端的请求 重新定位 到Servlet2。
              3，客户端浏览器访问Servlet2.
              4，Servlet2对客户端浏览器做出响应。
       forward()方法原理：
             1，客户端发送请求，Servlet1做出处理。
             2，Servlet1调用sendReadirect()方法，将请求转发给Servlet2来处理请求，为客户端服务。
             3，Servlet2对客户端浏览器做出响应。
      区别：
           1，定位与转发
                    sendReadirect()方法是重新定位到另外一个资源来处理请求，URL会重新定位，让客户端重新访问另外一个资源。    forward()方法是转发到另外一个资源来处理请求。URL不会变化。隐藏了处理对象的变化。
           2，处理请求的资源的范围
                  sendReadirect()方法可以跨WEB应用程序和服务器重新定位资源来处理请求。    forward()方法只能在应用程序内部转发。
* */
@WebServlet(name = "RefreshServlet" ,urlPatterns = "/refresh")
public class RefreshServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


       String message= "<meta http-equiv='refresh' content='3;url=/hello/home.html'>3秒后会自动跳转到首页，如果没有跳转请点击<a href='/hello/home.html'>链接</a>";
       request.setAttribute("message",message);
       request.getRequestDispatcher("/index.jsp").forward(request,response);
    }

    private void refreshDemo1(HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("refresh","3;URL='/hello/home.html'"); //后面设置的是时间参数
        response.getWriter().print("3秒后自动跳转");
    }
}
