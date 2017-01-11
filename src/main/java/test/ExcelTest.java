package test;

import menthod.WebElementUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import readexcel.ExcelUtil;
import readexcel.userInfo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/27.
 */
public class ExcelTest {
    WebElementUtils page;
    @BeforeMethod
    public void open(){
        page=new WebElementUtils(1);
        page.openWeb("http:\\www.baidu.com");
        page.pause(2000);
    }
    @Test(dataProvider = "dps")
    public void test1(userInfo u) throws IOException {
//        System.out.println(u.getUsername());
//        System.out.println(u.getPasswd());

//
        page.fE_input(By.xpath("//input[@id='kw']"),u.getUsername());
        page.fE_click(By.cssSelector("#su"));
        String str=page.gTitle();

        Assert.assertEquals(str,u.getUsername()+"百度一下");
    }
    @AfterMethod
    public void close(){
        page.pause(3000);
        page.closeWeb();
    }
    @DataProvider
    public Object[][] dps() throws IOException {
        HashMap<String, userInfo> usermap= ExcelUtil.read_xls("F:\\readexcel.xlsx","Sheet1");
        Object[][] obj=new Object[usermap.size()][];
        int i=0;
        for(Map.Entry<String,userInfo> um:usermap.entrySet()){
            obj[i++]=new Object[]{um.getValue()};
        }
        return obj;
    }

}
