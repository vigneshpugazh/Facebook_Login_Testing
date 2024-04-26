package package1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Data {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		File file=new File("C:\\Users\\2318390\\eclipse-workspace\\MyProject\\ChromeEdge\\Information.xlsx");
	    FileInputStream fi = new FileInputStream(file);
	    XSSFWorkbook wb=new XSSFWorkbook(fi);
	    XSSFSheet sheet=wb.getSheet("Sheet1");
	    int rowcount =sheet.getLastRowNum();
	    for(int i=0;i<=rowcount;i++) {
	    	String Link="https://www.facebook.com/";
	    	XSSFRow row=sheet.getRow(i);
	 	    DataFormatter df=new DataFormatter();
	 	    XSSFCell cell1=row.getCell(0);
	 	    XSSFCell cell2=row.getCell(1);
	 	    XSSFCell cell3=row.getCell(2);
	 	    XSSFCell cell4=row.getCell(3);
	 	    XSSFCell cell5=row.getCell(4);
	 	    XSSFCell cell6=row.getCell(5);
	 	
	 	    String browser=cell1.getStringCellValue();
	 	    String fname=cell2.getStringCellValue();
	 	    String lname=cell3.getStringCellValue();
	 	    String phno=df.formatCellValue(cell4);
	 	    String password=cell5.getStringCellValue();
	 	    String dob=cell6.getStringCellValue();
	 	    
	 	    Operations.initialize(browser);
	 	    Operations.GetIntoWebsite(Link);
	 	    Operations.Maximize();
			boolean validation=Operations.faceBook(fname,lname ,phno,password,dob);
			if(browser.equalsIgnoreCase("chrome") && validation) {
				String file1=System.getProperty("user.dir")+"\\ChromeEdge\\Information.xlsx";
				     XSSFCell cell7=row.createCell(6);
				     cell7.setCellValue("Test Passed");
				     CellStyle style=wb.createCellStyle();
				     style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
					 style.setFillPattern(FillPatternType.SOLID_FOREGROUND); 
					 cell7.setCellStyle(style);
					 FileOutputStream fo=new FileOutputStream(file1);
					 wb.write(fo);
					
			}
			if(browser.equalsIgnoreCase("edge") && validation) {
				    String file1=System.getProperty("user.dir")+"\\ChromeEdge\\Information.xlsx";
				     XSSFCell cell7=row.createCell(6);
				     cell7.setCellValue("Test Passed");
				     CellStyle style=wb.createCellStyle();
				     style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
					 style.setFillPattern(FillPatternType.SOLID_FOREGROUND); 
					 cell7.setCellStyle(style);
					 FileOutputStream fo=new FileOutputStream(file1);
					 wb.write(fo);
					 wb.close();
					 fi.close();
					 fo.close();
			}
			
			Operations.End();
	    }
		
	}

}
