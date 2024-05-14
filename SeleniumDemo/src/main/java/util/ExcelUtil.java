package util;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	static FileInputStream f;
	static XSSFWorkbook w;
	static XSSFSheet sh;	
	static String fileLocation=System.getProperty("user.dir") + "/src/test/resources";
	
	
	
	public static String getStringData(int x,int y, String fileName, String sheetName) throws IOException
	{	
		f=new FileInputStream(fileLocation+"/"+fileName);
		w=new XSSFWorkbook(f);
		sh=w.getSheet(sheetName);
		XSSFRow r=sh.getRow(x);
		XSSFCell c=r.getCell(y);
		return c.getStringCellValue();
	}

	public static String getIntegerData(int x,int y, String fileName, String sheetName) throws IOException
	{	
		f=new FileInputStream(fileLocation+"/"+fileName);
		w=new XSSFWorkbook(f);
		sh=w.getSheet(sheetName);
		XSSFRow r=sh.getRow(x);
		XSSFCell c=r.getCell(y);
		int z=(int) c.getNumericCellValue();
		return String.valueOf(z);	
	}	

}
