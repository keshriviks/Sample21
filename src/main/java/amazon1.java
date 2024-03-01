import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class amazon1 {

	@Test(enabled = true)
	public void testWebtable1() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);

		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//a[text()='Mobiles']")).click();
		//Thread.sleep(3000);
		//driver.findElement(By.xpath("//span[text()='Mobile Accessories']")).click();
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone 14 plus 256");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
	//	driver.findElement(By.xpath("//span[text()='Apple iPhone 14 Plus (256 GB) - Blue']")).click();
		
		// Switch to the new window
        String mainWindowHandle = driver.getWindowHandle();
		WebElement phone=driver.findElement(By.xpath("//span[text()='Apple iPhone 14 Plus (256 GB) - Yellow']"));
       
    //  phone.click();
		
		  try {
			if(phone.isDisplayed())
			  { phone.click(); 
			  
			  } else {
			  System.out.println("Throws an exception"); 
			  }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("An error occurred: " + e.getMessage());
			//e.printStackTrace();
		}
		 
       
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(mainWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
		
		driver.findElement(By.xpath("//input[@id='buy-now-button']")).click();
		
		driver.quit();
		
	}

}