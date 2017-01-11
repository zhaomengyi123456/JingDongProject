/**
 * Created by Administrator on 2016/12/15.
 */

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class open {
    public static void main(String[] args) throws InterruptedException, IOException {
       //打开默认路径
        //WebDriver driver = new ChromeDriver();

        //打开指定路径下的firefox，方法1
        System.setProperty("webdriver.firefox.bin","D:\\Program Files\\firefox\\firefox.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.baidu.com");

//        //打开指定路径下的firefox，方法2
//        File pathToFirefoxBinary=new File("D:\\Program Files\\firefox\\firefox.exe");
//        FirefoxBinary firefoxbin=new FirefoxBinary(pathToFirefoxBinary);
//        WebDriver driver1=new FirefoxDriver(firefoxbin,null);

//        //打开具体的url
//        String url="http://www.163mail.com";
//        WebDriver driver1=new FirefoxDriver();
//        driver1.get(url);
//        driver1.navigate().to(url);
        //浏览器最大化
        driver.manage().window().maximize();
        //刷新页面
        driver.navigate().refresh();

        //获取标题和当前路径，并打印
        String title=driver.getTitle();
        String url=driver.getCurrentUrl();
        System.out.println(title+url);
        System.out.println(driver.getTitle()+driver.getCurrentUrl());
        //等待时间
        Thread.sleep(1000);
        WebElement element=driver.findElement(By.id("kw"));
        element.sendKeys("淘宝");
       // WebElement searchbutton=driver.findElement(By.id("su"));
        //submit表单提交，会自动找提交的位置
        element.submit();

        //等待页面加载完毕，超时时间为9秒
        (new WebDriverWait(driver,9)).until (new ExpectedCondition<Boolean>(){
            public Boolean apply(WebDriver d){
                return d.getTitle().toLowerCase().startsWith("淘宝");
            }
        });

        System.out.println("the page title:"+driver.getTitle());
//        //页面后退
//        driver.navigate().back();
//        //页面前进
//        driver.navigate().forward();

        //截图，要new一个文件对象,FileUtils导入包是注意，他自动导入的包内没有copyFile的方法，要自己去导入另外一个
        File screenShotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShotFile,new File("F://test.png"));

        //driver.quit();//关闭整个浏览器。为啥关闭火狐时浏览器会报错呢，谷歌就可以
        //driver.close();//关闭当前页面。为啥火狐窗口没关闭啊，谷歌的就可以关闭
    }
}
