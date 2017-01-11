package JingDongProject;

import menthod.WebElementUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;
import readexcel.ExcelUtil;
import readexcel.userInfo;

import java.io.IOException;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/27.
 */
public class LoginTest {

    WebElementUtils page;

    @BeforeMethod
    public void open(ITestContext context) throws InterruptedException {
        page=new WebElementUtils(1);
        page.openWeb( context.getCurrentXmlTest().getParameter("url"));
       // page.pause(time);
        Thread.sleep(3000);
    }
    @AfterMethod
    public void close(ITestContext context) throws InterruptedException {
        //page.pause(context.getCurrentXmlTest().getTimeOut(2000));//时间的怎么做呢
        Thread.sleep(3000);
        page.closeWeb();
    }

    //@Parameters({"account","passwd","submit"})
    @Test(dataProvider = "dpsz",priority = 0)
    public void loginz(ITestContext context,userInfo u) throws IOException, InterruptedException {
        page.fE_input(By.id( context.getCurrentXmlTest().getParameter("account")),u.getUsername());
        page.fE_input(By.name( context.getCurrentXmlTest().getParameter("passwd")),u.getPasswd());
        page.fE_click(By.id( context.getCurrentXmlTest().getParameter("submit")));
        //page.pause( context.getCurrentXmlTest().getParameter("time").);
        Thread.sleep(3000);
        String str=page.gTitle();
            Assert.assertEquals(str, u.getResult());
    }
//    @Test(dataProvider = "dpsf",priority = 1)
//    public void loginf(userInfo u) throws IOException {
//        page.fE_input(By.id("account"),u.getUsername());
//        page.fE_input(By.name("password"),u.getPasswd());
//        page.fE_click(By.id("submit"));
//        page.pause(3000);
//        Alert alert= page.getDriver().switchTo().alert();
//        String alerttext=alert.getText();
//        alert.accept();
//        Assert.assertEquals(alerttext,u.getResult());
//    }

    @DataProvider
    public Object[][] dpsz() throws IOException {
        Map<String,userInfo> usermap= ExcelUtil.read_xls("F:\\readexcel.xlsx","Sheet1");
        Object[][] obj=new Object[usermap.size()][];
        int i=0;
        for(Map.Entry<String,userInfo> um:usermap.entrySet()){
            obj[i++]=new Object[]{um.getValue()};
        }
        return obj;
    }

//    @DataProvider
//    public Object[][] dpsf() throws IOException {
//        Map<String,userInfo> usermap= ExcelUtil.read_xls("F:\\readexcel.xlsx","Sheet4");
//        Object[][] obj=new Object[usermap.size()][];
//        int i=0;
//        for(Map.Entry<String,userInfo> um:usermap.entrySet()){
//            obj[i++]=new Object[]{um.getValue()};//直接实例化
//        }
//        return obj;
//    }



}
