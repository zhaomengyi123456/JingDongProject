package menthod;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by Administrator on 2017/1/4.
 * Utils类继承了一个迭代器接口，所以迭代器内的方法（hasnext  next  remove）在这里都要实现，
 * 且这个类自身现在也是一个迭代器了
 *
 *
 */

public class ExcelUtils implements Iterator<Object[]> {
    //先定义需要的变量
    private int rowNum;
    private int colNum;
    private int curRowNum;
    private String columnName[];

    Workbook book07;
    Workbook book03;
    Sheet sheet07;
    Sheet sheet03;
    //其实这个也可以不定义的，如果路径变了还是需要改动
    private final String filePath="F:\\";

    //这个类的构造方法
    public ExcelUtils(String fileName, String sheetName) throws IOException {
        //用一个变量将文件路径与文件名集合在一起
        String filename1=filePath+fileName;

        //调用readExcel方法，并传参数
        readExcel(filename1,sheetName);

    }

    //读取excel文件方法，无返回值
    public void readExcel(String fileName,String sheetName) throws IOException {

        //搭桥
        FileInputStream fileInputStream=new FileInputStream(fileName);
        //得到workbook
        book07=new XSSFWorkbook(fileInputStream);
        //得到sheet
        sheet07=book07.getSheet(sheetName);
        //获取第一行，列名行
        Row row =sheet07.getRow(0);
        //获取总的行数
        rowNum=sheet07.getPhysicalNumberOfRows();
        //通过第一行的单元格确定有多少列
        colNum=row.getPhysicalNumberOfCells();


        columnName=new String[colNum];//列名的数组，长度是列数
        //这个count是用来确定单元格的位置
        int count=0;
        Iterator<Cell> heads=row.cellIterator();//通过第一行的单元格来迭代，列名  cell类型的迭代器
        //此处调用了两个方法：hasNext()  next（）方法
        while (heads.hasNext()){
            Cell cell=heads.next();//heads.next()返回的肯定是cell类型
            cell.setCellType(CellType.STRING);
            columnName[count]=cell.getStringCellValue();//将得到的列名放入之前定义的列名数组中
            count++;//单元格往后移
        }

        //当前行号自增，实际就是第一行完了后就向下移动
        this.curRowNum++;
    }

    //在上面执行的时候就会调用这里的方法
    public boolean hasNext(){
        //如果行数等于0或者当前行比总行数还要大那就不用读取了
        if(rowNum==0 || this.curRowNum>=rowNum){
            return false;
        }
        else{
            return true;
        }
    }

    //next()方法 返回一个数组，而这个数组中放的是一个map
    public Object[] next(){
        HashMap<String,Object> map=new HashMap<String,Object>();//首先定义一个map
        //定义一个临时变量，用来接收取出的某行对应的单元格的值
        Object temp=null;
        //获取当前行一整行
        Row row =sheet07.getRow(curRowNum);
        //用列的数量来控制
        for(int i=0;i<colNum;i++){
            row.getCell(i).setCellType(CellType.STRING);
            //取出当前行具体的值，存放在temp中
            temp=row.getCell(i).getStringCellValue();
            //将获取的列名作为key，当前行的单元格的值作为value值
            map.put(columnName[i],temp);
        }
        //当前行自增，向下移动
        this.curRowNum++;

        //new一个数组，长度为1
        Object object[]=new Object[1];
        object[0]=map;//将map放入数组中
        return object;//返回这个数组
    }

    //这个方法可以就这样，也可以写具体,延迟数据提供，
    public void remove(){

        throw new UnsupportedOperationException();
    }





}
