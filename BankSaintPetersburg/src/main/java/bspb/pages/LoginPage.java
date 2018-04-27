package bspb.pages;

import bspb.utils.BrowserManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Serg on 4/22/18.
 */
public class LoginPage {

    private Logger logger = LogManager.getLogger(this.getClass().getName());

    @FindBy(xpath = "//button[@id = 'login-button']")
    private WebElement loginButton;

    @FindBy(xpath = "//button[@id = 'login-otp-button']")
    private WebElement completeLoginButton;

    public LoginPage() {
        PropertyConfigurator.configure("log4j.properties");
        PageFactory.initElements(BrowserManager.browser, this);
    }

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
