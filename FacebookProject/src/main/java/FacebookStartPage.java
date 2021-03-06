import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Serg on 4/2/18.
 */
public class FacebookStartPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class, 'menu_login_container')]//input[@type = 'email']")
    private WebElement emailField;

    @FindBy(xpath = "//div[contains(@class , 'menu_login_container')]//input[@type = 'password']")
    private WebElement passwordField;

    @FindBy(xpath = "//div[contains(@class , 'menu_login_container')]//input[@value = 'Log In']")
    private WebElement logInButton;

    public FacebookHomePage login(User user) {
        logger.info("Try login to Facebook");
        emailField.sendKeys(user.getEmail());
        passwordField.sendKeys(user.getPassword());
        logInButton.click();

        return new FacebookHomePage();
    }
}
