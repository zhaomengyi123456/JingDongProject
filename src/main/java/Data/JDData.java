package Data;

import menthod.ExcelUtils;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.Iterator;

/**
 * Created by Administrator on 2017/1/5.
 */
public class JDData {
    @DataProvider
    public Iterator<Object[]> beforetestf() throws IOException {
        //这里我改动了一点，先在F盘将将这个用例文件的后缀名改了，然后在这里把文件换成了改动后的，，，，能执行 为什么？
        return new ExcelUtils("dps\\JDLogin - 副本.xls","Sheet2");
    }
}
