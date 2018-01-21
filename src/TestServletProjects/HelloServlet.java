package TestServletProjects;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/*
* 一、 如果需要获取servlet的配置的信息，就需要用到servConfig对象
*       1.常见的servletConfig对象的方法有getInitParameter(string name); 返回的是一个初始化的值
*       2. 这个是getInitParameterNames() ,返回的是servlet初始化参数的所有名称
*       3. getServletContext() 获取ServletContext的对象
*       4. getServletName（） 获取servlet的Name配置值
* */

public class HelloServlet extends HttpServlet{

    @Override
    public void init() throws ServletException {
        super.init();
        ServletConfig servletConfig= this.getServletConfig();
        String encoding = servletConfig.getInitParameter("encoding");
        System.out.println("encoding的字符串是："+ encoding);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("这是接受一个doGet的请求");
        System.out.println("URL"+request.getRequestURI());
        System.out.println("请求方式"+ request.getMethod());
        System.out.println("发出请求的客户端IP地址0"+request.getRemoteAddr());
        System.out.println("服务点接受请求的IP地址"+request.getLocalAddr());
        System.out.println("访问客户端的端口号"+request.getRemotePort());
        System.out.println("web应用路径："+request.getContextPath());
        System.out.println("http协议和版本"+request.getProtocol());

        Enumeration<String > headerNames = request.getHeaderNames();
            while (headerNames.hasMoreElements()){
                    String element = headerNames.nextElement();
                System.out.println(element+":"+request.getHeader(element));
            }
            //获取请求参数
        String name = request.getParameter("name");
        String passWord = request.getParameter("passWord");
        System.out.println("用户名："+name);
        System.out.println("密码："+passWord);

        String result ="恭喜你登录成功";
//        这个是设置一个字符编码集
        response.setContentType("text/html;charset=utf-8");
//        ServletOutputStream outputStream= response.getOutputStream();
//       outputStream.write(result.getBytes());
        //当你类似创建一个对象的时候，直接先把方法写出赖之后，直接使用快捷键Alt+Enter 就可以自动补全前面的代码
        PrintWriter writer = response.getWriter();
        writer.write(result);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("这是post一个dopost请求");
    }
}
