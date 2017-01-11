package JingDongProject;

import Data.JDData;
import menthod.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Administrator on 2017/1/5.
 * <p>
 * 执行京东登录的6条用例
 */
public class JDLoginPage {
    Page page;
    WebElement username;
    WebElement passwd;
    WebElement submit;
    WebElement autologin;
//public JDLoginPage(Page page){
//    this.page=page;
//}

    private WebDriver driver;
    private YamlUtils yaml = new YamlUtils();
    private HashMap<String, HashMap<String, String>> keymap;
    //能这样将页面的元素都放在一个类里面  然后在另一个测试类里面对其进行操作吗  方便吗
    //LoginPage u=new LoginPage();

    ReportUtils report = new ReportUtils();
    CheckPointUtils check = new CheckPointUtils();

//    //获取yaml文件中的值
//    public void getKeyMap(String yamlFile) throws FileNotFoundException {
//        this.keymap = yaml.getYamlData(yamlFile);
//    }
//
//    //根据yaml中的key值，定位元素
//    public WebElement findElement(String elementName) {
//        String type = keymap.get(elementName).get("type");
//        String value = keymap.get(elementName).get("value");
//        return driver.findElement(yaml.getBy(type, value));
//    }

    @BeforeTest
    public void before() throws IOException {
       page = new Page(1);
        //driver要赋值
        driver = page.getDriver();
        //获取参数
        page.getKeyMap("Data\\JDProject.yaml");

        //这种不是type  value 对的怎么参数分离？还是说不需要分离   时间参数呢
        page.openWeb("https://passport.jd.com/new/login.aspx?ReturnUrl=https%3A%2F%2Fwww.jd.com%2F");
        page.pause(3000);
        page.findElement("Login_before").click();
    }

    @AfterTest
    public void after() {
        page.pause(2000);
        page.closeWeb();
    }

    @Test(dataProvider = "beforetestf", dataProviderClass = JDData.class, priority = 0)
    public void loginTest(Map<String, Object> map) throws IOException {

        //用户名 密码输入，自动登录框选择，登录按钮点击
        username = page.findElement("Login_userName");
        username.clear();
        username.sendKeys(map.get("username").toString());

        passwd = page.findElement("Login_passwd");
        passwd.clear();
        passwd.sendKeys(map.get("password").toString());

        autologin = page.findElement("Login_autoLogin");
        autologin.click();

        submit = page.findElement("Login_submit");
        submit.click();
        page.pause(1000);

        //断言
        if (map.get("caseid").equals("6") == false) {

            //输入不正确的状态
            WebElement errormsg = page.findElement("Login_errormsg");
            String errormsgText = errormsg.getText();
            //Assert.assertEquals(errormsgText, map.get("预期结果"));

            //直接调用error()方法
            report.debug("用户名或密码输入错误");

            check.checkString(errormsgText, map.get("预期结果").toString());
            page.pause(1000);

        } else {
            //输入正确的状态
//            username = findElement("Login_userName");
//            username.clear();
//            username.sendKeys(map.get("username").toString());
//
//            passwd = findElement("Login_passwd");
//            passwd.clear();
//            passwd.sendKeys(map.get("password").toString());
//
//            autologin = findElement("Login_autoLogin");
//            autologin.click();
//            submit = findElement("Login_submit");
//            submit.click();
            //断言
            //输入正确的状态
            String title = page.gTitle();

            //断言出错后面的当然就不会执行了，所有就没有下面的信息打印
            //Assert.assertEquals(title, map.get("预期结果"));

            report.debug("用户名和密码输入正确");
            check.checkString(title, map.get("预期结果").toString());
            page.pause(1000);

        }
//        //return new JDSettingPage(driver);
//        /*如果我返回一个JDSettingPage类的driver，那么怎么确定次driver是统一的 ，需要页面（页面类）的继承吗 ，如设置页面继承登录页面
//         *如果我只执行模块：设置个人信息 怎么进入这个页面呢 （登录页面并没有执行，也就是没有登录啊），需要用什么文件吗
//         *如果我想要一个业务流程：登录--选购商品--买单.... 怎么将这些联系起来呢
//         *
//         * 依赖关系？？
//         *
//         */
    }
}
