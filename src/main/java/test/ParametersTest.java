package test;

import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2016/12/26.
 */
public class ParametersTest {
    @Test
    //第一种: testng.xml 方式使代码和测试数据分离，方便维护
    @Parameters("str")
    public void testAdd(String str) {

        Assert.assertEquals("TestNG is working fine", str);
    }

    @Parameters({"str2","age"})
    //提供了默认值，如果xml里没有传参数那么就会输出默认的值，如果xml有传参数就输出xml给的参数
    public void testsub(@Optional ("hahaha") String str2,int age){
        System.out.println(str2+age);
    }
}
