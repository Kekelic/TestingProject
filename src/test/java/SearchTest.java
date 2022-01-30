import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SearchTest {
    public WebDriver driver;

    @BeforeMethod
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
        driver = new ChromeDriver();
        driver.get(Utils.BASE_URL);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void searchTeamTest() {
        driver.manage().window().maximize();

        WebElement searchButton = driver.findElement(By.className("searchIcon___1425yUB"));
        searchButton.click();

        WebElement searchTextBox = driver.findElement(By.className("searchInput__input"));
        searchTextBox.sendKeys("Chelsea");

        WebElement searchedText = driver.findElement(By.className("searchResult__participantName"));
        Assert.assertEquals(searchedText.getText(), "Chelsea (Engleska)");

        searchTextBox.clear();
        searchTextBox.sendKeys("Osijek");

        searchedText = driver.findElement(By.className("searchResult__participantName"));
        Assert.assertEquals(searchedText.getText(), "Osijek (Hrvatska)");
        searchedText.click();
    }

    @AfterMethod
    public void teardownTest() {
        driver.quit();
    }
}
