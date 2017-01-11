package Dome;//import org.apache.bcel.generic.Select; //这里是我写下拉框时自动导入的，，但语法不是我想要的
import org.apache.bcel.generic.Visitor;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select; //下拉框导入

import javax.swing.*;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * Created by Administrator on 2016/12/16.
 * 此处是运用自动化定位元素的方法提一条bug
         */
public class OpenZentao {
    public static void main(String[] args) throws InterruptedException, IOException {

        //System.setProperty("webdriver.firefox.bin","D:\\Program Files\\firefox\\firefox.exe");
        //WebDriver driver=new FirefoxDriver();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();//窗口最大化
        //driver.manage().timeouts().implicitlyWait(7000, TimeUnit.MILLISECONDS);
        Thread.sleep(2000);
        String url="http://127.0.0.1/zentaopro.php";
        driver.get(url);
        driver.navigate().to(url);
        Thread.sleep(2000);
        WebElement element=driver.findElement(By.id("zentaopro"));
        element.click();
        Thread.sleep(2000);
        WebElement username=driver.findElement(By.id("account"));
        //username.click();
        username.sendKeys("admin");
        Thread.sleep(1000);
        WebElement pw=driver.findElement(By.name("password"));
        //pw.click();
        pw.sendKeys("123456");
        driver.findElement(By.id("submit")).click();
        Thread.sleep(2000);
        //点击测试
        driver.findElement(By.linkText("测试")).click();
        //driver.findElement(By.xpath(".//*[@id='mainmenu']/ul/li[4]/a")).click();

//        driver.findElement(By.xpath(".//*[@id='currentItem']/span")).click();
//        driver.findElement(By.cssSelector("a[href='/pro/bug-browse-1.html']")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Bug")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("提Bug")).click();
        //driver.findElement(By.xpath(".//*[@id='featurebar']/div[1]/div[2]/a[2]")).click();


        //下拉框,上面导入的位置出现了问题，从别的例子那里复制了一个过来并注释掉了另一个
//        Select selectProduct= new Select(driver.findElement(By.xpath(".//*[@id='product_chosen']")));
//        selectProduct.selectByValue("T0305");
//
//        Select selectModule= new Select(driver.findElement(By.xpath(".//*[@id='module_chosen']")));
//        selectModule.selectByValue("/班级学生成绩管理");
//
//        Select selectProject=new Select(driver.findElement(By.xpath(".//*[@id='project_chosen']/div/div/input")));
//        selectProject.selectByValue("T0305");
//         driver.findElement(By.cssSelector("div[@id='product_chosen']")).click();
//        driver.findElement(By.cssSelector("span[@id='module_chosen']")).sendKeys("/班级学生成绩管理");
        //所属产品
        driver.findElement(By.xpath(".//*[@id='product_chosen']/a/div/b")).click();
        driver.findElement(By.xpath("//li[text()='T0305']")).click();
        Thread.sleep(2000);
        //所属模块
        driver.findElement(By.xpath(".//*[@id='module_chosen']/a/div/b")).click();
        driver.findElement(By.xpath(".//li[text()='/班级学生成绩管理']")).click();
        Thread.sleep(1000);
        //所属项目
        driver.findElement(By.xpath(".//*[@id='project_chosen']/a/div/b")).click();
        driver.findElement(By.xpath(".//*[@id='project_chosen']/div/ul/li")).click();
        Thread.sleep(1000);
        //影响版本
        driver.findElement(By.xpath(".//*[@id='openedBuild_chosen']/ul")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(".//*[@id='openedBuild_chosen']/div/ul/li")).click();
        //当前指派
        driver.findElement(By.xpath(".//*[@id='assignedTo_chosen']/a/div/b")).click();
        driver.findElement(By.xpath(".//*[@id='assignedTo_chosen']/div/ul/li[2]")).click();
        //缺陷类型
        Select selecttype=new Select(driver.findElement(By.cssSelector("#type")));
        Thread.sleep(500);
        selecttype.selectByVisibleText("设计缺陷");
        //操作系统
        Select selectos=new Select(driver.findElement(By.cssSelector("#os")));
        Thread.sleep(500);
        selectos.selectByVisibleText("Windows 7");
        //浏览器版本
        Select selectbrowser=new Select(driver.findElement(By.cssSelector("#browser")));
        Thread.sleep(500);
        selectbrowser.selectByVisibleText("chrome");
        //选择标题颜色，写bug标题
        driver.findElement(By.xpath(".//*[@id='dataform']/table/tbody/tr[5]/td/div[2]/div[1]/div/div/button")).click();
        driver.findElement(By.xpath(".//*[@id='dataform']/table/tbody/tr[5]/td/div[2]/div[1]/div/div/ul/li[1]/a")).click();
        Thread.sleep(500);
        driver.findElement(By.cssSelector("#title")).sendKeys("【学生成绩模块】不能同时删除多条学生信息");
        Thread.sleep(1000);
        //严重程度
        driver.findElement(By.xpath(".//*[@id='dataform']/table/tbody/tr[5]/td/div[2]/div[2]/div/div[1]/button")).click();
        driver.findElement(By.xpath(".//*[@id='dataform']/table/tbody/tr[5]/td/div[2]/div[2]/div/div[1]/ul/li[3]/a/span")).click();
        //优先级
        driver.findElement(By.xpath(".//*[@id='dataform']/table/tbody/tr[5]/td/div[2]/div[2]/div/div[2]/button")).click();
        driver.findElement(By.xpath(".//*[@id='dataform']/table/tbody/tr[5]/td/div[2]/div[2]/div/div[2]/ul/li[2]/a/span")).click();

        //步骤重现，在iframe里，要有switchTo()方式跳转进入iframe模块
        WebElement frame=driver.findElement(By.xpath("//form/table/tbody/tr[6]/td/div[2]/div[2]/iframe"));
        driver.switchTo().frame(frame);
        //这里的定位都有效
        driver.findElement(By.xpath("//p[text()='[步骤]']")).click();
        Actions action=new Actions(driver);
        Thread.sleep(2000);
        action.sendKeys(Keys.ENTER).perform();
        action.sendKeys("1.选中多条学生信息（例如：学号为38、39、40）").perform();
        Thread.sleep(1000);
        action.sendKeys(Keys.ENTER).perform();
        action.sendKeys("2.点击删除记录").perform();
        Thread.sleep(1000);
        action.sendKeys(Keys.ENTER).perform();
        action.sendKeys("3.点击确定").perform();
        Thread.sleep(1000);
        //调用js控制滚动条
        JavascriptExecutor JS=(JavascriptExecutor) driver;
        String high="scroll(0,10000)";
        JS.executeScript(high);
        Thread.sleep(1000);

        driver.findElement(By.xpath("//p[text()='[结果]']")).click();
        action.sendKeys(Keys.ENTER).perform();
        action.sendKeys("不可以同时选择多条学生信息").perform();
        Thread.sleep(1000);
        //调用js控制滚动条
        JavascriptExecutor JS1=(JavascriptExecutor) driver;
        String high1="scroll(0,10000)";
        JS.executeScript(high1);
        Thread.sleep(1000);

        driver.findElement(By.xpath("//p[text()='[期望]']")).click();
        action.sendKeys(Keys.ENTER).perform();
        action.sendKeys("可以同时选择多条学生信息并删除").perform();
        driver.switchTo().defaultContent();

        //用标签名定位一组p，然后放在列表中    没有做出来
       // List<WebElement> ps=driver.findElements(By.tagName("p"));
//       for(WebElement p:ps){
//           System.out.println(p.getText());
//           // Thread.sleep(2000);
//            //p.click();
//            //p.sendKeys("不可以同时选择多条学生信");
//       }
//        ps.get(0).click();    //这里我觉得就不太好用控制滚动条的方式来做了，因为上面的我是定位的单个元素，这里定位的一组
//        //Thread.sleep(2000);
//        Actions action=new Actions(driver);
//        action.sendKeys(Keys.ENTER).perform();
//        action.sendKeys("1.选中多条学生信息（例如：学号为38、39、40）").perform();
//        Thread.sleep(1000);
//        action.sendKeys(Keys.ENTER).perform();
//        action.sendKeys("2.点击删除记录").perform();
//        Thread.sleep(1000);
//        action.sendKeys(Keys.ENTER).perform();
//        action.sendKeys("3.点击确定").perform();
//        Thread.sleep(2000);
//        //ps.get(1).click();
//        Actions action1=new Actions(driver);
//        action1.sendKeys(Keys.ENTER).perform();
//        action1.sendKeys("不可以选中多条学生信息").perform();
//        Thread.sleep(2000);
//        //ps.get(2).click();
//        Actions action2=new Actions(driver);
//        action2.sendKeys(Keys.ENTER).perform();
//        action2.sendKeys("可以删除选中的多条学生信息").perform();
//        driver.switchTo().defaultContent();

        //调用js控制滚动条
        JavascriptExecutor JS2=(JavascriptExecutor) driver;
        String high2="scroll(0,10000)";
        JS.executeScript(high2);
        Thread.sleep(500);

            //抄送给谁
        driver.findElement(By.cssSelector("input[value='选择要发信通知的用户...']")).click();
        driver.findElement(By.xpath(".//*[@id='mailto_chosen']/div/ul/li[1]")).click();
            //维护列表
//        driver.findElement(By.xpath(".//*[@id='contactListGroup']/span/a[1]/i")).click();
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/iframe"));
//        driver.switchTo().frame(frame);

        // 弹出的窗口
        //定位不到这个元素
//        driver.findElement(By.xpath(".//*[@id='newList']")).click();
//        System.out.println("hello");
//        action.sendKeys("很随便的名字").perform();
//        driver.findElement(By.xpath(".//*[@id='users_chosen']/ul")).click();
//        driver.findElement(By.xpath("//text()='赵六'"));
//        driver.switchTo().defaultContent();

        //附件
        driver.findElement(By.xpath("//input[@class='fileControl']")).click();
        //driver.findElement(By.xpath("//input[@class='fileControl']")).sendKeys("E:\\新梦想\\测试项目\\小美出行需求文档.docx");
        Thread.sleep(3000);
        Runtime.getRuntime().exec("F:\\upload2.exe");
        //Runtime.getRuntime().exec("F:\\upload.exe");
        Thread.sleep(4000);
        //保存提交,如果写submit 就不用将滚动条下拉，但如果写click就必须让被点击的对象出现在屏幕内，否则就点击不到它
        driver.findElement(By.cssSelector("#submit")).click();




    }
}
