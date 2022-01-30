import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class NextDayMatchTest {
    public WebDriver driver;

    @BeforeMethod
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
        driver = new ChromeDriver();
        driver.get(Utils.BASE_URL);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void nextDayMatchTest() {
        driver.manage().window().maximize();

        WebElement acceptTermsButton = driver.findElement(By.id("onetrust-accept-btn-handler"));
        acceptTermsButton.click();

        WebElement calendarButton = driver.findElement(By.className("calendar__datepicker"));
        calendarButton.click();

        WebElement pickDayButton = driver.findElement(By.xpath("//*[@id=\"live-table\"]/div[1]/div[2]/div/div[2]/div[2]/div[9]"));
        pickDayButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("event__match")));
        WebElement firstMatch = driver.findElement(By.className("event__match"));
        firstMatch.click();

    }

    @AfterMethod
    public void teardownTest() {
        driver.quit();
    }
}
