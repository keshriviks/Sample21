import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.devtools.v102.io.IO;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadDataFromCSV {

	//@Test(dataProvider="testDataNew")
	@Test(dataProvider="LoginCredentials")
	
	public void testWebtable1(String username, String password, String exp) {
		System.out.println(username+"==================="+password+"=========="+exp);
		
	}
	// @DataProvider(name = "testdata")
	@DataProvider(name="LoginCredentials")
	public Object[][] dataProvider() throws FileNotFoundException{


	File file= new File(System.getProperty("user.dir")+"\\testdata.csv");
	FileInputStream fis= new FileInputStream(file);
	XSSFWorkbook wb= new XSSFWorkbook();
	XSSFSheet sheet = wb.getSheet("Login");

	int rowCount=sheet.getLastRowNum();
	int columnCount=sheet.getRow(0).getLastCellNum();

	Object [][]data = new Object[rowCount][columnCount];

	for(int i=0; i<rowCount; i++){
	XSSFRow row = sheet.getRow(i+1);

	for(int j=0; i<columnCount; i++){
	XSSFCell cell= row.getCell(j);

	data[i][j] = cell.getStringCellValue();


}
	}
	return data;
	}
	
	
	 @Test(dataProvider = "testData")
	    public void testWithDataProvider(String username, String password) {
	      System.out.println("Username: " + username + ", Password: " + password);
	      // Your test logic here
	    }
	    @DataProvider(name = "testData")
	    public Object[][] testData() {
	      return new Object[][] {
	        {"user1", "password1"},
	        {"user2", "password2"},
	        // Add more data sets as needed
	      };
	    }
	    
	    @DataProvider(name = "testDataNew")
	    public Object[][] testData1() throws IOException {
	      String filePath = "data.csv";
	      List<String[]> data = new ArrayList<>();

	      try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir")+"\\testdata.csv"))) {
	        String line;
	        while ((line = br.readLine()) != null) {
	          String[] values = line.split(",");
	          data.add(values);
	        }
	      }

	      Object[][] dataArray = new Object[data.size()][5];
	      for (int i = 0; i < data.size(); i++) {
	        dataArray[i] = data.get(i);
	      }

	      return dataArray;
	    }
	  }
	  