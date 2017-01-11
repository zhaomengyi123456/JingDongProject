package readexcel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Administrator on 2016/12/27.
 */
public class ExcelData {
    private String url;
    private String keyWord;
    private String kw;
    private String id;
    private String name;

    public void setUrl(String url){
        this.url=url;
    }

    public String getUrl(){
        return this.url;
    }

    public void setKeyWord(String keyWord){
        this.keyWord=keyWord;
    }

    public String getKeyWord(){
        return this.keyWord;
    }

    public void setKw(String kw){
        this.kw=kw;
    }
    public String getKw(){
        return this.kw;
    }

    public void setId(String id){
        this.id=id;
    }
    public String getId(){
        return this.id;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return this.name;
    }



}
