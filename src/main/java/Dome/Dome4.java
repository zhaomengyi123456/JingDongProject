package Dome;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2016/12/21.
 */
public class Dome4 {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://www.baidu.com");
        driver.findElement(By.cssSelector("#kw")).sendKeys("zhihu");
        driver.findElement(By.cssSelector("#su")).click();
        //第二个
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.open(\"http://www.baidu.com\")");

//        String nowhandle=driver.getWindowHandle();
//        for(String handles:driver.getWindowHandles()){
//            if(handles.equals(nowhandle))
//                continue;
//            driver.switchTo().window(handles);
//        }
        Set<String> handles=driver.getWindowHandles();
        List<String> listhandles=new ArrayList<String>(handles);
        driver.switchTo().window(listhandles.get(1));

        driver.findElement(By.cssSelector("#kw")).sendKeys("zhihu");
        driver.findElement(By.cssSelector("#su")).click();

        JavascriptExecutor js1=(JavascriptExecutor)driver;
        js1.executeScript("scrollTo(0,100)");


    }
}
