import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DifferentSportsTest {
    public WebDriver driver;

    @BeforeMethod
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
        driver = new ChromeDriver();
        driver.get(Utils.BASE_URL);
    }

    @Test
    public void watchingDifferentSportsTest() {
        driver.manage().window().maximize();

        WebElement acceptTermsButton = driver.findElement(By.id("onetrust-accept-btn-handler"));
        acceptTermsButton.click();

        WebElement tennisButton = driver.findElement(By.xpath("/html/body/div[5]/div/div[1]/a[3]/div[2]"));
        tennisButton.click();

        WebElement handBallButton = driver.findElement(By.xpath("/html/body/div[5]/div/div[1]/a[5]/div[2]"));
        handBallButton.click();

        WebElement moreSportsButton = driver.findElement(By.className("menuMinority__text"));
        moreSportsButton.click();

        WebElement snowSportsButton = driver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div[2]/div/a[34]/div[2]"));
        Assert.assertEquals(snowSportsButton.getText(), "ZIMSKI SPORTOVI");
        snowSportsButton.click();
    }

    @AfterMethod
    public void teardownTest() {
        driver.quit();
    }
}
