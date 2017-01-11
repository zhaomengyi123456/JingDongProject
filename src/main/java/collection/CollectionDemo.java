package collection;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by Administrator on 2016/12/26.
 */
public class CollectionDemo {
    public static void main(String[] args) {
//        //new一个集合的对象
//        Collection li=new HashSet();
//        //集合可以存放数量不等的不同数据类型的数据
//        li.add("Jack");
//        li.add(18);
//        li.add(9.9);
//        //将这个集合打印出来
//        System.out.println(li);
//        Iterator i=li.iterator();//迭代器，用来遍历集合
//        while (i.hasNext()){
//            String a=i.next().toString();//用变量来存储集合中的值，都转换为string类型
//            System.out.println(a);
//            if(a.equals("9.9")){//如果a的值为9.9时就将它移除
//                i.remove();
//            }
//        }
//        System.out.println(li);//此时打印出来的集合就没有9.9了


        Collection schools=new HashSet();
        schools.add("湖南农大");
        schools.add("湖南师大");
        schools.add("湖南医大");

        //这里是采用迭代器的方式遍历集合
        Iterator i=schools.iterator();
        while (i.hasNext()){
            String school=(String)i.next();
            if(school.equals("湖南医大")){
                i.remove();
            }
        }
        System.out.println(schools);


        //这里采用的是for循环的方式遍历集合
        String[] str=(String[]) schools.toArray(new String[0]);
        for(String s:str){
            System.out.println(s);
        }
    }
}
