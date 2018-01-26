package CookieAndSession.Bean;

public class User {

    //这部分是获取session部分的域：1。 先获取到user对象（需要强转类型） 2. 然后在获取数据
  //现在是通过脚本的方式来获取，request域的数据-
//通过脚本获取application域中的list对象：1. 先获取到list集合 2. 在获取list对象的下标 3. 在取到对象的值
    private  String name;
    private  String age;
    private  String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }




}
