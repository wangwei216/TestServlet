package CookieAndSession.JSP;

import CookieAndSession.Bean.Phone;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
一、实现商品列表的展示功能
    1. 创建一个phone类
    2. 实例化并且给每个手机对象赋值
    3. 创建一个list集合，把手机对象都放到list集合中
    4. 把数据存放到request域中，request.setAttribute("list",list);
    5. 把获取整理好的传送给已经写好的jsp界面
*
* */
@WebServlet(name = "PhoneListServlet",urlPatterns = "/phoneList")
public class PhoneListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Phone phone = new Phone();
        phone.setName("iphone");
        phone.setId(001);
        phone.setImage("https://img13.360buyimg.com/n7/jfs/t10675/253/1344769770/66891/92d54ca4/59df2e7fN86c99a27.jpg");
        phone.setPrice("8380");

        Phone phone1 = new Phone();
        phone1.setName("华为mate10");
        phone1.setId(002);
        phone1.setImage("https://img13.360buyimg.com/n7/jfs/t10378/8/1312059845/167702/38059e69/59ded53fNb2197f67.jpg");
        phone1.setPrice("3899");

        Phone phone2 = new Phone();
        phone2.setName("三星S8");
        phone2.setId(003);
        phone2.setImage("https://img14.360buyimg.com/n7/jfs/t4549/6/4532220459/272946/d0b72af9/59119ddbNd25bdd22.jpg");
        phone2.setPrice("4999");

        Phone phone3 = new Phone();
        phone3.setName("小米6");
        phone3.setId(004);
        phone3.setImage("https://img14.360buyimg.com/n7/jfs/t6877/59/884392847/111343/aef09cc5/597ae1b4N07915872.jpg");
        phone3.setPrice("2499");

        Phone phone4 = new Phone();
        phone4.setName("OPPO R11");
        phone4.setId(005);
        phone4.setImage("https://img14.360buyimg.com/n7/jfs/t16114/204/409277491/158880/efb04841/5a325d10N95cf06e5.jpg");
        phone4.setPrice("3199");

        Phone phone5 = new Phone();
        phone5.setName("一加5T");
        phone5.setId(006);
        phone5.setImage("https://img10.360buyimg.com/n7/jfs/t12859/355/1502498371/155178/f5e7e927/5a213b0aNcbdbb90a.jpg");
        phone5.setPrice("2999");

        List<Phone> list= new ArrayList<>();
        list.add(phone);
        list.add(phone1);
        list.add(phone2);
        list.add(phone3);
        list.add(phone4);
        list.add(phone5);
//下面这个需要填上你要转发的页面的路径

        request.setAttribute("list",list);
        request.getRequestDispatcher("/phone_list.jsp").forward(request,response);
    }
}
