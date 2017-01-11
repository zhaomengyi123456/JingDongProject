package Dome;

import menthod.WebElementUtils;
import org.openqa.selenium.By;

import java.io.IOException;

/**
 * Created by Administrator on 2016/12/23.
 */
public class Zentao_Bug extends WebElementUtils {
    public Zentao_Bug(int driverType) {
        super(driverType);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Zentao_Bug page=new Zentao_Bug(1);
        page.openWeb("http://127.0.0.1/zentaopro.php");
        page.pause(1000);
        page.fE_click(By.id("zentaopro"));
        page.pause(1000);
        page.fE_input(By.id("account"),"admin");
        page.fE_input(By.name("password"),"123456");
        page.fE_click(By.id("submit"));
        //进入后点击测试
        page.pause(2000);
        page.fE_click(By.xpath("//a[@href='/pro/qa/']"));
        page.pause(3000);
        //然后就点击bug 进入bug模块
        page.fE_click(By.xpath("//nav[@id='modulemenu']//li[2]/a"));

        page.fE_click(By.xpath(".//*[@id='currentItem']/span"));
        page.fE_click(By.partialLinkText("T0305"));

        page.fE_click(By.linkText("提Bug"));

        //进入了bug编写页面
        page.pause(1000);
        //所属产品
        page.fE_click(By.xpath(".//*[@id='product_chosen']/a"));
        page.fE_click(By.xpath("//li[text()='T0305']"));
        page.pause(1000);
        //所属模块
        page.fE_click(By.xpath(".//*[@id='module_chosen']/a"));
        page.fE_click(By.xpath(".//li[text()='/班级学生成绩管理']"));
        page.pause(1000);
        //所属项目
        page.fE_click(By.xpath(".//*[@id='project_chosen']/a"));
        page.fE_input(By.xpath("//div[@id='project_chosen']//input"),"T0305");
        page.pause(1000);
        //影响版本
        page.fE_click(By.xpath(".//*[@id='openedBuild_chosen']/ul"));
        page.fE_click(By.xpath(".//*[@id='openedBuild_chosen']/div/ul/li[2]"));//这里不完美
        //当前指派
        page.fE_click(By.xpath(".//*[@id='assignedTo_chosen']/a/div/b"));
        page.fE_input(By.xpath("//div[@id='assignedTo_chosen']//input"),"admin");
        //缺陷类型
        page.selectByVisibleText((By.cssSelector("#type")),"设计缺陷");
        //操作系统
        page.selectByVisibleText((By.cssSelector("#os")),"Windows 7");
        //浏览器版本
        page.selectByVisibleText((By.cssSelector("#browser")),"chrome");
        //选择标题颜色
        page.fE_click(By.xpath("//*[@id='dataform']/table//td/div[2]/div[1]//button"));
        page.fE_click(By.xpath("//a[@data-color='#388e3c']"));
        //写bug标题
        page.fE_input((By.cssSelector("#title")),"【学生成绩模块】不能同时删除多条学生信息");
        //严重程度
        page.fE_click(By.xpath("//*[@id='dataform']/table//td/div[2]/div[2]//div[1]/button"));
        page.fE_click(By.xpath("//div[@data-prefix='severity']//a[@data-pri='2']"));

        //优先级
        page.fE_click(By.xpath("//*[@id='dataform']/table//td/div[2]/div[2]//div[2]/button"));
        page.fE_click(By.xpath("//*[@id='dataform']//tr[5]//div[2]/ul/li[3]/a"));

        //步骤重现
        page.switchTo_frame(page.findE(By.xpath("//iframe[@class='ke-edit-iframe']")));
        page.findE(By.xpath(".//html/body")).clear();
        page.fE_input(By.xpath(".//html/body"),"[步骤]\n1.选中多条学生信息（例如：学号为38、39、40）\n2.点击删除记录\n3.点击确定\n" +
                "[结果]\n不可以同时选择多条学生信息\n"+"[期望]\n可以同时选择多条学生信息并删除");
        page.switchTo_defaultc();

        //抄送给谁
        page.fE_input(By.cssSelector("input[value='选择要发信通知的用户...']"),"赵六");
        //滚动条下拉
        page.gunDT();

        //附件
        page.fE_click(By.xpath("//input[@class='fileControl']"));
        page.pause(3000);
        Runtime.getRuntime().exec("F:\\upload2.exe");
        page.pause(3000);
        //保存
        page.fE_click(By.cssSelector("#submit"));
    }
}
