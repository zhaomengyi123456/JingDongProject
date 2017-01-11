package Dome;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by Administrator on 2016/12/19.
 * 更改禅道的主题   个人档案
 */
public class Dome3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://127.0.0.1/zentaopro.php");
        driver.findElement(By.xpath("//a[text()='专业版']")).click();

        //登录
        driver.findElement(By.cssSelector("#account")).sendKeys("admin");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[text()='登录']")).click();

        //点击我的地盘
        //driver.findElement(By.xpath(".//*[@id='mainmenu']/ul/li[1]/a/span")).click();

        //选择主题
        driver.findElement(By.cssSelector("a[href='javascript:;']")).click();
        //定位到了主题元素
//        WebElement el=driver.findElement(By.xpath("//a[text()='主题']"));
//        Actions action=new Actions(driver);
//        System.out.println(el.getLocation());//获取元素的坐标
//        action.moveToElement(el).clickAndHold().perform();//不写clickAndHold()也可以
//        Thread.sleep(2000);

        //这种方法是用键盘控制的方式
        //action.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        //action.release();

        //将鼠标移动，以当前元素作为基准点，x轴为负则是向左移动，y轴为负向上移动
        //action.moveToElement(el,-100,55).click().perform();
        //action.release();

        //难道用这种方法定位不到吗，后记：即使是灰色也能定位到的，只是方法问题
        //el.findElement(By.xpath("//a[text()='红色']")).click();
//        Thread.sleep(1000);
//        action.moveToElement(el2).click().perform();
        //action.release().perform();

       //JavascriptExecutor js=(JavascriptExecutor)driver;//这个方法不报错，但无法点击.难道是定位错了吗
        //String myjs="document.getElementsByClassName('theme-option')[2].click();";
        //String myjs="$('#el>ul>li[2]').click();";
        //js.executeScript("$('#el>ul>li[2]').click();",el);


        //这里是个人档案
        driver.findElement(By.xpath("//a[text()='个人档案']")).click();
        //点击后会弹出一个界面  在iframe
        driver.switchTo().frame("modalIframe");
        driver.findElement(By.xpath("//a[text()='修改档案']")).click();
        //点击后会弹出修改的界面
        //真实姓名
        WebElement realname=driver.findElement(By.xpath("//input[@id='realname']"));
        realname.clear();
        realname.sendKeys("admin");
        //邮箱
        WebElement email=driver.findElement(By.xpath("//input[@id='email']"));
        email.clear();
        email.sendKeys("459086368@qq.com");
        //选择性别
        boolean nv=driver.findElement(By.xpath("//input[@id='genderf']")).isSelected();
        if(nv==false) driver.findElement(By.xpath("//input[@id='genderf']")).click();
        //输入生日
        WebElement birthday=driver.findElement(By.cssSelector("#birthday"));
        birthday.clear();
        birthday.sendKeys("1990-12-09");

        //WebElement account=driver.findElement(By.cssSelector("#account"));

        //account.sendKeys("admin");
        //源代码账号
        WebElement commiter=driver.findElement(By.cssSelector("#commiter"));
        commiter.clear();
        commiter.sendKeys("admin");
        //密码
        WebElement password1=driver.findElement(By.cssSelector("#password1"));
        password1.clear();
        password1.sendKeys("123456");
        //重新输入密码
        WebElement password2=driver.findElement(By.cssSelector("#password2"));
        password2.clear();
        password2.sendKeys("123456");
        //请输入你的密码
        driver.findElement(By.cssSelector("#verifyPassword")).sendKeys("123456");
        //保存
        driver.findElement(By.cssSelector("#submit")).click();

        //保存后会回到第一次弹出的界面
        //因为关闭的按钮不在iframe里面  所有我先跳出  再关闭
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//button[@class='close']")).click();

        //跳出关闭后 我想看看是不是成功  所有点击了一下产品
        driver.findElement(By.xpath("//a[@href='/pro/product/']")).click();



    }
}
