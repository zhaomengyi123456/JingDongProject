package readexcel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/**
 * Created by Administrator on 2017/1/3.
 */
public class ExcelUtilDemo2 {

    public static HashMap<String,String> getEexcelData(String filePath, String sheetname,int caseID) throws IOException {
        Map<String,String> map=new HashMap<String, String>();
        FileInputStream fis=new FileInputStream(filePath);
        XSSFWorkbook xssfWorkbook=new XSSFWorkbook(fis);
        Sheet sheet=xssfWorkbook.getSheet(sheetname);
        //获取第一行的列名
        Row titles=sheet.getRow(0);
        //获取物理的单元格的个数，实际就是列数了
        int colNum=titles.getPhysicalNumberOfCells();
        int rowNum=sheet.getPhysicalNumberOfRows();

        //根据迭代器获取每行数据
        Iterator<Cell> heads=titles.iterator();
        //String[] columnName=new String[colNum];
        //接收键的
        String key;
        //接收值的
        String value=null;
        //通过列名标题去遍历
        while (heads.hasNext()){

            //单元格
            Cell keycell=heads.next();
            //转换单元格的格式哦
            keycell.setCellType(CellType.STRING);
            //键值就是列名标题
            key=keycell.getStringCellValue();
            //确定哪一行
            Cell valuecell=sheet.getRow(caseID).getCell(keycell.getColumnIndex());

            //转换单元格的格式
            valuecell.setCellType(CellType.STRING);

            //获取一行中的某个单元格的value值
            value=valuecell.getStringCellValue();

            //放入到一个map中
            map.put(key,value);
        }
        return (HashMap<String, String>) map;



//        int count=0;
//        while (heads.hasNext()){
//            Cell cell=heads.next();
//            columnName[count]=cell.getStringCellValue();
//            count++;
//        }
////        //获取指定title的单元格数据
//        int col=0;
//        for(int i=0;i<colNum;i++){
//            String tittle=titles.getCell(i).toString();
//                if(tittle.equals(titleName)) {
//                    col = i;
//                    break;
//                }
//        }

//        Map<String,String> map=new HashMap<String, String>();
//        for(int i=1;i<rowNum;i++){
//            Map map1=new HashMap();
//            for(int j=1;j<colNum;j++){
//                String cell=sheet.getRow(i).getCell(j).toString();
//                map1.put();
//            }
//
//                //String cell=sheet.getRow(i).getCell(i-1).toString();
//           // map1.put(titleName,user);
//
//
//            map.put(sheet.getRow(i).getCell(0).toString(),map1);// 行在变 列没变
//        }

        //Map<String,List<String>> map=new HashMap<String, List<String>>();

        //以列名为key，竖着
//        for(int i=0;i<colNum;i++) {
//            List<String> list=new ArrayList<String>();
//            for(int j=1;j<rowNum;j++){
//                String cell=sheet.getRow(j).getCell(i).toString();
//                list.add(cell);
//            }
//            map.put(columnName[i],list);
//        }


        //以每行的第一个单元格为key，横着
//        for(int i=1;i<rowNum;i++){
//            List<String> list=new ArrayList<String>();
//            for(int j=1;j<colNum;j++){
//                String cell=sheet.getRow(i).getCell(j).toString();
//                list.add(cell);
//            }
//            map.put(sheet.getRow(i).getCell(0).toString(),list);// 行在变 列没变
//        }
       // System.out.println(map);
//        Set<Map.Entry<String, String>> set1=map.entrySet();   //返回的是一种映射关系
//        Iterator<Map.Entry<String, String>> ite2=set1.iterator();
//        while (ite2.hasNext()){
//            Map.Entry entry=(Map.Entry)ite2.next();
//            System.out.println(entry.getKey()+":"+entry.getValue());
//        }
//        return (HashMap<String,String>)map;
        //return (HashMap<String,List<String>>)map;
        //System.out.println(sheet.getRow(caseID).getCell(col).toString());
        //关闭文件流
        //fileInputStream.close();


    }

//    public static void main(String[] args) throws IOException {
//
//        System.out.println(getEexcelData("F:\\readexcel.xlsx","Sheet5",1).get("userName"));
//        ExcelUtilDemo2 eu=new ExcelUtilDemo2();
//        eu.getEexcelData("F:\\readexcel.xlsx","Sheet5",1);
//
//
//    }
}
