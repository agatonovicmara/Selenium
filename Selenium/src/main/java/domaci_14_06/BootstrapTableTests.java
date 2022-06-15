package domaci_14_06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class BootstrapTableTests {

    private WebDriver driver;
    private String baseUrl= "https://s.bootsnipp.com";

    private WebDriverWait wait;

    @BeforeClass

    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @BeforeMethod

    public void beforeMethod(){
        driver.get(baseUrl);
    }

    @Test

    public void EditRow (){

        driver.get(baseUrl + "/iframe/K5yrx");
        Assert.assertEquals(
                driver.getTitle(),
                "Table with Edit and Update Data - Bootsnipp.com",
                "Error- title IS NOT equal to 'Table with Edit and Update Data - Bootsnipp.com'");

        driver.findElement(By.xpath("//tr[@id='d1']/td[5]/button")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class, 'modal-content')]")));
        driver.findElement(By.xpath("//input[@placeholder='First Name']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='Middle Name']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Jelena");
        driver.findElement(By.xpath("//input[@placeholder='Middle Name']")).sendKeys("Dragan");
        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Jovanovic");

        String ime =  driver.findElement(By.xpath("//input[@placeholder='First Name']")).getText();
        String srednjeIme =  driver.findElement(By.xpath("//input[@placeholder='Middle Name']")).getText();
        String prezime = driver.findElement(By.xpath("//input[@placeholder='Last Name']")).getText();

        driver.findElement(By.xpath("//div[contains(@class, 'modal-footer')]/button")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, 'modal-content')]")));

       Assert.assertEquals(
               driver.findElement(By.xpath("//td[@id='f1']")).getText(),
               "Jelena",
               "Error, name does not match");
       Assert.assertEquals(
               driver.findElement(By.xpath("//td[@id='l1']")).getText(),
               "Jovanovic",
               "Error, last name does not match expected");
       Assert.assertEquals(
               driver.findElement(By.xpath("//td[@id='m1']")).getText(),
               "Dragan",
               "Error, middle name does not match expected");
    }

    @Test

    public void deleteRow(){

        driver.get(baseUrl + "/iframe/K5yrx");
        Assert.assertEquals(
                driver.getTitle(),
                "Table with Edit and Update Data - Bootsnipp.com",
                "Error, title is not as expected");

        driver.findElement(By.xpath("//tbody/tr/td[6]/button")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='delete']/div/div")));
        driver.findElement(By.xpath("//div[@id='delete']/div/div/div[3]/button")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='delete']/div/div")));


        List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));

        int countRows = rows.size();

        Assert.assertEquals(
                countRows,
                1,
                "Number of rows does not match expected");






    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
