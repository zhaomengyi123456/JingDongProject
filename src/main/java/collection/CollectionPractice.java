package collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2016/12/29.
 */
public class CollectionPractice {

    public static void main(String[] args) {
        //声明三个工人，实例化
        worker zhang3=new worker("zhang3","18","999");
        worker li4=new worker("li4","39","8999");
        worker wang5=new worker("wang5","23","7899");

        //将list集合定义成worker类型的，并用ArrayList类实例化对象，将三个工人加入集合中
        List<worker> list=new ArrayList<worker>();
        list.add(zhang3);
        list.add(li4);
        list.add(wang5);

        //重新在li4的位置插入一个工人
        list.add(1,new worker("zhao6","33","88888"));

        //运用for循环的方式遍历集合，并调用printf（）方法打印每个工人信息
        for(int i=0;i<list.size();i++){
            list.get(i).printf();
        }

        //用迭代器的方法遍历集合，并调用work（）方法，最好是在实例化迭代器的同时就指明类型，此处是worker类型
        Iterator<worker> ite=list.iterator();
        while (ite.hasNext()){
            ite.next().work();
        }

        //实例化对象zhao   有迭代器的方式遍历list集合，并调用equals（）方法，比较zhao这个对象的信息是否与list集合中的工人信息相同
        worker zhao=new worker("zhao6","33","88888");
        Iterator<worker> ite2= list.iterator();
        while (ite2.hasNext()){
            zhao.equals(ite2.next());
        }



    }

}

class worker{
    String name=null;
    String age=null;
    String salary=null;
    //worker类的构造方法
    public  worker(String name,String age,String salary){
        this.name=name;
        this.age=age;
        this.salary=salary;
    }
    public  void work(){
        System.out.println("we are working");
    }
    public  void printf(){
        System.out.println("-----------------");
        System.out.println("姓名 "+"年龄 "+"工资");
        System.out.println(name+" "+age+" "+salary);
    }

    public boolean equals(worker worker){
        if(this.name.equals(worker.name)){
            if(this.age.equals(worker.age)){
                if(this.salary.equals(worker.salary)){
                    System.out.println("相同的姓名，年龄，工资");
                    return true;
                }else {
                    System.out.println("工资不同");
                    return false;
                }
            }else {
                System.out.println("年龄不同");
                return false;
            }
        }else {
            System.out.println("姓名不同");
            return false;
        }

    }


}