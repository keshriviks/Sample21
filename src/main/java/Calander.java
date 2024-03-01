//import java.util.concurrent.TimeUnit;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calander {

	@Test
	public void testCalnder() throws InterruptedException {
		String parentWindowTitle = "Google";
		String target_yatra = "Cheap Air Tickets , Hotels, Holiday, Trains Package Booking - Yatra.com";
		System.out.println("test1 test case");
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		driver.get("https://www.makemytrip.com/");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[@class='commonModal__close']")).click();
		// Thread thread = new Thread();
		Thread.sleep(5000);

		WebElement departureDateInput = driver.findElement(By.xpath("//span[contains(text(),'Departure')]"));
		departureDateInput.click();

		// WebElement monthYear =
		// driver.findElement(By.xpath("//div[contains(text(),'September 2023')]"));
		String monthYearValue = driver.findElement(By.className("DayPicker-Caption")).getText();
		// String monthYearValue= monthYear.getText();

		String month = monthYearValue.split(" ")[0].trim();
		System.out.println("print month:: " + month);
		String year = monthYearValue.split(" ")[1].trim();
		System.out.println("print year" + ":: " + year);

		while (!(month.equals("December") && year.equals("2023"))) {
			driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();

			monthYearValue = driver.findElement(By.className("DayPicker-Caption")).getText();
			month = monthYearValue.split(" ")[0].trim();
			System.out.println("print month latest:: " + month);
			year = monthYearValue.split(" ")[1].trim();
			System.out.println("print yea latestr" + ":: " + year);

		}

		// driver.findElement(By.xpath("//p[text()='26']")).click();
		System.out.println("it will click on 26th nov");

		WebElement date_27th = driver.findElement(By.xpath("//div[contains(@aria-label, 'Dec')]/div/p[text()='26']"));
		Thread.sleep(5000);
		jsExecutor.executeScript("arguments[0].click();", date_27th);
		System.out.println("date is picked");

		// div[@aria-label='Sun Nov 26 2023']//p[contains(text(),'26')]

	}

}
