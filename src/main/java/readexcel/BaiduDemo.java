package readexcel;

import menthod.WebElementUtils;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import org.apache.commons.logging.LogFactory;
/**
 * Created by Administrator on 2016/12/27.
 */
public class BaiduDemo {

    WebElementUtils page;
   @Test
    public void open() throws IOException {
        page=new WebElementUtils(1);
        List<ExcelData> list=ReadExcelDemo2.readExcel();

        for(int i=0;i<list.size();i++){
            ExcelData ed=list.get(i);
            page.openWeb(ed.getUrl());
            page.fE_input(By.id(ed.getId()),ed.getKeyWord());
            page.fE_click(By.id(ed.getId()));
        }
    }


}
