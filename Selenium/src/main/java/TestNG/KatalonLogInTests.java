package TestNG;

import com.sun.source.tree.AssertTree;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class KatalonLogInTests {

    private WebDriver driver;
    private String baseUrl= "https://cms.demo.katalon.com";

    @BeforeClass

    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @BeforeMethod
    public void beforeMethod() {
        driver.get(baseUrl);
    }

    @Test

    public void visitLoginPageFromNavBar(){

        //driver.get(baseUrl+"/");
        driver.findElement(By.xpath("//div[@id='primary-menu']/ul/li[3]/a")).click();
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "My account – Katalon Shop", "ERROR Not a match");

        Assert.assertTrue(driver.getCurrentUrl().contains("/my-account"), "ERROR not ok");

    }

    @Test
    public void CheckInputTypes(){

        driver.get(baseUrl + "/my-account");
        Assert.assertEquals(
                driver.findElement(By.id("username")).getAttribute("type"),
                "text",
                "Email input does not have valid type.");


        Assert.assertEquals(
                driver.findElement(By.id("password")).getAttribute("type"),
                "password",
                "Password input does not have valid type.");


        Assert.assertEquals(
                driver.findElement(By.id("rememberme")).getAttribute("type"),
                "checkbox",
                "Remember me checkbox does not have valid type.");

        Assert.assertFalse(
                driver.findElement(By.id("rememberme")).isSelected(),
                "Remeber me checkbox should be unchecked.");


    }

    @Test
    public void DisplayErrorWhenCredentialsAreWrong(){

        driver.get(baseUrl + "/my-account");
        driver.findElement(By.name("username")).sendKeys("invalidemail@gmail.com");
        driver.findElement(By.name("password")).sendKeys("invalid123");
        driver.findElement(By.name("login")).click();

        Assert.assertTrue(
                driver.findElement(By.xpath("//*[contains(@class, 'woocommerce-error')]")).isDisplayed(),
                "Error element exists on the page when wrong ccredentials are provided.");


        Assert.assertEquals(
                driver.findElement(By.xpath("//*[contains(@class, 'woocommerce-error')]/li")).getText(),
                "ERROR: Invalid email address",
                "Text does not match expected text.");

        Assert.assertTrue(driver.getCurrentUrl().contains("/my-account"),
                "[ERROR] We moved away from the page my account'");





    }

    @AfterClass

    public void afterClass(){
        driver.quit();
    }


}
