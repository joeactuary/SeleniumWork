package Steps;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class Course {

    public static WebDriver driver;

    @Test
    public void courseTest() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
       // driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver,5);
        driver.get("https://formy-project.herokuapp.com");

        WebElement keyAndMousePress = driver.findElement(By.xpath("//a[@href='/keypress' and@class='btn btn-lg']"));
        keyAndMousePress.click();

       // Thread.sleep(1000);


       // WebElement nameBox = wait.until(ExpectedConditions.elementToBeClickable(By.id("name")));
        WebElement nameBox = driver.findElement(By.id("name"));
        nameBox.click();
        nameBox.sendKeys("Oliver");

        WebElement submitButton = driver.findElement(By.id("button"));
        submitButton.click();
    }


    @Test
    public void switchWindows() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com");

        WebElement aut = driver.findElement(By.xpath("//a[@href='/switch-window' and@class='btn btn-lg']"));
        aut.click();

        Thread.sleep(1000);

        String handleOrig = driver.getWindowHandle();
        String handleNew = "";
        System.out.println(handleOrig);

        WebElement openNewTabButton = driver.findElement(By.id("new-tab-button"));
        openNewTabButton.click();
        Thread.sleep(1000);
        String handleTemp = driver.getWindowHandle();

        Set<String> handles = driver.getWindowHandles();
        //  String joe = handles[1].t;


        for (String handle : handles) {
            System.out.println(handle);
            handleNew = handle;
            // driver.switchTo().window(handle);
        }

        driver.switchTo().window(handleOrig);
        driver.switchTo().window(handleNew);
        System.out.println("Handle Original =   " + handleOrig);
        System.out.println("Handle Temp =   " + handleTemp);
        System.out.println("Handle New =   " + handleNew);

    }

    @Test
    public void testAlert() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com");

        WebElement aut = driver.findElement(By.xpath("//a[@href='/switch-window' and@class='btn btn-lg']"));
        aut.click();

        Thread.sleep(1000);


        WebElement openNewAlert = driver.findElement(By.id("alert-button"));
        openNewAlert.click();
        Thread.sleep(1000);

        Alert alert = driver.switchTo().alert();
        alert.accept();



    }

    @Test
    public void jsTest() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com");

        WebElement aut = driver.findElement(By.xpath("//a[@href='/modal' and@class='btn btn-lg']"));
        aut.click();

        Thread.sleep(1000);


        WebElement modalButton = driver.findElement(By.id("modal-button"));
        modalButton.click();
        Thread.sleep(1000);

        WebElement closeButton = driver.findElement(By.id("close-button"));
        closeButton.click();
        Thread.sleep(1000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
     //   js.executeScript("arguments[0].click();", closeButton);

    }

    @Test
    public void dragNDrop() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com");

        WebElement aut = driver.findElement(By.xpath("//a[@href='/dragdrop' and@class='btn btn-lg']"));
               aut.click();
        driver.get("https://formy-project.herokuapp.com/dragdrop");

        Thread.sleep(1000);

        //*************************************************************************


        WebElement image = driver.findElement(By.id("image"));

        WebElement box = driver.findElement(By.id("box"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(image,box).build().perform();

    }

    @Test
    public void radioButton() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/radiobutton");



        WebElement radioButton1 = driver.findElement(By.cssSelector("input[value='option1']"));
        WebElement radioButton2 = driver.findElement(By.cssSelector("input[value='option2']"));
        WebElement radioButton3 = driver.findElement(By.cssSelector("input[value='option3']"));
            radioButton2.click();
            Thread.sleep(5000);
        radioButton1.click();
        Thread.sleep(5000);


    }

    @Test
    public void datePicker() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/datepicker");



        WebElement dateField = driver.findElement(By.cssSelector("input#datepicker"));
        dateField.sendKeys("5/26/2022",Keys.RETURN);


    }

    @Test
    public void dropDown() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/dropdown");



        WebElement dropDownButton = driver.findElement(By.cssSelector("button#dropdownMenuButton"));
        dropDownButton.click();
        WebElement pickModal = driver.findElement(By.xpath("(//a[text()='Modal'])[2]"));
        pickModal.click();


    }

    @Test
    public void filerUpload() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/dropdown");



        WebElement dropDownButton = driver.findElement(By.cssSelector("button#dropdownMenuButton"));
        dropDownButton.click();
        WebElement pickModal = driver.findElement(By.xpath("(//a[text()='Modal'])[2]"));
        pickModal.click();


    }


}




