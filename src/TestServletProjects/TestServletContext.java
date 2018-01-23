package TestServletProjects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
总结： 用servletContext（） 对象获得来获取web环境下项目中的全局初始化参数
*
* 一、获取servletContext的对象的两种方法：
*       1，通过servletConfig().getServletContext()的方法可以得到servletContext对象
*       2. 只要是在继承的是HttpServlet中直接使用this.getServletContext()方法也可以直接得到servletContext对象
* 注意：1. 并且使用servletContext（）对象可以在多个servlet下获取数据
*
总结：
    二、使用ServletContext可以实现在多个servlet中的数据共享(是以servletContext为纽带来实现共享数据的）
        1. 先把你要共享的那个servlet使用getServletContext().setAttribute()《这个是存放数据》void setAttribute(string name，Object object )
        2. 然后用Object getAttribute（String name）  来获取数据
        3. 最后是Object removeAttribute(String name)  是用来移除数据的

    三、 使用servletContext也可以获取到web项目中的资源文件（读取链接数据库的配置文件）
        1. 先用getServletContext().getResourceAsStream();这个参数传进来的是一个web-INF下的路径，返回的是一个inputStream类型的输入流
        2. 创建一个Properties类型的对象
        3. 调用properties.load()方法，传进去的参数是inputStream类型的实例对象
        4. 使用properties对象调用getProperties()方法，传进来的是配置信息的名字也就是字符串类型

* */
@WebServlet(name = "TestServletContext",urlPatterns = "/testServletContext")

public class TestServletContext extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

                String encoding=this.getServletContext().getInitParameter("encoding");
                 System.out.println("看看是不是把value的值utf-8打印出来了"+encoding);
    }
}
