package Dome;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2016/12/20.
 * 窗口之间的跳转   句柄
 */
public class SwitchToHandle {
    public static void main(String[] args) throws IOException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        //第一个：打开百度网址并搜索
        driver.get("http://www.baidu.com");
        driver.findElement(By.cssSelector("#kw")).sendKeys("zhihu");
        driver.findElement(By.cssSelector("#su")).click();

        //我想看看此窗口的句柄是什么样的，获取并打印
        System.out.println(driver.getWindowHandle());

        //第二个窗口：我想在另外的窗口中搜索东西但不覆盖原来的窗口，调用js的方法
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.open(\"http://www.baidu.com\")");
        //
        File screenShotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShotFile,new File("F://test1.png"));


        //第三个窗口：同样的方法再开一个窗口
        JavascriptExecutor js1=(JavascriptExecutor)driver;
        js1.executeScript("window.open(\"http://www.baidu.com\")");

        //虽然开了三个窗口，但如果现在输入搜索的关键字还是会在第一个窗口中输入，所以这里进行了窗口的跳转！！然后再输入搜索的内容
//        String nowhandle=driver.getWindowHandle();
//        for(String handles:driver.getWindowHandles()){
//            if(handles.equals(nowhandle))
//                continue;
//                driver.switchTo().window(handles);
//        }


        //这也是一种窗口跳转方法   很简便  将获取的句柄存放到list中  然后按下标来跳转
        Set<String> handles=driver.getWindowHandles();
        List<String> listhandles=new ArrayList<String>(handles);
        driver.switchTo().window(listhandles.get(1));

        //第二个里面输入
        driver.findElement(By.cssSelector("#kw")).sendKeys("taobao");
        driver.findElement(By.cssSelector("#su")).click();

        //这里打印的就是第二次打开的窗口的句柄
        System.out.println(driver.getWindowHandle());

        //此时driver在第二个窗口，我想在第三次打开的窗口中搜索也需要跳转！！！
//        String nowhandle2=driver.getWindowHandle();
//        for(String handles:driver.getWindowHandles()){
//            if(handles.equals(nowhandle2))
//                continue;
//            driver.switchTo().window(handles);
//        }


        //driver.switchTo().window(listhandles.get(2));


        //第三个里面输入
//        driver.findElement(By.cssSelector("#kw")).sendKeys("hello");
//        driver.findElement(By.cssSelector("#su")).click();

        //这里打印的是第三次打开的窗口的句柄
        System.out.println(driver.getWindowHandle());

        //driver.switchTo().window(nowhandle);//这样就又调回到了第一个窗口
    }
}
