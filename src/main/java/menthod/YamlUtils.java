package menthod;

import menthod.WebElementUtils;
import org.ho.yaml.Yaml;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

/**
 * Created by Administrator on 2017/1/5.
 * 1.创建yaml文件
 * 2.将yaml文件中的数据解析生成一个HashMap<String,HashMap<String ,String>>
 *
 * 3.将map中的type跟value赋值给By对象
 * 4.将By对象给findElement()方法
 *
 */
public class YamlUtils{
    //变量
    //Reporter report;
    WebDriver driver;
    final String filepath="D:\\idea\\IDEA\\zmy\\src\\main\\java\\";

    //构造方法
    public YamlUtils(WebDriver driver){
       this.driver=driver;
    }
    public YamlUtils(){

    }

    public HashMap<String,HashMap<String,String>> getYamlData(String yamlFile) throws FileNotFoundException {
        //report.log("");
        HashMap<String,HashMap<String,String>> keymap=null;
        FileInputStream fileInputStream=new FileInputStream(filepath+yamlFile);

        keymap= Yaml.loadType(fileInputStream,HashMap.class);

        return keymap;

    }

    public By getBy(String type,String value){
        By by=null;
        if(type.equals("id")){
            by=By.id(value);
        }
        if(type.equals("xpath")){
            by=By.xpath(value);
        }

        return by;

    }

//    public WebElement findElement(String elementName) throws FileNotFoundException {
//        HashMap<String,HashMap<String,String>> keymap=null;
//        keymap=getYamlData("JDProject.yaml");
//        String type=keymap.get(elementName).get("type");
//        String value=keymap.get(elementName).get("value");
//        return driver.findElement(getBy(type,value));
//
//    }
}
