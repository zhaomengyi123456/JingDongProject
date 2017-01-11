package Dome;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Administrator on 2016/12/21.
 */
public class Release {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://127.0.0.1/zentaopro.php");
        WebElement element=driver.findElement(By.id("zentaopro"));
        element.click();
        Thread.sleep(1000);
        //登录
        driver.findElement(By.id("account")).sendKeys("admin");
        Thread.sleep(1000);
        driver.findElement(By.name("password")).sendKeys("123456");
        driver.findElement(By.id("submit")).click();
        //点击产品
        driver.findElement(By.xpath("//a[text()='产品']")).click();
        //点击发布


    }
}
