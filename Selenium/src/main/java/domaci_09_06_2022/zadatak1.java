package domaci_09_06_2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;

public class zadatak1 {
    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.manage().window().maximize();

        String url = "https://s.bootsnipp.com/iframe/WaXlr";

        driver.get(url);

        List<WebElement>rejting=driver.findElements(By.xpath("//button[contains(@id, 'rating-star-')]"));

        Scanner s = new Scanner(System.in);
        System.out.println("Unesite rejting od 0 do 5: ");
        int n = s.nextInt();

        rejting.get(n-1).click();

        Thread.sleep(5000);


        driver.quit();


    }
}