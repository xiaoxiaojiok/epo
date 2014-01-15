package com.gzgb.epo.util;

import java.io.File;
import java.io.FileInputStream;   
import java.io.FileNotFoundException;   
import java.io.IOException;   
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;   
import java.util.Iterator;   
import java.util.List;
  
import org.apache.poi.hssf.usermodel.HSSFCell;  
import org.apache.poi.hssf.usermodel.HSSFDateUtil;  
import org.apache.poi.hssf.usermodel.HSSFRow;  
import org.apache.poi.hssf.usermodel.HSSFSheet;  
import org.apache.poi.hssf.usermodel.HSSFWorkbook;  
import org.apache.poi.xssf.usermodel.XSSFCell;  
import org.apache.poi.xssf.usermodel.XSSFRow;  
import org.apache.poi.xssf.usermodel.XSSFSheet;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook;  

  
public class ReadExcel { 
	
//	/**
//	 * 文件的路径名
//	 */
//	private static String filePath;
//	
//	
//	public static String getFilePath() {
//		return filePath;
//	}
//
//	public static void setFilePath(String filePath) {
//		ReadExcel.filePath = filePath;
//	}
//
//	/**
//	 *
//	 * 构造函数
//	 * 	 
//	 */
//	public ReadExcel(String filePath){
//		this.filePath = filePath;
//	}
//     
	
