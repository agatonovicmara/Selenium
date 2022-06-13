package domaci_09_06_2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class zadatak2 {
    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.manage().window().maximize();

        String url = "https://www.tutorialrepublic.com/snippets/bootstrap/table-with-add-and-delete-row-feature.php";

        driver.navigate().to(url);

        // Adding 5 new rows into the table, all with the same data.

        for (int i = 1; i <=5; i++) {
            driver.findElement(By.xpath("//button[contains(@class, 'btn btn-info add-new')]")).click();
            driver.findElement(By.name("name")).sendKeys("Mara");
            driver.findElement(By.name("department")).sendKeys("IT");
            driver.findElement(By.name("phone")).sendKeys("09876543");
            driver.findElement(By.xpath("//tbody//tr[last()]/td[last()]/a[1]")).click();

        }













        //driver.quit();



    }
}
