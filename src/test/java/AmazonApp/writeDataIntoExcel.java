package AmazonApp;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;


public class writeDataIntoExcel {
	
	@Test
	
	public void writeDataInExcel() throws IOException{
		
		
		        // Create a new workbook
		
		        Workbook workbook = WorkbookFactory.create(true);

		        // Create a new sheet
		        Sheet sheet = workbook.createSheet("Login");

		        // Create data
		        String[][] data = {
		                {"Username", "Password", "Result"},
		                {"nitin123", "test123", "PASS"},
		                {"rahul123", "test456", "FAIL"},
		                {"amit123", "test789", "PASS"},
		                {"rohit", "test000", null}
		        };

		        // Write data
		        for (int i = 0; i < data.length; i++) {

		            Row row = sheet.createRow(i);

		            for (int j = 0; j < data[i].length; j++) {

		                row.createCell(j).setCellValue(data[i][j]);
		                
		                
		            }
		            int num = data.length;
		            int num1 = data[i].length;
		            
			        System.out.println(num);
			        System.out.println(num1);
		        }
		        //random number
		        Random random=new Random();
		      int num = random.nextInt(5000);

		        // Save as Excel file
		        FileOutputStream fos =
		                new FileOutputStream("./LoginData"+num+".xlsx");

		        workbook.write(fos);

		        fos.close();
		        workbook.close();

		        System.out.println("Excel created successfully!");
		        num=data.length;
		        
		        
		        System.out.println();
		        
		    }
		}
		
	


