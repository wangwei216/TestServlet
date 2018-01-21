package TestServletProjects;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/*
一、做好的准备
* 1. 先添加一个urlPatterns的映射
* 2. 用BufferedImage类创建一个不带透明色的BufferedImage对象
* 3. ImageIO.write(BufferedImage image,String format,OutputStream out);方法可以很好的解决问题；
        参数image表示获得的BufferedImage；
        参数format表示图片的格式，比如“gif”等；
        参数out表示输出流，如果要转成Byte数组，则输出流为ByteArrayOutputStream即可
* 4. 然后用矩形框进行填充这个偷瞄的图片对象
*
   二、 下一步是随机生成不同的字符或者数字验证码
        1. 需要提供一个字符串的数据集,还需要new一个random对象
        2. 用随机函数去获得期中的任意一个元素(用random的时候返回的必须要是一个整数，而且用nextInt（）方法的时候参数是你要随机的元素总和)
        3. 然后用subString(开始的位置，截取的结束的位置)方法去把每个要随机出来的字符给提取出来
        4，把随机得到的四个字符用drawString给写上去

*/
@WebServlet(name = "VerifyCodeServlet",urlPatterns = "/code")
public class VerifyCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            int  width=100;
            int  height=30;

        String date="abcdefghijklmnopqruxyz0123456789";
        Random random =new Random();

        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
//得到一个绘图对象
        Graphics graphics=image.getGraphics();
        graphics.setColor(Color.gray);
        graphics.fillRect(0,0,width,height);

      graphics.setColor(Color.black);
//      用for循环生成4个字符

        for(int i=0;i<4;i++){

              int position = random.nextInt(date.length());
              String randomStr= date.substring(position,position+1);

            graphics.drawString(randomStr, width / 5 * (i + 1), 15);
        }

         ImageIO.write(image, "jpg", response.getOutputStream());
    }
}
