import java.awt.Window;
import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestFirst2 {

//private static final TimeUnit seconds = null;

	@Test(enabled=false)
	public void test1() {
		String parentWindowTitle = "Google";
		String target_yatra = "Cheap Air Tickets , Hotels, Holiday, Trains Package Booking - Yatra.com";
		System.out.println("test1 test case");
		WebDriverManager.firefoxdriver().setup();
		//FirefoxOptions options = new FirefoxOptions();
		//options.addArguments("--remote-allow-origins=*");
		/*
		 * System.setProperty( "webdriver.chrome.driver", "/driver/path/chromedriver" )
		 */
		WebDriver driver = new FirefoxDriver();

		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		// driver.navigate().to("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String aTitle = driver.getTitle();
		System.out.println("Actula title: " + aTitle);
		driver.switchTo().newWindow(WindowType.TAB);
		driver.navigate().to("https://www.makemytrip.com/");
		driver.switchTo().newWindow(WindowType.TAB);
		driver.navigate().to("https://www.yatra.com/");
		String aTitle_yatra = driver.getTitle();
		System.out.println("Actula title of yatra: " + aTitle_yatra);
		driver.switchTo().newWindow(WindowType.TAB);
		driver.navigate().to("https://www.hdfcbank.com/");

		// Get the handles of all open windows or tabs
		// Set<String> handles = driver.getWindowHandles();

		/*
		 * for(String element : driver.getWindowHandles()) { String title=
		 * driver.switchTo().window(element).getTitle();
		 * System.out.println("print all the title "+title);
		 * if(title.contains(target_yatra)) {
		 * System.out.println("Found the right target window"); } }
		 */

		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		for (String element1 : tabs) {

			if (!element1.equals(target_yatra)) {
				String closingTitle = driver.switchTo().window(element1).getTitle();
				System.out.println("except first window everthing should get closed" + closingTitle);
				driver.switchTo().window(element1).close();

			}
		}

		//driver.quit();

	}
	@Test(enabled=false)
	public void testWord1() {
	
		WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--remote-allow-origins=*");
        // Add any additional options as needed

        // Launch Microsoft Edge browser
        WebDriver driver = new EdgeDriver(options);

		driver.get("https://wordpress.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.linkText("Log In")).click();
		driver.findElement(By.id("usernameOrEmail123")).click();
}
	
	@Test(threadPoolSize = 3, invocationCount = 10, timeOut = 10000,enabled=true)
	    public void testMethod1() {
	       System.out.println("hello test1");
	       WebDriverManager.edgedriver().setup();
	        EdgeOptions options = new EdgeOptions();
	        options.addArguments("--remote-allow-origins=*");
	        // Add any additional options as needed

	        // Launch Microsoft Edge browser
	        WebDriver driver = new EdgeDriver(options);

			driver.get("https://wordpress.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.quit();
	    }
	
	@Test(enabled=true)
	public void testMethod2() {
	       System.out.println("hello test1 ::no thread");
	    }
	
	
}