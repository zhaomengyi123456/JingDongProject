package Dome;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.security.Key;

/**
 * Created by Administrator on 2016/12/19.
 */
public class Dome1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.baidu.com");
        driver.findElement(By.cssSelector("#kw")).sendKeys("haha");
        //层级定位
        //driver.findElement(By.xpath("//*[@id='form']/span/*[@id='kw']")).sendKeys("女神");
        //driver.findElement(By.xpath("//*[@id='form']//*[@id='kw']")).sendKeys("女神");
        driver.findElement(By.cssSelector("#su")).click();
        Thread.sleep(2000);
//        driver.navigate().back();
//        driver.findElement(By.cssSelector("#kw")).sendKeys("taobao");
//        driver.findElement(By.cssSelector("#su")).click();
//        System.out.println(driver.getTitle());
//        Thread.sleep(1000);
        //想新开一个窗口
//        Actions action=new Actions(driver);
//        action.keyDown(Keys.CONTROL).sendKeys("T").keyUp(Keys.CONTROL).perform();
//        Thread.sleep(2000);
//        driver.get("http://www.taobao.com");

        JavascriptExecutor js=(JavascriptExecutor)driver;
        //在当前窗口新开一个，覆盖
        //js.executeScript("window.location.href=\"http://www.baidu.com\";");
        //另外新开一个窗口
        js.executeScript("window.open(\"http://www.baidu.com\");");


        //driver.quit();
        //driver.findElement(By.xpath("//input[ends-with(@name,'')]"));


    }
}
