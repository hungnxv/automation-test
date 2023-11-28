package edu.hcmut.software_testing.project3.factory;

import java.util.Objects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public final class DriverFactory {

  public static WebDriver createDriver(Browser browser) {
    if(Objects.isNull(browser)) {
      throw new IllegalArgumentException("Browser is null");
    }

    switch (browser) {
      case CHROME -> {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        return driver;
      }
      default ->  throw new UnsupportedOperationException("Not supported");
    }

  }

}
