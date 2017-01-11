package TPshopProject;

import TPshopData.TPshopExcelData;
import menthod.CheckPointUtils;
import menthod.ReportUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.util.Map;

/**
 * Created by zmy on 2017/1/10.   TPshop项目的登录页面测试
 */

public class TPshopLoginTest {

    Page page;
    WebDriver driver;
    WebElement username;
    WebElement passwd;
    WebElement loginbutton;

    CheckPointUtils check=new CheckPointUtils();
    ReportUtils report=new ReportUtils();

    //测试前准备工作，打开浏览器，打开登录页面
    @BeforeTest
    public void LoginBefore(){
        page=new Page(1);
        driver=page.getDriver();
        try {
            page.getKeyMap("TPshopData\\TPshopLogin.yaml");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        page.openWeb("http://127.0.0.1/index.php/Admin/Admin/login");
        page.pause(1000);
    }

    //测试后的环境清理工作，关闭页面
    @AfterTest
    public void LoginAfter(){
        page.pause(2000);
        page.closeWeb();
    }

    //测试用例
    @Test(dataProvider = "dps",dataProviderClass = TPshopExcelData.class)
    public void LoginTest(Map<String,Object> map){
        //输入用户名密码，点击登录
        username=page.findElement("Login_userName");
        username.clear();
        username.sendKeys(map.get("userName").toString());

        passwd=page.findElement("Login_passwd");
        passwd.clear();
        passwd.sendKeys(map.get("passWord").toString());

        loginbutton=page.findElement("Login_Loginbutton");
        loginbutton.click();

        page.pause(2000);

        //获取文本值,断言
        if(map.get("caseID").equals("3")==false) {
            String errortext=page.findElement("Login_errormsg").getText();
            page.findElement("Login_acception").click();

            report.debug("检查登录");
            check.checkString(errortext, map.get("预期结果").toString());
            page.pause(4000);
        }
        else {
            String title=driver.getTitle();
            report.debug("检查登录");
            check.checkString(title, map.get("预期结果").toString());
            page.pause(2000);
        }
    }

}
