package CookieAndSession.Cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
一、 如何记录客户端浏览器第一次访问服务器的时间，并且在第二次访问服务器的时候再返回给那个客户端浏览器：
 第一步只是把访问时间的数据cookie 响应给了浏览器
    1. 首先先new出来一个cookie，然后name命名成time，value需要用一个变量保存你需要的那个时间
    2. 再需要new一个Date对象来保存你需要的那个字符串，  然后在new一个dateFormate对象，来格式化时间对象
    3. 定一个字符串来保存data 用simpleDateFormat.format(date);
    4. 在通过添加getCookie（cookie）方法 然后通过服务器的response响应给浏览器

 第二步就是获取客户端传向服务器的cookie数据
    1. 先用getCookies()方法返回的cookie数组给保存给cookies
    2. 遍历Cookies数组
    3. 需要提取cookie1（这个是客户端第二次访问服务器的时候携带的cookie1），跟第一次保存的那个time 进行比较 看是不是相等
    4. 若相等的话就是提取出cookie1的getValue（）, 同时创建一个字符串的timeValue的变量置位NULL（进行判断这个是第一次访问服务器还是第二次访问的）
*
最后一步是实心cookie的持久化，就需要用到    cookie.setMaxAge(60*60*24);
    1. 因为你如果不设置的话系统是自己默认当你关闭这次会话的时候（也就是关闭整个浏览器窗口的时候）直接自动销毁上一次的所有cookie数据
*
*
* */
@WebServlet(name = "TimeServlet", urlPatterns = "/time")
public class TimeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//第一步只是把访问时间的数据cookie 响应给了浏览器
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd-hh:mm:ss");
            String time = simpleDateFormat.format(date);
          Cookie cookie= new Cookie("time",time);
          cookie.setMaxAge(60*60*24);//这个里面的时间单位都是以秒为单位的
          response.addCookie(cookie);
//第二步就是获取客户端传向服务器的cookie数据
        /*因为 服务器响应浏览器的时候没有设置编码格式 会乱码，下面设置*/
        response.setContentType("text/html;charset=utf-8");
       String timeValue = null;
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie1 : cookies) {
            if(cookie1.getName().equals("time")) {
                timeValue = cookie1.getValue();
            }
        }
        if(timeValue==null){
            response.getWriter().write("欢迎你第一次访问我们的网站");
        }
        else {
            response.getWriter().write("你上次访问网站的时间是"+timeValue);
        }
    }
}
