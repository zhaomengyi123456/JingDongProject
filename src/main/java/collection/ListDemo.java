package collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2016/12/26.
 */
public class ListDemo {
    public static void main(String[] args) {

        //list接口继承与collection，是有序集合可重复，每个值都有对应的索引

        List li=new ArrayList();//new一个ArrayList（数组队列）的对象
        li.add("xiaoming");    //add有返回值：Boolean 告诉你你的操作有没有成功
        li.add("haha");
        li.add("Jack");

        li.set(2,"hanhan");   //替换下标为2 的元素
        li.add(1,"Tom");//在1的位置插入一个


        List li2=new ArrayList();
        li2.add("qq");
        li2.add("qq");
        li2.add("qq");
        System.out.println(li2);
        li.addAll(li2);    //这样写就是加在该list的最后面
        System.out.println(li);

        li.addAll(1,li2);  //指定某个特定的位置，就会把

        //list是有序集合，默认按添加顺序排列下标
        System.out.println(li);
        System.out.println(li.get(2));
        //通过for循环来获取集合中的每一个值
//        for(int i=0;i<li.size();i++){
//            System.out.println(li.get(i));//通过下标获取每一个值
//        }

        //用迭代器的方式遍历   hasNext()判断当前位置的下一个位置是否有值  next（）返回下一个位置的值
//        Iterator i=li.iterator();
//        while (i.hasNext())
//            System.out.println(i.next());


        Object[] array= li.toArray();
        System.out.println(array[0]);
    }
}
