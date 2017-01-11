package menthod;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.NoSuchElementException;

/**
 * Created by Administrator on 2016/12/22.
 */
public class WebElementUtils extends BrowserUtils{

    public YamlUtils yaml=new YamlUtils(driver);
    private HashMap<String,HashMap<String,String>> keymap=null;

    public WebElementUtils(int driverType) {
        super(driverType);
    }

    //通过某种方式定位元素并返回
    public WebElement findE(By by) throws IOException {
        pausex(1);
        WebElement element=null;//要设置为全局变量，并初始化
        try{
             element=driver.findElement(by);
            System.out.println("找到了你想要的元素");//进入catch后这句就不执行了
        }catch (NoSuchElementException e){
            e.printStackTrace();
            System.out.println("没有找到元素");//埋点
            //没找到可以截图
            sshot("F:\\photoes","element.png");
        }

        return element;
    }

    //获取yaml文件中的值
    public void getKeyMap(String yamlFile) throws FileNotFoundException {
        keymap=yaml.getYamlData(yamlFile);
    }


    //根据yaml中的key值，定位元素
    public WebElement findElement(String elementName){
        String type=keymap.get(elementName).get("type");
        String value=keymap.get(elementName).get("value");
        return driver.findElement(yaml.getBy(type,value));

    }



    //清空
    public void clear(By by){
        try{
            findE(by).clear();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //输入内容
    public void fE_input(By by,Object text) throws IOException {
        pausex(1);
        clear(by);
        //先判断一下if
        if(text==null || text.equals("")){
            System.out.println("参数text为空，不做输入");
            return;
        }
        WebElement element=findE(by);//这一部分已经try了一次了，就不需要写到里面了
        try{
            element.sendKeys(text.toString());
        }catch (Exception e){
            e.printStackTrace();
            //截图
            sshot("F:\\photoes","text.png");
        }

    }

    //根据WebElement来输入
    protected void input(WebElement element,Object text) throws IOException {
        pausex(1);
        element.clear();
        //先判断一下if
        if(text==null || text.equals("")){
            System.out.println("参数text为空，不做输入");
            return;
        }
        try{
            element.sendKeys(text.toString());
        }catch (Exception e){
            e.printStackTrace();
            //截图
            sshot("F:\\photoes","element.png");
        }
    }

    //点击
    public void fE_click(By by) throws IOException {
        pausex(500);
        try {
            findE(by).click();
        }catch (NoSuchElementException e){
            e.printStackTrace();
            System.out.println("没有点击");

        }
    }




    //滚动条
    public void gunDT(){
        JavascriptExecutor js=(JavascriptExecutor)driver;
        try {
            js.executeScript("scrollTo(0,10000);");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("");
        }
    }

    //弹框接受
    public void click_Alert_Accept() throws IOException {
        pausex(1);
        Alert alert=driver.switchTo().alert();
        //String alerttext=alert.getText();
        try {
            alert.accept();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("没有点击到");
            sshot("F:\\photoes","element.png");
        }
    }

    //弹框取消
    public void Alert_click_dismiss() throws IOException {
        pausex(1);
        Alert alert=driver.switchTo().alert();
        try{
            alert.dismiss();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("没有点击到");
            sshot("F:\\photoes","element.png");
        }
    }

    //弹框输入后接受
    public void Alert_input(Object text) throws IOException {
        pausex(1);
        Alert alert=driver.switchTo().alert();
        if(text==null || text.equals("")){
            System.out.println("没有输入的内容");
        }
        try {
            alert.sendKeys(text.toString());
            alert.accept();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("输入或者点击接受错误了");
            sshot("F:\\photoes","alert.png");
        }
    }


    //获取getText()


    //select下拉框ByVisibleText
    public  void selectByVisibleText(By by,Object text) throws IOException {
        pausex(1);
        Select select= new Select(findE(by));
        try {
            select.selectByVisibleText(text.toString());
        }catch (NoSuchElementException e){
            e.printStackTrace();
            System.out.println("没有这样的选项");
            sshot("F:\\photoes","select.png");
        }
    }

    //select下拉框ByIndex
    public  void selectByIndex(By by,int index) throws IOException {
        pausex(1);
        Select select= new Select(findE(by));
        try {
            select.selectByIndex(index);
        }catch (NoSuchElementException e){
            e.printStackTrace();
            System.out.println("没有这样的选项");
            sshot("F:\\photoes","select.png");
        }
    }


    //select下拉框ByValue
    public  void selectByvalue(By by,String value) throws IOException {
        pausex(1);
        Select select= new Select(findE(by));
        try {
            select.selectByValue(value.toString());
        }catch (NoSuchElementException e){
            e.printStackTrace();
            System.out.println("没有这样的选项");
            sshot("F:\\photoes","select.png");
        }
    }

    //切换页面  可以写在webElementUtils

    //跳转frame
    public WebDriver switchTo_frame(WebElement frame){
        WebDriver driver=this.driver.switchTo().frame(frame);
        return driver;
    }

    public WebDriver switchTo_frame(int index){
        WebDriver driver=this.driver.switchTo().frame(index);
        return driver;
    }
    //跳出iframe
    public void switchTo_defaultc(){
        driver.switchTo().defaultContent();
    }



//    //跳转iframe
//    public void switchTo_frame(int index) {
//        driver.switchTo().frame(index);
//    }


    //错误的
//    public void sendKeys(String value){
//        WebElementUtils element=new WebElementUtils(1);
//        sendKeys(value);
//    }




}
