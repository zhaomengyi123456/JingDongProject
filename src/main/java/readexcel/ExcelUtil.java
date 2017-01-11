package readexcel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/27.
 */
public class ExcelUtil {
    public static HashMap<String, userInfo> read_xls(String path,String sheetname) throws IOException {

        //new一个HashMap类的对象
        Map<String,userInfo> userInfoMap=new HashMap<String,userInfo>();

        //相当于双击的动作
        InputStream is=new FileInputStream(path);//path路径作为形式参数

        //相当于创建工作簿
        XSSFWorkbook xssfWorkbook=new XSSFWorkbook(is);

        //拿到我文件中的第一个表
        Sheet sheet=xssfWorkbook.getSheet(sheetname);
        //获取行数
        int rowCount=sheet.getPhysicalNumberOfRows();
        //通过行数来循环获取每行每列中的内容
        for(int i=0;i<rowCount;i++){
            Row row =sheet.getRow(i);
            //获取列的数量，怎么感觉这一句在这里没有用到呢
            int cellCount=row.getPhysicalNumberOfCells();
            //new一个userInfo的对象
            userInfo u=new userInfo();
            //获取第二列的
            Cell cell1=row.getCell(1);
            //然后将第二列的value值取出，并用u.setUsername的方法设置给用户名
            u.setUsername(cell1.getStringCellValue());
            //获取第三列

            Cell cell2=row.getCell(2);
            //cell2.setCellType(CellType.STRING);
            //然后将第三列的value值取出，并用u.setPasswd的方法设置给密码
            u.setPasswd(cell2.getStringCellValue());

            Cell cell4=row.getCell(3);
            u.setJieguo(cell4.getStringCellValue());

            //这里就是取出第一列了
            Cell cell3=row.getCell(0);
            //将第一列和之前的对象u形成映射关系，即：键值对，放在我们之前new的那个Map类对象userInfoMap
            userInfoMap.put(cell3.getStringCellValue(),u);
        }
        //最后返回我们的userInfoMap对象，这里需要强制转换一下，转换为Map类
        return (HashMap<String, userInfo>) userInfoMap;


    }


    /**
     * Created by Administrator on 2016/12/27.
     */
    public static class excelDemo {
        public static void main(String[] args) throws IOException {
            Map<String,userInfo> a= read_xls("F:\\readexcel.xlsx","Sheet1");
            System.out.println(a.get("case5").getUsername());
            System.out.println(a.get("case5").getPasswd());

        }
    }
}
