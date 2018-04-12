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

    public FacebookHomePage login(String email, String password) {
        try {
            emailField.sendKeys(email);
            passwordField.sendKeys(password);
            logInButton.click();
            logger.info("Login success");
        } catch (Exception ex) {
            logger.error("Can't login\n" + ex.getMessage());
        }

        return new FacebookHomePage();
    }
}
