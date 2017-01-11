package collection;

import java.util.*;

/**
 * Created by Administrator on 2016/12/29.
 * 1) 创建一个List，在List 中增加三个工人，基本信息如下：
 姓名 年龄 工资
 zhang3 18 3000
 li4 25 3500
 wang5 22 3200
 2) 在li4 之前插入一个工人，信息为：姓名：zhao6，年龄：24，工资3300
 3) 删除wang5 的信息
 4) 利用for 循环遍历，打印List 中所有工人的信息
 5) 利用迭代遍历，对List 中所有的工人调用work 方法。
 6) 为Worker 类重写equals 方法，当姓名、年龄、工资全部相等时候才返回true
8. （Set，Hash 算法）在前面的Worker 类基础上，为Worker 类增加相应的方法，使得
 //        Worker放入HashSet 中时，Set 中没有重复元素。
 //        并编写相应的测试代码。

 */
public class WorkerList {
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
    public static boolean equal(List list1, List list2){
       Iterator i=list2.iterator();
       boolean t=true;
        while (i.hasNext()) {
            if (list1.equals(i.next())) {
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
        List li1=new ArrayList();
        li1.add("zhangsan");
        li1.add("18");
        li1.add("67890");

        List li2=new ArrayList();
        li2.add("lisi");
        li2.add("20");
        li2.add("11000");

        List li3=new ArrayList();
        li3.add("zhaoliu");
        li3.add("20");
        li3.add("31000");

        List li4=new ArrayList();
        li4.add("yindi");
        li4.add("18");
        li4.add("300000");

        //将几个list放到一个大的list中，注意此时的list要是List类型，不要用addAll的方法
        List<List> li=new ArrayList();
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
        List li5=new ArrayList();
        li5.add("lisi");
        li5.add("203");
        li5.add("11000");

        //调用equals方法
        if(equal(li,li5)==false){
            li.add(li5);
        }
        Set set=new HashSet();
        set.addAll(li);
        System.out.println(set);

    }

}


