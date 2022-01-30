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

public class AddingFavoriteTeamTest {
    public WebDriver driver;
    private static String favoriteTeam = "Osijek";

    @BeforeMethod
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
        driver = new ChromeDriver();
        driver.get(Utils.BASE_URL);
    }

    @Test
    public void addingFavoriteTeamTest() {
        driver.manage().window().maximize();

        WebElement favoriteTeamsButton = driver.findElement(By.className("menuTop__text"));
        favoriteTeamsButton.click();

        WebElement addTeamButton = driver.findElement(By.className("leftMenu__buttonBlock"));
        addTeamButton.click();

        WebElement searchTeamTextBox = driver.findElement(By.className("searchInput__input"));
        searchTeamTextBox.sendKeys(favoriteTeam);

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("myTeamsIcon__myTeams")));
        WebElement markAsFavoriteButton = driver.findElement(By.className("myTeamsIcon__myTeams"));
        markAsFavoriteButton.click();

        WebElement closeButton = driver.findElement(By.className("modal__closeButton"));
        closeButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("leftMenu__text")));
        WebElement favoriteTeam = driver.findElement(By.className("leftMenu__text"));

        Assert.assertEquals(favoriteTeam.getText(), "Osijek");
    }

    @AfterMethod
    public void teardownTest() {
        driver.quit();
    }
}
