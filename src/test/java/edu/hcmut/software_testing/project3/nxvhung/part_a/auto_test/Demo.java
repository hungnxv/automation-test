package edu.hcmut.software_testing.project3.nxvhung.part_a.auto_test;

import java.util.Objects;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Demo {
	private WebDriver driver;

	/**
	 * This method will be executed before the test start.
	 */
	@Before
	public void initalize() {
		driver = new ChromeDriver();
	}

	@Test
	public void testGoogleSearch() throws InterruptedException {

		// Optional. If not specified, WebDriver searches the PATH for chromedriver.       System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");           WebDriver driver = new ChromeDriver();

		driver.get("http://www.google.com/");

		Thread.sleep(5000);  // Let the user actually see something!

		WebElement searchBox = driver.findElement(By.name("q"));

		searchBox.sendKeys("ChromeDriver");

		searchBox.submit();

		Thread.sleep(5000);  // Let the user actually see something!

		driver.quit();

	}


	@After
	public void quitDriver() {
		if(Objects.nonNull(driver)) {
			driver.quit();
		}
	}
}
