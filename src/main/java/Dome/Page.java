package Dome;

import menthod.WebElementUtils;
import org.openqa.selenium.By;


import java.io.IOException;

/**
 * Created by Administrator on 2016/12/22.
 */
public class Page extends WebElementUtils {
    public Page(int driverType) {
        super(driverType);
    }

    public static void main(String[] args)  {
        Page page=new Page(1);
        page.openWeb("http://www.baidu.com");
        try {
            page.fE_input(By.cssSelector("#kw"), "zhihu");
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            page.fE_click(By.cssSelector("#su"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            page.input(page.findE(By.cssSelector("#kw")),"haha");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            page.fE_click(By.cssSelector("#su"));
        } catch (IOException e) {
            e.printStackTrace();
        }

//        JavascriptExecutor js=(JavascriptExecutor)page;// 为啥这里的page不行呢
//        js.executeScript("window.open(\"http://www.baidu.com\")");
        page.openNewWindow("window.open(\"http://www.baidu.com\");");
        page.switchTo_window(1);

        try {
            page.fE_input(By.cssSelector("#kw"),"selenium");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            page.fE_click(By.cssSelector("#su"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        page.gunDT();

    }


}
