package Steps;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/*
Task Description
        We need to automate the testing of the a sortable table:
        1. Go to website http://website.multiformis.com/
        2. From main menu click on 'Sort and Tables'
        3. Check if table contains more than 25 records
        4. Sort the data by Age descending
        5. Check if the 1st person in the table is older than 65

        NOTE: In step 2. handle any popup that might appear
*/



public class Main {

    public static WebDriver driver;

  @Test
    public void testpop() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://website.multiformis.com/");

            WebElement tableMenuButton = driver.findElement(By.partialLinkText("Sort and Tables"));

/*      WebDriverWait wait = new WebDriverWait(driver,3);
      Alert alert =  wait.until(alertIsPresent());
           // Alert alert = driver.switchTo().alert();
            alert.dismiss();*/

      WebElement closePopup = driver.findElement(By.xpath("//div[@class='pum-content popmake-content']"));

            tableMenuButton.click();

            WebElement selectEntries = driver.findElement(By.xpath("//select"));
      Select select = new Select(selectEntries);
      select.selectByValue("100");

      List<WebElement> ageList = driver.findElements(By.xpath("//table/tbody/tr/td[8]"));

      System.out.println("List Size =   " +  ageList.size());
      Assert.assertTrue(ageList.size() > 25);

      WebElement ageSort = driver.findElement(By.xpath("//table/thead/tr/th[8]"));
      ageSort.click();
      String ageSortResult = ageSort.getAttribute("class").toString();
      ageSortResult = ageSortResult.substring(ageSortResult.length() - 3);
      System.out.println(ageSortResult);
      while (ageSortResult.equals("asc")) {
          ageSort.click();
          ageSortResult = ageSort.getAttribute("class").toString();
          ageSortResult = ageSortResult.substring(ageSortResult.length() - 3);
      }
    WebElement firstAge = driver.findElement(By.xpath("//table/tbody/tr[1]/td[8]"));
      String firstAgeText = firstAge.getText();
      System.out.println(firstAgeText);
      int firstAgeInt = Integer.parseInt(firstAgeText);
      Assert.assertTrue("Age Assertion",firstAgeInt > 65);

        }






    }


