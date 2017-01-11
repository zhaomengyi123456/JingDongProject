package menthod;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/12/21.
 */
public class MenthodFZ {

    public WebElement element;
    WebDriver driver=new ChromeDriver();

//        public WebDriver driver;
//    public FzDemo(){
//        this.driver=driver;
//    }

    //打开指定的路径  窗口最大化
    public void openBrowser(String url){

        driver.manage().window().maximize();
        driver.get(url);

    }
    //用xpath定位 并返回元素
    public WebElement findElement(String by){
        element= driver.findElement(By.xpath(by));
        return element;
    }

    public void sendKey(By by,String value){

        System.out.println(driver.getTitle());
        driver.findElement(by).sendKeys(value);
    }

    public void click(By by){
        driver.findElement(by).click();
    }

    public String getText(){
        return element.getText();
    }

    public void pause(int i){
        driver.manage().timeouts().implicitlyWait(i, TimeUnit.SECONDS);
    }







}
