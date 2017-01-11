package readexcel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2016/12/27.
 */
public class ReadExcel {
    public static void main(String[] args) throws IOException {
        String excelpath="F:\\readexcel.xlsx";
        InputStream is=new FileInputStream(excelpath);

        //分hassfworkbook和xssfworkbook两种，导入的包不一样，前者适合2007之前的，后者适合07之后的
        XSSFWorkbook xssfWorkbook=new XSSFWorkbook(is);

        int sheetCount=xssfWorkbook.getNumberOfSheets(); //获取我的文件中有多少个sheet表
      //  System.out.println(sheetCount);

        Sheet sheet=xssfWorkbook.getSheetAt(0); //使用第一个表

        int rowCount=sheet.getPhysicalNumberOfRows();//获取行数
     //   System.out.println(rowCount);

        Row row=sheet.getRow(0);  //第一行
        int cellCount=row.getPhysicalNumberOfCells();  //获取列数
        System.out.println(cellCount);

        Cell cell=row.getCell(1);  //第二列
        String c=cell.getStringCellValue(); //那么这里获取的值就是：hello1
        System.out.println(c);

    }
}
