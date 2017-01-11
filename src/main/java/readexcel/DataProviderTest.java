package readexcel;

import menthod.WebElementUtils;
import menthod.YamlUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import menthod.ExcelUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/26.
 */
public class DataProviderTest {
//    @DataProvider(name="student")//这里是固定的必须写name，不能些其他的，，其实这里也可以不写name的，，那么下面用的时候就用方法名
//    public Object[][] Students(){
//
//        return new Object[][] {{"zhangsan","23"},{"lisi","32"},{"haha","23"}};
//
//    }
//    @Test(dataProvider="student")
//    public void Dstudents(String name,String age){
//        System.out.println("name "+name+" "+"age "+age);
 //   }
  WebElementUtils page;
//    YamlUtils yaml;
//    //HashMap<String,HashMap<String,String>> keymap;

    @BeforeMethod
    public void open() throws FileNotFoundException {
        //准备数据
        //page.getKeyMap("ZentaoData.yaml");
        page=new WebElementUtils(1);
        //yaml=new YamlUtils(page.getDriver());//执行测试时这里也会执行多次，多次调用这个类，所以不合理。
        page.openWeb("http://127.0.0.1/pro/user-login.html");
        page.pause(3000);
    }
    @AfterMethod
    public void close(){
        page.pause(3000);
        page.closeWeb();
    }

    @DataProvider(name="dpz")
    public Iterator<Object[]> beforetestz() throws IOException {
        //匿名对象  Utils肯定是个迭代器，在构建这个迭代器类的对象的时候，迭代器就会自动调用next hasnext方法将数据源的数据放入迭代器
        return new ExcelUtils("readexcel.xlsx","Sheet3");
    }
    @DataProvider(name="dpf")
    //我的封装的Utils类中继承了Iterator接口，所以我的Utils类也是一个迭代器了，里面放的是一个数组，数组内放的是map
    public Iterator<Object[]> beforetestf() throws IOException {
        //匿名对象
        return new ExcelUtils("readexcel.xlsx","Sheet5");
    }

    @Test(dataProvider = "dpz",priority = 0)
    //返回的Object[]数组内放的是一个map 所有我这里就用一个map来接收
    public void test1(Map<String,Object> map) throws IOException {
        page.fE_input(By.id("account"),map.get("userName"));
        page.fE_input(By.name("password"),map.get("passWord"));
        page.fE_click(By.id("submit"));
        //page.findElement("Login_account").sendKeys(map.get("userName").toString());
        page.pause(3000);
        Assert.assertEquals(page.gTitle(),map.get("预期结果"));
    }

    @Test(dataProvider = "dpf",priority = 1)
    public void test2(Map<String,Object> map) throws IOException {

        page.fE_input(By.id("account"),map.get("userName"));
        page.fE_input(By.name("password"),map.get("passWord"));
        page.fE_click(By.id("submit"));
        page.pause(3000);
        Alert alert= page.getDriver().switchTo().alert();
        String alerttext=alert.getText();
        alert.accept();
        Assert.assertEquals(alerttext,map.get("预期结果"));
    }

}
