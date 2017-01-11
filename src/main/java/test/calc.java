package test;

/**
 * Created by Administrator on 2016/12/24.
 */
public class calc {
    public int add(int a,int b){
        return a+b;
    }
    public int sub(int a,int b){
        return a-b;
    }
    public int mul(int a,int b){
        return a*b;
    }
    public int chu(int a,int b){
        if(b==0){
            System.out.println("除数不能为零");
            return b;
        }
        else
            return a/b;
    }
}
