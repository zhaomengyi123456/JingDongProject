package readexcel;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/27.
 */
public class ReadExcelDemo2 {
    public static List<ExcelData> readExcel() throws IOException {
        //用list集合new一个对象
        List<ExcelData> li=new ArrayList<ExcelData>();
        //给一个文件的路径
        File filepath=new File("F:\\readexcel.xlsx");
        //文件输入流对象
        FileInputStream files=new FileInputStream(filepath);
        //POIFSFileSystem POIStream=new POIFSFileSystem(files);
        //读取xlsx的excel文件
        XSSFWorkbook Workbook=new XSSFWorkbook(files);
        //
        XSSFSheet sheet=Workbook.getSheetAt(1);
        for(int i=0;i<=sheet.getLastRowNum();i++){
            XSSFRow row=sheet.getRow(i);
            ExcelData e=new ExcelData();
            e.setUrl(row.getCell(0).toString());
            e.setKeyWord(row.getCell(1).toString());
            e.setKw(row.getCell(2).toString());
            e.setId(row.getCell(3).toString());
            //e.setName(row.getCell(4).toString());
            li.add(e);
        }

        return li;

    }

    public static void main(String[] args) throws IOException {

        for(ExcelData e:ReadExcelDemo2.readExcel()){
            System.out.println(e.getUrl());
        }


    }
}
