package test;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by Administrator on 2016/12/25.
 */

public class GruopTest {
    calc ca;

    @BeforeSuite(groups={"testcase01","testcase02"})
    public void before(){
         ca=new calc();
    }

    @Test(groups="testcase01")
    public void add(){   //这就是一个用例
        Assert.assertEquals(ca.add(2,3),5);
    }
    @Test(enabled = false)//忽略测试用例不执行
    public void add2(){   //这就是一个用例
        Assert.assertEquals(ca.add(28,3),31);
    }
    @Test(groups="testcase01")
    public void sub(){
        Assert.assertEquals(ca.sub(2,3),-1);
    }
    @Test(groups="testcase01")
    public void mul(){
        Assert.assertEquals(ca.mul(2,3),6);
    }
    @Test(groups="testcase02")
    public void chu1(){
        Assert.assertEquals(ca.chu(20,5),4);
    }
    @Test(groups="testcase02")
    public void chu2(){
        Assert.assertEquals(ca.chu(20,0),0);
    }
}
