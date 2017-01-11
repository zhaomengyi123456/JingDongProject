package TPshopData;

import menthod.ExcelUtils;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.Iterator;

/**
 * Created by Administrator on 2017/1/10.
 */
public class TPshopExcelData {
    @DataProvider
    public Iterator<Object[]> dps() throws IOException {
        return new ExcelUtils("TPshopData\\LoginPageData.xlsx", "Sheet2");
    }
}
