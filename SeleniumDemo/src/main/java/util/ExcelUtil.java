package util;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	FileInputStream f;
	XSSFWorkbook w;
	XSSFSheet sh;	
	String fileLocation=System.getProperty("user.dir") + "/src/test/resources";
	String fileName, sheetName;
	
	
	public String getStringData(int x,int y) throws IOException
	{	
		f=new FileInputStream(fileLocation+"/"+fileName);
		w=new XSSFWorkbook(f);
		sh=w.getSheet(sheetName);
		XSSFRow r=sh.getRow(x);
		XSSFCell c=r.getCell(y);
		return c.getStringCellValue();
	}

	public ExcelUtil(String fileName, String sheetName) {
		this.fileName = fileName;
		this.sheetName = sheetName;
	}

	public String getIntegerData(int x,int y) throws IOException
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
