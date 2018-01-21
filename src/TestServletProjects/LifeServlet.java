package TestServletProjects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/*
* 一、测试servlet生命周期代码书写
*   1. 建一个servlet的时候必须要先声明一个映射urlPatterns（也就是客户端访问服务器的时候需要解析的地方）
*   2. 然后分别重写init 、service、destory方法
*  二、servlet的生命周期的过程总结
*   1.当客户端第一次访问服务器的时候会先对服务器判断servlet的实例，如果没有的话会装载servlet类，然后调用init方法初始化一个servlet
*   2. 然后会调用service方法
*   3. 最后会执行destory方法，但是如果当客户端不是第一次访问服务器的话，就不会调用init方法，而是直接调用service方法，
* 注意：servlet实例是单例的。无论客户端向服务器请求多少次，最多只有一次实例。 在多个客户端并发请求服务器的时候,服务器会启动多个线程分别执行servlet的方法
* 原因：如果我们每次请求都进行一次实例的话，会占用和浪费过多的计算机服务资源
* */
@WebServlet(name = "LifeServlet" ,urlPatterns = "/life")
public class LifeServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("init方法被执行了");
        super.init();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("service方法被执行了");
        super.service(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet 方法被执行了");
    }


}
