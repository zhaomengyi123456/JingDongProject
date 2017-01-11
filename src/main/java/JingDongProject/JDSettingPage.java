package JingDongProject;

import menthod.WebElementUtils;
import menthod.YamlUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.util.Map;

/**
 * Created by Administrator on 2017/1/6.
 */
public class JDSettingPage {

    WebElementUtils page;
    WebDriver driver;
    YamlUtils yaml=new YamlUtils(driver);

//    public JDSettingPage(WebDriver driver) {
//        this.driver=driver;
//    }


    @BeforeTest
    public void beforeSet() throws FileNotFoundException {
        //启动浏览器，获取元素数据，driver赋值统一
        page=new WebElementUtils(1);
        page.getKeyMap("JDProject.yaml");
        driver=page.getDriver();
        page.openWeb("https://order.jd.com/center/list.action");
        page.pause(2000);

        //点击账户设置  个人信息
        page.findElement("Setting_accountSet").click();
        page.pause(1000);
        page.findElement("Setting_pInfo").click();

    }
    @Test
    public void SettingTest(Map<String,Object> map){

        page.findElement("Setting_sex").click();


    }

}
