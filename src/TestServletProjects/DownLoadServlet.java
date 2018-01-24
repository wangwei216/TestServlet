package TestServletProjects;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/*
需要用到的知识点：
    1.  response.getWriter(); //字节码文件,如文本
        response.getOutputStream();//这个是专门传输二进制文件如：MP3，MP4，图片
    2. IO 文件流的拷贝
        a，先定一个实际的接收长度
        b。new一个缓冲数组 （如果是字符流就用char类型的数组，要是字节流的话就用byte类型的数组）
        c。循环读取输入流的文件
        d。用输出流 把文件读取出来
    3. 怎么获取绝对路径 this.getServletContext().getRealPath(filename);
    4. 如何设置直接让浏览器下载，而不是浏览
        a.告知浏览器文件的类型
            response.setContentType(文件的mime类型);
        b。告知浏览器文件的打开方式是下载
            response.setHeader("Content-Disposion","attachment;filename:"+ 前面都是固定的只有这个部分是文件名);
复习知识点：
 getInitParameter(String name) 获取name名称的初始化参数的值
 getResourceAsStream(String path) 输入流的形式返回path对应的资源，path参数必须以“/”
 getInitParameterNames() 获取所有初始化参数的名称，返回的结果是一个枚举值
 getRequestDispatcher(String name) 根据转发的地址获取 RequestDispatcher对象
 setAttribute() 设置属性值 getAttributeNames() 获取所有属性值名称


一、 如何从服务器上吧资源返回给浏览器
    1. 先写出一个输出流，然后new一个输入流
    2. 从浏览器中返回的参数名的值用getParameter，再去用ServletContext()获得真实的绝对路径
    3. 把输入流中的对象拷贝到输出流中（文件的拷贝）
    4. 关闭手动new出来的文件流
*
* */
@WebServlet(name = "DownLoadServlet",urlPatterns = "/download")
public class DownLoadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//不添加这部分代码的话，服务器只是会把能解析出来的文件格式解析出来展示出来，并不会去直接下载该文件
// 如果想要告诉浏览器直接下载下来，而不是浏览的话需要
        String filename= request.getParameter("filename");
        // 告知浏览器文件的类型
        String mimeType= this.getServletContext().getMimeType(filename);
        response.setContentType(mimeType);
        //告知浏览器文件的打开方式是下载
        response.setHeader("Content-Disposion","attachment;filename:"+filename);

//获取绝对路径
        String realPath= this.getServletContext().getRealPath(filename);
        InputStream in= new FileInputStream(realPath);//参数是一个目标源文件的绝对路径
        ServletOutputStream outputStream = response.getOutputStream();

        //文件流的拷贝
        int len=0;
        byte[] flush=new byte[1024];
        while(-1!=(len=in.read(flush))){
            outputStream.write(
                    flush,0, len
            );
        }
        in.close();
    }
}