	/** 
	* 读取 office 2003 excel 
	* @throws IOException  
	* @throws FileNotFoundException */  
	private static List<List<Object>> read2003Excel(File file) throws IOException{  
	   List<List<Object>> list = new ArrayList<List<Object>>();  
	   HSSFWorkbook hwb = new HSSFWorkbook(new FileInputStream(file)); 
	   int sheetCount = hwb.getNumberOfSheets();
	   for(int shindex=0; shindex<sheetCount; shindex++){
		   HSSFSheet sheet = hwb.getSheetAt(shindex);  
		   Object value = null;  
		   HSSFRow row = null;  
		   HSSFCell cell = null;   
		   for(int i = sheet.getFirstRowNum();i<= sheet.getPhysicalNumberOfRows();i++){ 
			    if(i == 0)
			    	continue;
			    row = sheet.getRow(i);  
			    if (row == null) {  
			     continue;  
			    }  
			    List<Object> linked = new ArrayList<Object>();  
			    for (int j = row.getFirstCellNum(); j <= row.getLastCellNum(); j++) {  
			     cell = row.getCell(j);  
			     if (cell == null) {  
			      continue;  
			     }  
			     DecimalFormat df = new DecimalFormat("0");// 格式化 number String 字符   
			     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 格式化日期字符串   
			     DecimalFormat nf = new DecimalFormat("0.00");// 格式化数字   
			     switch (cell.getCellType()) {  
				     case XSSFCell.CELL_TYPE_STRING:  
												      System.out.println(i+"行"+j+" 列 is String type");  
												      value = cell.getStringCellValue();  
												      System.out.println(value);  
												      break;  
				     case XSSFCell.CELL_TYPE_NUMERIC:  
												      System.out.println(i+"行"+j+" 列 is Number type ; DateFormt:"+cell.getCellStyle().getDataFormatString());  
												      if("@".equals(cell.getCellStyle().getDataFormatString())){  
												         value = df.format(cell.getNumericCellValue());  
												      } else if("General".equals(cell.getCellStyle().getDataFormatString())){  
												         value = nf.format(cell.getNumericCellValue());  
												      }else{  
												        value = sdf.format(HSSFDateUtil.getJavaDate(cell.getNumericCellValue()));  
												      }  
												      System.out.println(value);  
												      break;  
				     case XSSFCell.CELL_TYPE_BOOLEAN:  
												      System.out.println(i+"行"+j+" 列 is Boolean type");  
												      value = cell.getBooleanCellValue();  
												      System.out.println(value);  
												      break;  
				       case XSSFCell.CELL_TYPE_BLANK:  
												      System.out.println(i+"行"+j+" 列 is Blank type");  
												      value = "";  
												      System.out.println(value);  
												      break;  
				     						 default:  
												      System.out.println(i+"行"+j+" 列 is default type");  
												      value = cell.toString(); 
												      System.out.println(value);  
			     }  
			     if (value == null || "".equals(value)) {  
			      continue;  
			     }  
			     linked.add(value);    
			   }  
			    list.add(linked); 
		   }
	   }  
	   return list;  
	}  
	/** 
	* 读取Office 2007 excel 
	* */  
	private static List<List<Object>> read2007Excel(File file) throws IOException {  
	   List<List<Object>> list = new ArrayList<List<Object>>();  
	   // 构造 XSSFWorkbook 对象   
	   XSSFWorkbook xwb = new XSSFWorkbook(new FileInputStream(file));  
	   int sheetCount = xwb.getNumberOfSheets();
	   for(int shindex=0; shindex<sheetCount; shindex++){ 
		   XSSFSheet sheet = xwb.getSheetAt(0);  
		   Object value = null;  
		   XSSFRow row = null;  
		   XSSFCell cell = null;  
		   for (int i = sheet.getFirstRowNum(); i <= sheet.getPhysicalNumberOfRows(); i++) {
			    if(i == 0)
				   continue;
			    row = sheet.getRow(i);  
			    if (row == null) {  
			     continue;  
			    }  
			    List<Object> linked = new ArrayList<Object>();  
			    for (int j = row.getFirstCellNum(); j <= row.getLastCellNum(); j++) {  
				     cell = row.getCell(j);  
				     if (cell == null) {  
				      continue;  
				     }  
				     DecimalFormat df = new DecimalFormat("0");// 格式化 number String 字符   
				     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 格式化日期字符串   
				     DecimalFormat nf = new DecimalFormat("0.00");// 格式化数字   
				     switch (cell.getCellType()) {  
					     case XSSFCell.CELL_TYPE_STRING:  
													      System.out.println(i+"行"+j+" 列 is String type");  
													      value = cell.getStringCellValue(); 
													      System.out.println(value);  
													      break;  
					     case XSSFCell.CELL_TYPE_NUMERIC:  
													      System.out.println(i+"行"+j+" 列 is Number type ; DateFormt:"+cell.getCellStyle().getDataFormatString());  
													      if("@".equals(cell.getCellStyle().getDataFormatString())){  
													        value = df.format(cell.getNumericCellValue());  
													      } else if("General".equals(cell.getCellStyle().getDataFormatString())){  
													        value = nf.format(cell.getNumericCellValue());  
													      }else{  
													       value = sdf.format(HSSFDateUtil.getJavaDate(cell.getNumericCellValue()));  
													      }  
													      System.out.println(value);  
													      break;  
					     case XSSFCell.CELL_TYPE_BOOLEAN:  
													      System.out.println(i+"行"+j+" 列 is Boolean type");  
													      value = cell.getBooleanCellValue();  
													      System.out.println(value);  
													      break;  
					       case XSSFCell.CELL_TYPE_BLANK:  
													      System.out.println(i+"行"+j+" 列 is Blank type");  
													      value = "";  
													      System.out.println(value);  
													      break;  
					                             default:  
													      System.out.println(i+"行"+j+" 列 is default type");  
													      System.out.println(value);  
													      value = cell.toString();  
				     }  
				     if (value == null || "".equals(value)) {  
				      continue;  
				     }  
				     linked.add(value);  
			    }  
			    list.add(linked); 
		   }
	   }  
	   return list;  
	}  

	
	
	/**
	 * 根据文件名的后缀选择调用哪个函数
	 * @param 
	 * @return
	 */
    public static List<List<Object>> readExcel(String filePath) {   
  
        if(filePath == null) 
        	return null;   
        try {
        	// 文件流指向excel文件   
            File file = new File(filePath);   
            int index = filePath.lastIndexOf('.');
            if(index != -1){
            	if("xls".equals(filePath.substring((index+1), filePath.length())))
            		return read2003Excel(file);
            	if("xlsx".equals(filePath.substring((index+1), filePath.length())))
            		return read2007Excel(file);
            	else
            		return null;
            }
        } catch (FileNotFoundException e) {   
            e.printStackTrace();   
        } catch (IOException ex) {   
            ex.printStackTrace();   
        }   
       
        return null;   
    }   
       
 
  
}  

