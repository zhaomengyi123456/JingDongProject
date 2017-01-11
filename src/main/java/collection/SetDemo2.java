package collection;

import java.util.*;

/**
 * Created by Administrator on 2016/12/29.
 */
public class SetDemo2 {
    //work方法
    public static void work(){
        System.out.println("we are working");
    }
    //打印的方法
    public static void printf(){
        System.out.println("-----------------");
        System.out.println("姓名 "+"年龄 "+"工资");
    }
    //equals方法
    public static boolean equal(Collection s1, Collection s2){
        Iterator i=s1.iterator();
        boolean t=true;
        while (i.hasNext()) {
            if (s2.equals(i.next())) {
                t=true;
                break;
            }
            else if(i.hasNext()){
                continue;
            }
            else {
                t=false;
            }
        }
        return t;
    }

    public static void main(String[] args) {
        Set li1=new HashSet();
        li1.add("zhangsan");
        li1.add("18");
        li1.add("67890");

        Set li2=new HashSet();
        li2.add("lisi");
        li2.add("20");
        li2.add("11000");

        Set li3=new HashSet();
        li3.add("zhaoliu");
        li3.add("20");
        li3.add("31000");

        Set li4=new HashSet();
        li4.add("yindi");
        li4.add("18");
        li4.add("300000");

        //将几个list放到一个大的list中，注意此时的list要是List类型，不要用addAll的方法
        Set<Set> li=new HashSet();
        li.add(li1);
        li.add(li2);
        li.add(li3);
        li.add(li4);
        System.out.println(li);

        //遍历
        Iterator ite=li.iterator();
        while (ite.hasNext()){
            printf();
            System.out.print(ite.next());
            System.out.print(" ");
            System.out.println();
            work();
        }
        //要比较的一个list
        Set li5=new HashSet();
        li5.add("lisi");
        li5.add("20");
        li5.add("11000");

        //调用equals方法
        System.out.println(equal(li,li5));
        if(equal(li,li5)==false){
            li.add(li5);
            System.out.println(li);
        }


    }

}
