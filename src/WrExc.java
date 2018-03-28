import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class WrExc{
	public static void main(String[] args) throws Exception {
		
		long start = new Date().getTime();
		System.out.println("������ ��������");
		HSSFWorkbook workbook = new HSSFWorkbook();
        Sheet sheetWr = workbook.createSheet("��� ��������");
        Start.download();
        
        Row row = sheetWr.createRow(0);
        
        Cell apWrText = row.createCell(0);
        apWrText.setCellValue("������� ����������");
        Cell nameWrText = row.createCell(1);
        nameWrText.setCellValue("������������");
    	Cell artPrdWrText = row.createCell(2);
    	artPrdWrText.setCellValue("������� �������������");
    	Cell dilerWrText = row.createCell(3);
    	dilerWrText.setCellValue("��������� ����");
    	Cell rrcWrText = row.createCell(4);
    	rrcWrText.setCellValue("���");
    	Cell ostWrText = row.createCell(5);
    	ostWrText.setCellValue("�������");
    	
    	int rowCount = 1;
		System.out.println("�������� ������ � ������ ����");
        for(DataModel d : Start.listDm){
            
        	row = sheetWr.createRow(rowCount);
        	
        	Cell wrId = row.createCell(0);
        	wrId.setCellValue(d.getId());
        	Cell wrName = row.createCell(1);
        	wrName.setCellValue(d.getName());
        	Cell wrArtPr = row.createCell(2);
        	wrArtPr.setCellValue(d.getArticle());
        	Cell wrDiler = row.createCell(3);
        	wrDiler.setCellValue(d.getPriceDiler());
        	Cell wrRrc = row.createCell(4);
        	wrRrc.setCellValue(d.getPriceRozn());
        	Cell wrOst = row.createCell(5);
        	wrOst.setCellValue(d.getOst());
        	
        	rowCount++;
        }

        workbook.write(new FileOutputStream(new File("C:\\Users\\User\\Desktop\\������� �\\Java\\Test.xls")));
        workbook.close();
        long finish = new Date().getTime();
		System.out.printf("������! ����� ���������� %.2f ���", (double) ((finish - start)/1000.0));
		
	}
}
