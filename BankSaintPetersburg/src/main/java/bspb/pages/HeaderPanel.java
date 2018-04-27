package bspb.pages;

import bspb.utils.BrowserManager;
import bspb.utils.ElementHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Serg on 4/23/18.
 */
public class HeaderPanel {

    private Logger logger = LogManager.getLogger(this.getClass().getName());

    @FindBy(xpath = "//span[@class='filter-option pull-left']")
    private WebElement userName;

    @FindBy(xpath = "//span[@class = 'icon-email']")
    private WebElement messagesButton;

    public HeaderPanel() {
        PropertyConfigurator.configure("log4j.properties");
        PageFactory.initElements(BrowserManager.browser, this);
    }

    public boolean isUserNameDisplayed() {
        logger.info("Checking whether user name displayed");

        return new ElementHelper().isElementDisplayed(userName);
    }

    public String getUserName() {
        logger.info("Getting user name");

        return userName.getText();
    }

    public MessagesPage openMessagesPage() {
        logger.info("Opening Messages page");
        messagesButton.click();

        return new MessagesPage();
    }
}
