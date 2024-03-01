import java.awt.Window;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestFirst {

//private static final TimeUnit seconds = null;

	@Test
	public void test1() {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);

		driver.get("https://www.countries-ofthe-world.com/capitals-of-the-world.html");
		driver.manage().window().maximize();
		// driver.navigate().to("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	
		List<WebElement> anchorElements = driver.findElements(By.tagName("a"));
		  for (WebElement anchorElement : anchorElements) {
	            System.out.println(anchorElement.getText());
	            
	            if(anchorElement.getText().equals("COUNTRIES OF AFRICA")) {
	            	System.out.println("All good!");
	            	break;
	            	
	            }
	        }
		  
		  List <WebElement> allrows = driver.findElements(By.xpath("//table[@class='two-column td-red']//tr"));
		  for (WebElement row : allrows) {
		 // System.out.println(row.getText());
		  }
		  int row_count = driver.findElements(By.xpath("//table[@class='two-column td-red']//tr")).size(); 
		  System.out.println(row_count);
		  
		  List <WebElement> allcolumn = driver.findElements(By.xpath("//table[@class='two-column td-red']//td")); 
		  for (WebElement column : allcolumn) {
		 // System.out.println(column.getText());
		  }
		  
		  int column_count = driver.findElements(By.xpath("//table[@class='two-column td-red']//td")).size();
		  System.out.println(column_count);
		  
		  WebElement table = driver.findElement(By.xpath("//table[@class='two-column td-red']"));
		  boolean xyz=table.isEnabled();
		  System.out.println(xyz);
      
		  for (int i = 1; i < row_count; i++) {
				for (int j = 1; j <= column_count; j++) {

					 WebElement cellXPath = driver.findElement(By.xpath("//table[@class='two-column td-red']/tbody/tr[" + (i+1
							 ) + "]/td[" + j + "]"
							 ));
		                //WebElement cell = driver.findElement(By.xpath(cellXPath));
						
		                // Get the text value of the cell
		                String cellText = cellXPath.getText();

					System.out.println("Lets check here :: "+cellText);
				}
			}
		  
			/*
			 * // Find all rows within the table List<WebElement> rows =
			 * table.findElements(By.tagName("tr"));
			 * 
			 * // Iterate through the rows and print the data for (WebElement row : rows) {
			 * // Find the cell (td) within each row String eachRowName=row.getText();
			 * System.out.println("All row data :: "+eachRowName); WebElement cell =
			 * row.findElement(By.tagName("td"));
			 * 
			 * // Get the text from the cell and print it
			 * System.out.println("All cell data :: "+cell.getText()); }
			 */
		  
		

		//driver.quit();

	}

}
