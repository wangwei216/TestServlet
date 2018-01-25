package CookieAndSession.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
一、用session实现一个加入购物车的功能
    1. 获取商品的信息
    2. 保存商品信息给session对象
    3. 得到的信息设置到session中，（如果多个信息的话 后面的会覆盖前面的信息）
    4. 如何保存多个信息呢，需要用到集合list，new一个ArrayList，把浏览器请求的key 都放进去
    5. 但是这样只能实现 这一次加入购物车的记录，并不能把之前的购物车里面的记录一起结算‘
    6，对一次访问的时候list是不存在的 需要做一个判断，并且创建一个ArrayList
    7. 设置session的持久化 就是设置JSESSIONID的时间 ，然后返回给浏览器

*
*
*
* */
@WebServlet(name = "AddCartServlet",urlPatterns = "/addCart")
public class AddCartServlet extends HttpServlet {

    private HttpSession httpSession;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       String name= request.getParameter("name");
       HttpSession session = request.getSession();


       //这个是拿到之前加入购物车的商品，
        List list = (List) session.getAttribute("list");
       if(list==null){
           //如果之前没有商品就重新为其new一个ArraryList
           list = new ArrayList();
       }
        list.add(name);
        session.setAttribute("list",list);
        //持久化session的操作
        Cookie cookie= new Cookie("JSESSIONID",session.getId());
        cookie.setMaxAge(60*60);
        cookie.setPath("/hello");
        response.addCookie(cookie);
    }
}
