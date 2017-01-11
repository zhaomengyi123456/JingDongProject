package menthod;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;

/**
 * Created by Administrator on 2016/12/22.
 */
public class Browser {

    static WebDriver driver;


    //构造方法 实际上是用来初始化
    public Browser(int driverType){
        switch (driverType){
            case 1:
                setupChrome();break;
            case 2:
                setupFirefox();break;
                default:
                    setupChrome();
        }
    }
    private void browsermaximize(){
        driver.manage().window().maximize();
    }
    private void setupFirefox(){
        System.setProperty("webdriver.firefox.bin","D:\\Program Files\\firefox\\firefox.exe");
        driver=new FirefoxDriver();
        browsermaximize();
        System.out.println("启动Firefox浏览器");//这里就是埋点  方便检查 查看执行顺序
    }

    private void setupChrome(){
        driver=new ChromeDriver();
        browsermaximize();
    }




}
