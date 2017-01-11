package test;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2016/12/24.
 */
public class testngDemo1 {
    @Test
    public void testAdd() {
        String str = "TestNG is working fine";
        Assert.assertEquals("TestNG is working fine", str);//断言语句  可以判断相等 也可以判断不相等
    }
}
