package Dome;//import org.apache.bcel.generic.Select;
import org.apache.bcel.generic.Visitor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;

/**
 * Created by Administrator on 2016/12/20.
 * 测试需求，可以加一条测试计划（本项目没有测试计划的前提下）
 *
 */
public class Demand {
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
        //进入需求
        driver.findElement(By.xpath("//a[text()='产品']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(".//*[@id='modulemenu']/ul/li[2]/a")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(".//*[@id='featurebar']/div[1]/div[2]/a[2]")).click();
        //所属产品
        driver.findElement(By.xpath(".//*[@id='product_chosen']/a/div/b")).click();
        driver.findElement(By.xpath("//li[text()='T0305']")).click();
        //所属模块
        Thread.sleep(1000);
        driver.findElement(By.xpath(".//*[@id='module_chosen']/a/div/b")).click();
        driver.findElement(By.xpath("//li[text()='/班级学生成绩管理']")).click();

        //所属计划
        //点击“创建计划”，打开一个新的窗口
        driver.findElement(By.xpath("//a[@href='/pro/productplan-create-1-0.html']")).click();
        //System.out.println(driver.getWindowHandle());

        //窗口的跳转
        String handle=driver.getWindowHandle();
        for(String handles:driver.getWindowHandles()){
            if(handle.equals(handles))
                continue;
            driver.switchTo().window(handles);
        }
        //System.out.println(driver.getWindowHandle());
        Thread.sleep(2000);

        //现在在创建计划窗口了
        //名称
        driver.findElement(By.xpath("//input[@id='title']")).sendKeys("T0305测试计划");
        //开始日期
        driver.findElement(By.xpath("//input[@id='begin']")).sendKeys("2016-12-12");
        //结束日期
        driver.findElement(By.xpath("//input[@id='end']")).sendKeys("2016-12-30");
        //描述iframe
        WebElement frame=driver.findElement(By.xpath("//iframe[@class='ke-edit-iframe']"));
        driver.switchTo().frame(frame);
        driver.findElement(By.xpath("//body[@class='article-content']")).sendKeys("我们要按时完成哦");
        driver.switchTo().defaultContent();
        //保存
        driver.findElement(By.xpath("//button[@id='submit']")).click();
        //关闭当前窗口
        driver.close();

        //一定要重新调回我主要的编辑窗口！！！！是关闭窗口后再跳转回来的
        driver.switchTo().window(handle);

        //先要刷新一下
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[text()='刷新']")).click();

        Thread.sleep(1000);
        //选择所属计划
        driver.findElement(By.xpath(".//*[@id='plan_chosen']/a/div/b")).click();
        driver.findElement(By.xpath("//li[text()='T0305测试计划 [2016-12-12 ~ 2016-12-30]']")).click();

        //需求来源选择
        Select selectsource=new Select(driver.findElement(By.cssSelector("#source")));
        selectsource.selectByVisibleText("产品经理");
        driver.findElement(By.cssSelector("#sourceNote")).sendKeys("也有来自客户的相关需求");

        //由谁评审     这里需要判断那个框框是否被选中了   注意：要定位的是那个小的选择框而不是后面的文字  因为那个文字始终的没有被选中的
        WebElement checkbox=driver.findElement(By.xpath("//input[@id='needNotReview']"));
        boolean bo=checkbox.isSelected();
        //System.out.println(bo);
        if(bo){
            checkbox.click();
        }
        driver.findElement(By.xpath(".//*[@id='assignedTo_chosen']/a/div/b")).click();
        driver.findElement(By.xpath("//li[text()='A:admin']")).click();

        //需求名称
        driver.findElement(By.cssSelector("#title")).sendKeys("能一次选择多条学生信息并删除");
        //优先级
        driver.findElement(By.xpath("//button[@class='btn dropdown-toggle br-0']")).click();
        driver.findElement(By.xpath("//div[@class='input-group']/div/ul/li[3]")).click();
        //预计
        driver.findElement(By.xpath("//input[@id='estimate']")).sendKeys("1/3");

        //需求描述iframe
        WebElement frame1=driver.findElement(By.xpath("//table[@class='table table-form']//tr[5]//iframe"));
        driver.switchTo().frame(frame1);
        driver.findElement(By.xpath("//body[@class='article-content']")).sendKeys("1.能够同时选择多条学生信息；\n2.能将同时选择的多条学生信息删除");
        driver.switchTo().defaultContent();

        //验收标准iframe
        WebElement frame2=driver.findElement(By.xpath("//table[@class='table table-form']//tr[6]//iframe"));
        driver.switchTo().frame(frame2);
        driver.findElement(By.xpath("//body[@class='article-content']")).sendKeys("实际结果和预期结果一致");
        driver.switchTo().defaultContent();

        //保存
        driver.findElement(By.cssSelector("#submit")).submit();

    }
}
