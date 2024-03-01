import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebtableCases {

	@Test(enabled = true)
	public void testWebtable1() {
		/*
		 * WebDriverManager.chromedriver().setup(); ChromeOptions options = new
		 * ChromeOptions(); options.addArguments("--remote-allow-origins=*"); WebDriver
		 * driver = new ChromeDriver(options);
		 */
		
		WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--remote-allow-origins=*");
        // Add any additional options as needed

        // Launch Microsoft Edge browser
        WebDriver driver = new EdgeDriver(options);

		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().window().maximize();
		int row_count = driver.findElements(By.xpath("//table[@id='customers']//tr")).size();

		int column_count = driver.findElements(By.xpath("//table[@id='customers']//th")).size();

		for (int i = 1; i < row_count; i++) {
			for (int j = 1; j <= column_count; j++) {

				String actualValue = driver
						.findElement(By.xpath("//*[@id=\"customers\"]/tbody/tr[" + (i + 1) + "]/td[" + j + "]"))
						.getText();

				System.out.println("All value "+actualValue);
			}
		}
		
		driver.quit();
	}

	@Test(enabled = true)
	public void testWebtableNew() {
		/*
		 * WebDriverManager.chromedriver().setup(); ChromeOptions options = new
		 * ChromeOptions(); options.addArguments("--remote-allow-origins=*"); WebDriver
		 * driver = new ChromeDriver(options);
		 */
		WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--remote-allow-origins=*");
        // Add any additional options as needed

        // Launch Microsoft Edge browser
        WebDriver driver = new EdgeDriver(options);

		boolean flag = false;

		driver.get("https://aneejian.com/uft-function-click-link-web-table/");
		driver.manage().window().maximize();
		int row_count = driver.findElements(By.xpath("//table[@class=\"table table-hover mt-2 mb-2\"]//tr")).size();

		int column_count = driver.findElements(By.xpath("//table[@class=\"table table-hover mt-2 mb-2\"]//th")).size();

		for (int i = 1; i < row_count; i++) {
			for (int j = 1; j <= column_count; j++) {

				String actualValue = driver.findElement(By.xpath("//tbody/tr[" + (i) + "]/td[" + j + "]")).getText();

				// System.out.println(actualValue);

				if (actualValue.equals("Austin")) {
					flag = true;
					System.out.println("value present here austin::   " + i + " :: " + j);

					//break;
				}
				System.out.println("All value new :: "+actualValue);
			}
		}
		if (flag) {
			System.out.println("Value is present");
		} else {
			System.out.println("Value is not present");

		}

		driver.quit();
	}
}