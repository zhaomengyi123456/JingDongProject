package test;
import menthod.WebElementUtils;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2016/12/26.
 */
public class OpenZenTao {
    WebElementUtils page;
    @Parameters("url")
    @BeforeTest
    public void OpenWeb(String url){
        page=new WebElementUtils(1);
        page.openWeb(url);
    }
    @AfterTest
    public void closeweb(){
        page.pause(2000);
        page.closeWeb();
    }
    //@Parameters("str")
    @Test
    public void test(){
        String str=page.gTitle();
        Assert.assertEquals(str,"欢迎使用禅道集成运行环境！");
    }
}
