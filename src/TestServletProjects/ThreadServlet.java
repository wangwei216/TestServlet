package TestServletProjects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/*
一、 线程安全的问题总结：

    1. 如果int是写在doGet方法内部的话，就不会存在线程安全问题，因为doGet方法中service会调用不同的线程去执行线程
*   2. 这样的话就不会出现线程问题，但是如果是都在doGet方法之外（全局变量）的话 就会出现线程安全问题要是放在doGet方法下是（局部变量），当两个浏览器同时访问的时候，就会出现访问到同一个资源
二、线程安全问题的解决办法：
    1. 就是把涉及到的代码安全问题放到 synchronized (this){}的代码块中去，这是一个同步代码块
    （缺点：就是必须排队等待上一个线程结束）
    2. 实现SingleThreadModel的接口，分别为每一个实例创建一个线程（浪费计算机资源，不推荐）
    3. 尽量不要在servlet实例内使用共享变量（主要推荐使用）
* */
@WebServlet(name = "ThreadServlet",urlPatterns = "/thread")
public class ThreadServlet extends HttpServlet {

    int i=0;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        synchronized (this){

            i++;
            try {
                Thread.sleep(1000*5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write( i+"");
        }

    }
}
