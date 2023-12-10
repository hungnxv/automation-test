package edu.hcmut.software_testing.project3.nxvhung.part_b.auto_test;// Generated by Selenium IDE
import java.time.Duration;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QuizTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
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
  @Test
  public void tC004001() {
    driver.findElement(By.cssSelector(".category:nth-child(2) .categoryname")).click();
    {
      WebElement element = driver.findElement(By.linkText("Mount Orange Community"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    driver.findElement(By.linkText("Mindful course creation")).click();
    js.executeScript("window.scrollTo(0,58)");
    driver.findElement(By.xpath("(//a[contains(@href, \'https://school.moodledemo.net/mod/quiz/view.php?id=978\')])[3]")).click();
    driver.findElement(By.xpath("//button[contains(.,\'Re-attempt quiz\')]")).click();
    driver.findElement(By.id("id_submitbutton")).click();
    driver.findElement(By.cssSelector("#question-101-1 .r0:nth-child(1)")).click();
    driver.findElement(By.id("q101:1_choice0")).click();
    driver.findElement(By.id("q101:2_answer0")).click();
    driver.findElement(By.id("q101:3_answer1")).click();
    driver.findElement(By.cssSelector("#question-101-4 .r0:nth-child(1)")).click();
    driver.findElement(By.id("q101:4_choice0")).click();
    driver.findElement(By.id("q101:5_answer0")).click();
    driver.findElement(By.id("mod_quiz-next-nav")).click();
    driver.findElement(By.xpath("//form[@id=\'frm-finishattempt\']/button")).click();
    driver.findElement(By.cssSelector(".modal-footer > .btn-primary")).click();
    js.executeScript("window.scrollTo(0,1253)");
    driver.findElement(By.cssSelector(".submitbtns > .mod_quiz-next-nav")).click();
  }
}
