import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

    public WebDriver driver;

    @BeforeMethod
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
        driver = new ChromeDriver();
        driver.get(Utils.BASE_URL);
    }

    @Test
    public void loginAccountTest() {
        driver.manage().window().maximize();

        WebElement acceptTermsButton = driver.findElement(By.id("onetrust-accept-btn-handler"));
        acceptTermsButton.click();

        WebElement loginButton = driver.findElement(By.id("signIn"));
        loginButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"lsid-main-dialog\"]/div/div/h1")));
        LoginForm loginForm = new LoginForm(driver);
        loginForm.enterEmail();
        loginForm.enterPassword();
        loginForm.pressSubmitButton();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("email")));
        WebElement emailText = driver.findElement(By.className("email"));
        Assert.assertEquals(emailText.getText(), loginForm.getEmail());

    }

    @AfterMethod
    public void teardownTest() {
        driver.quit();
    }
}
