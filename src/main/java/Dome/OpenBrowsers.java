package Dome;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import java.io.File;
/**
 * Created by Administrator on 2016/12/15.
 */
public class OpenBrowsers {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.baidu.com");

    }


}
