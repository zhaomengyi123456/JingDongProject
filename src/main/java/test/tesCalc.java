package test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2016/12/24.
 */
public class tesCalc {
    calc ca=new calc();//这里是实例化了的   如果的静态的方法就不需要实例化了
    @Test
    public void add(){   //这就是一个用例
        Assert.assertEquals(ca.add(2,3),5);
    }
    @Test(enabled = false)//忽略测试用例不执行
    public void add2(){   //这就是一个用例
        Assert.assertEquals(ca.add(28,3),31);
    }
    @Test
    public void sub(){
        Assert.assertEquals(ca.sub(2,3),-1);
    }
    @Test
    public void mul(){
        Assert.assertEquals(ca.mul(2,3),6);
    }
    @Test
    public void chu(){
        Assert.assertEquals(ca.chu(20,5),4);
    }
    @BeforeMethod
    public void bmethod(){
        System.out.println("wo shi method");
    }
    @AfterMethod
    public void amethod(){
        System.out.println("wo ye shi method");
    }
}
