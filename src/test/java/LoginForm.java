import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginForm extends PageObject {
    private final String EMAIL = "kekelicstjepan@gmail.com";
    private final String PASSWORD = "testlogin";

    @FindBy(id = "email")
    private WebElement emailTextBox;

    @FindBy(id = "passwd")
    private WebElement passwordTextBox;

    @FindBy(id = "login")
    private WebElement submitButton;

    public LoginForm(WebDriver driver) {
        super(driver);
    }

    public void enterEmail() {
        this.emailTextBox.sendKeys(EMAIL);
    }

    public void enterPassword() {
        this.passwordTextBox.sendKeys(PASSWORD);
    }

    public void pressSubmitButton() {
        this.submitButton.click();
    }

    public String getEmail() {
        return this.EMAIL;
    }

}
