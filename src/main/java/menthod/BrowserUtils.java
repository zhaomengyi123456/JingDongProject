package menthod;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/12/22.
 */
public class BrowserUtils extends Browser {



    public BrowserUtils(int driverType) {
        super(driverType);

    }

    //获取Driver
    public WebDriver getDriver(){
        return driver;
    }

    //打开网页
    public void openWeb(String url){
        pause(500);
        try {
            driver.get(url);
            System.out.println("打开【"+url+"】");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("打开【"+url+"】失败");
        }

    }

    //后退
    public void  back(){
        pausex(1);
        driver.navigate().back();
    }

    //前进
    public void forword(){
        pausex(1);
        driver.navigate().forward();
    }

    //关闭
    public void closeWeb(){
        driver.close();
        System.out.println("关闭当前页面");
    }

    //固定等待时间
    public void pause(long milliseconds){
        if(milliseconds<=0) {
            System.out.println("时间异常");
            return;
        }
         try {
             //异常处理
             Thread.sleep(milliseconds);
         }catch (InterruptedException e){
             System.out.println("时间出错了");
             e.printStackTrace();
         }
    }

    //隐示等待时间
    public void pausex(int seconds){
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    //隐式等待时间
//    public void pause()

    //获取当前路径
    public String getCurrentUrl() throws IOException {
        pausex(1);
        String CurrentUrl =null;
        try {
             CurrentUrl = driver.getCurrentUrl();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("获取路径失败");
            sshot("F:\\photoes","currenturl.png");
        }
        return CurrentUrl;
    }

    //  切换窗口 方法1
    public WebDriver switchTo_window(String windowHandle){
        pausex(1);
        WebDriver driver=null;
        try {
            driver = this.driver.switchTo().window(windowHandle);
            System.out.println("页面跳转");
        }catch (NoSuchWindowException e){
            e.printStackTrace();
            System.out.println("页面跳转失败");
        }
        return driver;
    }

    //窗口跳转   方法2
    public void switchTo_window(){
        pausex(2);
        String nowhandle=driver.getWindowHandle();
        for(String handles:driver.getWindowHandles()){
            if(handles.equals(nowhandle))
                continue;
            try {
                driver.switchTo().window(handles);
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("跳转失败");
            }
        }
    }

    //窗口跳转   方法3
    public void switchTo_window(int windowindex){
        pausex(2);
        Set<String> handles=driver.getWindowHandles();
        List<String> handle=new ArrayList<String >(handles);
        try {
            driver.switchTo().window(handle.get(windowindex));
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("跳转失败");
        }
    }

    //获取标题
    public String gTitle(){
        return driver.getTitle();
    }


    //刷新
    public void refresh(){
        pausex(1);
        try {
            driver.navigate().refresh();
            System.out.println("刷新");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("刷新失败");
        }

    }

    //利用js方法新开一个页面
    public void openNewWindow(String url){
        pausex(1);
        JavascriptExecutor js=(JavascriptExecutor)driver;
        try {
            js.executeScript(url);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("新窗口打开失败");
        }
    }

    //截图
    protected void sshot(String strPicPath,String picName) throws IOException {
        //picName=picName.replace("/","_").replace("\\","_");
        File picFile=new File(strPicPath+picName+".png");
        //实现截图
        File source_file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(source_file, new File("F:\\photoes\\1.png"));
        }catch (IOException e){
            System.out.println("截图失败");
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        BrowserUtils browserUtils=new BrowserUtils(1);
//
//        try {
//            browserUtils.sshot("F:\\photoes","2.png");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//    }



}
