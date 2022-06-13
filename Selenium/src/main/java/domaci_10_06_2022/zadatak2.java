package domaci_10_06_2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class zadatak2 {
    public static void main(String[] args) throws InterruptedException {



        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.manage().window().maximize();

        Random random = new Random();

        String url = "https://geodata.solutions/";
        driver.navigate().to(url);

        // biranje zemlje:

        Select country = new Select(driver.findElement(By.xpath("//*[contains(@id, 'countryId')]")));
        List<WebElement> options = country.getOptions();
        int randomIndex = random.nextInt(options.size());
        country.selectByIndex(randomIndex);
        Thread.sleep(3000);

        // biranje state

        Select state = new Select(driver.findElement(By.xpath("//*[contains(@id, 'stateId')]")));
        List<WebElement> optionsState = state.getOptions();
        int randomIndexState = random.nextInt(optionsState.size());
        state.selectByIndex(randomIndexState);
        Thread.sleep(3000);

        //biranje grada

        Select city = new Select(driver.findElement(By.xpath("//*[contains(@id, 'cityId')]")));
        List<WebElement> optionsCity = city.getOptions();
        int randomIndexCity = random.nextInt(optionsCity.size());
        city.selectByIndex(randomIndexCity);
        Thread.sleep(3000);


        driver.quit();



    }
}
