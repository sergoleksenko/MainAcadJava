package bspb.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Serg on 4/22/18.
 */
public class LoginPage extends BasePage {

    @FindBy(xpath = "//button[@id = 'login-button']")
    private WebElement loginButton;

    @FindBy(xpath = "//button[@id = 'login-otp-button']")
    private WebElement completeLoginButton;

    public LoginPage login() {
        logger.info("Trying login into idemo.bspb.ru");
        loginButton.click();

        return new LoginPage();
    }

    public WelcomePage completeLogin() {
        logger.info("Complete login into idemo.bspb.ru");
        completeLoginButton.click();

        return new WelcomePage();
    }
}
