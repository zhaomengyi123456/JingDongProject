package Dome;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import menthod.*;
import org.openqa.selenium.WebElement;

/**
 * Created by Administrator on 2016/12/21.
 */
public class FzDemo extends MenthodFZ{


    public static void main(String[] args) {

        FzDemo wd=new FzDemo();
        wd.openBrowser("http://www.baidu.com");
        WebElement el=wd.findElement("//input[@id='su']");

        System.out.println(wd.getText());

        wd.pause(2);

        wd.sendKey(By.xpath("//input[@id='kw']"),"zhihu");

        wd.click(By.xpath("//input[@id='su']"));



    }


}
