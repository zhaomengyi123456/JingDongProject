package collection;

import java.util.*;

/**
 * Created by Administrator on 2016/12/29.
 *
 * 1.将1-100之间的所有正整数放在List集合中，并将索引值是10的元素从集合中移除
 * 2.分别向Set集合和List集合中加入：A ，a，c, C ,a  观察重复值a是否能在Set集合和List集合中成功添加
 * 3.创建Map集合，创建Emp对象，并将创建的Emp对象添加到Map集合中去（Emp对象的id作为Map集合的键），并将id为005的
 * 对象从集合中移除
 */
public class CollectionP2 {

    public static void main(String[] args) {
//        List<Integer> list=new ArrayList<Integer>();
//        for(int i=1;i<=100;i++){
//                list.add(i);
//        }
//        System.out.println(list);
//        list.remove(10);
//        System.out.println(list);

//        //set集合无序，元素不能重复
//        Set<String> set=new HashSet<String>();
//        set.add("A");
//        set.add("a");
//        set.add("c");
//        set.add("C");
//        set.add("a");
//        System.out.println(set);
//
//        //list集合有序，元素能重复
//        List<String> list=new ArrayList<String>();
//        list.add("A");
//        list.add("a");
//        list.add("c");
//        list.add("C");
//        list.add("a");
//        System.out.println(list);

        //声明三个对象
        stu zhao=new stu("001","zhao1","12");
        stu li=new stu("002","lisi","12");
        stu wang=new stu("005","wangwu","12");

        //加入map集合中
        Map<String ,String> map=new HashMap();
        map.put(zhao.id,"001 zhao1 12");
        map.put(li.id,"002 lisi 12");
        map.put(wang.id,"005 wangwu 12");

        //用下标的形式遍历，可以获取键值，获取每个键所对应的值，及移除某个对象
        Set set1=map.keySet();
        Iterator i=set1.iterator();
        while (i.hasNext()){
            //System.out.println(i.next());
            //System.out.println(map.get(i.next()));
            if(i.next()=="005"){
                map.remove("005");
            }
        }

        //用entrySet的方式遍历，移除某个元素
//        Set<Map.Entry<String,String>> set3=map.entrySet();
//        Iterator<Map.Entry<String,String>> i3=set3.iterator();
//        while (i3.hasNext()){
//            Map.Entry<String, String> entry=i3.next();
//            if(entry.getKey()=="005"){
//                map.remove("005");
//            }
//        }

        //entrySet的方式遍历，获取键及对应的值
        Set<Map.Entry<String, String>> set2=map.entrySet();
        Iterator<Map.Entry<String,String>> i2=set2.iterator();
        while (i2.hasNext()){
            Map.Entry<String, String> entry=i2.next();
            System.out.println(entry.getKey()+":"+entry.getValue());
        }




    }
}
class stu{
    String id=null;
    String name=null;
    String age=null;
    public stu(String id,String name,String age){
        this.id=id;
        this.name=name;
        this.age=age;
    }
}
