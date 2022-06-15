package domaci_13_06_2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Boomf_kocka {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.manage().window().maximize();

        String url = "https://boomf.com/apps/proxy/boomf-bomb/i-bloody-love-you";
        driver.navigate().to(url);

        //Postavljanje slike na front

        driver.findElement(By.xpath("//img[@alt='image 1']")).click();
        driver.findElement(By.xpath("//img[@alt='+ Add photo']")).click();

        File slika1 = new File("src/main/resources/front_marija_mitrovic.jpg");
        driver.findElement(By.xpath("//input[@id='imageUpload']")).sendKeys(slika1.getAbsolutePath());

       // wait.until(ExpectedConditions.numberOfElementsToBe(By.className("sc-ftvSup"), 1));

        driver.findElement(By.xpath("//div[contains(@class, 'sc-ftvSup kAzmBp')]/div/div/img")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class, 'sc-iXxrte')]")));

        driver.findElement(By.xpath("//div[contains(@class, 'ezVUKM')]/button")).click();

        //Postavljanje slike na left

        driver.findElement(By.xpath("//img[@alt='image 2']")).click();
        driver.findElement(By.xpath("//img[@alt='+ Add photo']")).click();

        File slika2 = new File("src/main/resources/left_marija_mitrovic.jpg");
        driver.findElement(By.xpath("//input[@id='imageUpload']")).sendKeys(slika2.getAbsolutePath());

       // wait.until(ExpectedConditions.numberOfElementsToBe(By.className("sc-ftvSup"), 2));

        driver.findElement(By.xpath("//div[2][contains(@class, 'haLJiC')]/div/img")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class, 'sc-iXxrte')]")));

        driver.findElement(By.xpath("//div[contains(@class, 'ezVUKM')]/button")).click();

        //Postavljanje slike na back

        driver.findElement(By.xpath("//img[@alt='image 3']")).click();
        driver.findElement(By.xpath("//img[@alt='+ Add photo']")).click();

        File slika3 = new File("src/main/resources/back_marija_mitrovic.jpg");
        driver.findElement(By.xpath("//input[@id='imageUpload']")).sendKeys(slika3.getAbsolutePath());

       // wait.until(ExpectedConditions.numberOfElementsToBe(By.className("sc-ftvSup"), 3));

        driver.findElement(By.xpath("//div[3][contains(@class, 'haLJiC')]/div/img")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class, 'sc-iXxrte')]")));

        driver.findElement(By.xpath("//div[contains(@class, 'ezVUKM')]/button")).click();

        //Postavlja sliku na right

        driver.findElement(By.xpath("//img[@alt='image 4']")).click();
        driver.findElement(By.xpath("//img[@alt='+ Add photo']")).click();

        File slika4 = new File("src/main/resources/right_marija_mitrovic.jpg");
        driver.findElement(By.xpath("//input[@id='imageUpload']")).sendKeys(slika4.getAbsolutePath());

        //wait.until(ExpectedConditions.numberOfElementsToBe(By.className("sc-ftvSup"), 4));

        driver.findElement(By.xpath("//div[4][contains(@class, 'haLJiC')]/div/img")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class, 'sc-iXxrte')]")));

        driver.findElement(By.xpath("//div[contains(@class, 'ezVUKM')]/button")).click();

        List<WebElement> konfete = driver.findElements(By.xpath("//div[contains(@class, 'fajlzv')]/div/img"));
        Random random = new Random();
        int randomIndex = random.nextInt(konfete.size());
        konfete.get(randomIndex);

        driver.findElement(By.xpath("//div[contains(@class, 'sc-gicCDI')]/button")).click();

       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@action='error']")));

       WebElement error = driver.findElement(By.xpath("//*[@action='error']"));
       String actionError = error.getAttribute("action");

        System.out.println("Pojavio se alert: "+actionError);

        driver.quit();






    }


}
