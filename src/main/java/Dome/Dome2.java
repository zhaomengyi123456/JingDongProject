package Dome;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Administrator on 2016/12/19.
 * 删除一条bug记录
 */
public class Dome2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://127.0.0.1/zentaopro.php");
        driver.findElement(By.xpath("//a[text()='专业版']")).click();
        //选择语言
        driver.findElement(By.xpath(".//*[@id='langs']/button")).click();
        driver.findElement(By.xpath("//a[text()='简体']")).click();
        //登录
        driver.findElement(By.cssSelector("#account")).sendKeys("admin");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[text()='登录']")).click();

        //点击关于，然后关闭
        driver.findElement(By.xpath("//a[text()='关于']")).click();
        Thread.sleep(2000);
        driver.findElement(By.className("close")).click();
        Thread.sleep(2000);

        //进入测试模块
        driver.findElement(By.xpath("//a[contains(@href,'/pro/qa/')]")).click();

        //进入bug模块
        Thread.sleep(1000);
        driver.findElement(By.linkText("Bug")).click();
        //选择产品名称
        driver.findElement(By.xpath("//a[@id='currentItem']/span")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("a[href='/pro/bug-browse-1.html']")).click();
        //选择一个bug
        driver.findElement(By.xpath("//a[text()='001']")).click();
        driver.findElement(By.cssSelector("a[title='删除']")).click();

        //弹出框的处理
        Alert confirm=driver.switchTo().alert();
        confirm.accept();

    }
}
