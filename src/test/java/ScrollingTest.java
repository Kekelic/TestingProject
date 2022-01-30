import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ScrollingTest {
    public WebDriver driver;

    @BeforeMethod
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
        driver = new ChromeDriver();
        driver.get(Utils.BASE_URL);

    }

    @Test
    public void scrollingButtonTest() throws InterruptedException {
        driver.manage().window().maximize();

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        WebElement contactButton = driver.findElement(By.xpath("/html/body/div[7]/div/div[1]/div/div[1]/div[2]/div/div[3]/a"));
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();", contactButton);
        Thread.sleep(2000);
        WebElement scrollToTopButton = driver.findElement(By.xpath("//*[@id=\"scroll-to-top\"]"));
        javascriptExecutor.executeScript("arguments[0].click();", scrollToTopButton);
        Thread.sleep(2000);
    }

    @AfterMethod
    public void teardownTest() {
        driver.quit();
    }
}
