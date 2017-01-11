package collection;

import java.util.*;

/**
 * Created by Administrator on 2016/12/27.
 */
public class MapDemo {
    public static void main(String[] args) {
        Map map=new HashMap();  //HashMap实现Map的一种方式
        map.put(1,"haha");
        map.put(2,"hanmeimei");
        map.put(3,"lilei");

        map.put(1,"Jack");//重新赋值，会覆盖之前的值

        System.out.println(map);
        System.out.println(map.get(2)); //获取键值是2 键所对应的值：hanmeimei
        //一
        Set s=map.keySet();  //keySet 返回键，那这里就是将键存放在set接口中，然后采用迭代器打印出来
        Iterator i=s.iterator();
        while (i.hasNext()){
            System.out.println(i.next());   //获取所有的键
        }
        Iterator i1=s.iterator();
        while (i1.hasNext()){
            System.out.println(map.get(i1.next())); //获取所有键所对应的值
        }

        //hashmap遍历二
        Set<Map.Entry> set1=map.entrySet();   //返回的是一种映射关系
        Iterator<Map.Entry> ite2=set1.iterator();
        while (ite2.hasNext()){
            Map.Entry entry=(Map.Entry)ite2.next();
//            int key=(int)entry.getKey();
//            String value=(String)entry.getValue();
            System.out.println(entry.getKey()+":"+entry.getValue());
        }

        //hashmap遍历三
        Map<Integer,String> m =new HashMap<Integer,String>();
        m.put(1,"hhhh");
        m.put(2,"kkkk");
        m.put(3,"yyyy");
        for(Map.Entry<Integer,String> entry:m.entrySet()){
            System.out.println(entry.getKey()+"="+entry.getValue());
        }






    }
}
