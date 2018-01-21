package TestServletProjects;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TestMap {

    public static void  main(String [] args){
        Map  <String,String >list = new HashMap();
        list.put("王伟","1号");
        list.put("葛豪","2号");
        list.put("孙超","3号");
        Iterator iterator= list.keySet().iterator();
        while (iterator.hasNext()){
               String string=(String) iterator.next();
            System.out.println(list.get(string));
        }

    }
}
