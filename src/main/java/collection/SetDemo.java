package collection;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Administrator on 2016/12/26.
 */
public class SetDemo {
    public static void main(String[] args) {

        //最多只能存放一个null值
//        Set s=new HashSet();   //treeset  会自动排序，按hashCode值来排序，如果存放的元素不能排序则会报错
//        s.add("Ass");
//        s.add("Yyy");
//        s.add("Ukk");
//        s.add("Ass");
//        s.add("Ukk");
//        System.out.println(s);   //不能重复  ，所以重复的两个就没有打印出来了

        Set s=new TreeSet();
        s.add("Ass");
        s.add("Yyy");
        s.add("Ukk");
        s.add("Ass");
        s.add("Ukk");
        System.out.println(s);


        //其实也是按hashCode值来排序，但不同于treeset的是，它同时还用链表来维护数据，所以看起来像是按录入的顺序排序的
//        Set s=new LinkedHashSet();
//        s.add("Ass");
//        s.add("Yyy");
//        s.add("Ukk");
//        s.add("Ass");
//        s.add("Ukk");
//        System.out.println(s);



    }
}
