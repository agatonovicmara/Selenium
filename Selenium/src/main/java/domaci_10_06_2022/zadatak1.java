package domaci_10_06_2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class zadatak1 {
    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.manage().window().maximize();

        String url = "https://s.bootsnipp.com/iframe/Dq2X";
        driver.navigate().to(url);

        List<WebElement>alerts=driver.findElements(By.xpath("//div[contains(@class, 'col-md-12')]/div"));

        for (int i = 0; i < alerts.size(); i++) {
            driver.findElement(By.xpath("//div[contains(@class, 'col-md-12')]/div[last()]/button[contains(@class, 'close')]"))
                    .click();
            System.out.println("Element obrisan.");
            Thread.sleep(3000);
        }


        driver.quit();

    }
}
