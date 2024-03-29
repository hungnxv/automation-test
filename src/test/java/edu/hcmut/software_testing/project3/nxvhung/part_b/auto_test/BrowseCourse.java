package edu.hcmut.software_testing.project3.nxvhung.part_b.auto_test;// Generated by Selenium IDE
import java.time.Duration;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;

  public class BrowseCourse {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<>();
    driver.get("https://school.moodledemo.net/course/index.php");
    driver.manage().window().setSize(new Dimension(1536, 816));
    driver.findElement(By.linkText("Log in")).click();
    driver.findElement(By.cssSelector(".loginform")).click();
    driver.findElement(By.id("username")).click();
    WebElement username = (new WebDriverWait(driver, Duration.ofSeconds(10)))
        .until(ExpectedConditions.elementToBeClickable(By.id("username")));
    username.sendKeys("student");

    driver.findElement(By.id("password")).sendKeys("moodle");
    driver.findElement(By.id("loginbtn")).click();

  }
  @After
  public void tearDown() {
    driver.quit();
  }

  /**
   * main flow
   */
  @Test
  public void tC003001() {

    WebElement artAndMediaLink = (new WebDriverWait(driver, Duration.ofSeconds(10)))
        .until(ExpectedConditions.elementToBeClickable(By.linkText("Art and Media")));
    artAndMediaLink.click();
    WebElement psychologyInCinemaLink = (new WebDriverWait(driver, Duration.ofSeconds(10)))
        .until(ExpectedConditions.elementToBeClickable(By.linkText("Psychology in Cinema")));
    psychologyInCinemaLink.click();

    WebElement psychologyInCinemaHeader = (new WebDriverWait(driver, Duration.ofSeconds(10)))
        .until(ExpectedConditions.elementToBeClickable(By.cssSelector(".h2")));
    assertEquals(psychologyInCinemaHeader.getText(), "Psychology in Cinema");
  }

  /**
   * Student search course
   */
  @Test
  public void tC003002() {

    WebElement toggleButton =  (new WebDriverWait(driver, Duration.ofSeconds(10)))
        .until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn-open > .icon")));
    toggleButton.click();

    driver.findElement(By.name("q")).sendKeys("Psychology in Cinema");
    driver.findElement(By.xpath("//button/i")).click();

    WebElement psychologyInCinemaLink = (new WebDriverWait(driver, Duration.ofSeconds(10)))
        .until(ExpectedConditions.elementToBeClickable(By.linkText("Psychology in Cinema")));
    psychologyInCinemaLink.click();

    WebElement psychologyInCinemaHeader = (new WebDriverWait(driver, Duration.ofSeconds(10)))
        .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".h2")));
    assertEquals(psychologyInCinemaHeader.getText(), "Psychology in Cinema");
  }

    /**
     * students go to the course by direct link
     */
  @Test
  public void tC003003() {

    driver.get("https://school.moodledemo.net/course/view.php?id=6");
    driver.manage().window().setSize(new Dimension(1536, 816));


    WebElement courseTitle = (new WebDriverWait(driver, Duration.ofSeconds(10)))
        .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".h2")));

    assertEquals(courseTitle.getText(), "Class and Conflict in World Cinema");
  }


    /**
     * students go to the non existing or no permission course by direct link
     */
    @Test
    public void tC003004() {

      driver.get("https://school.moodledemo.net/course/view.php?id=100");
      driver.manage().window().setSize(new Dimension(1536, 816));

      WebElement courseTitle = (new WebDriverWait(driver, Duration.ofSeconds(10)))
          .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".errormessage")));

      assertEquals(courseTitle.getText(), "Can't find data record in database table course.");
    }


}
