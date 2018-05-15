package bspb.pages;

import bspb.utils.ActionHelper;
import bspb.utils.ElementHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Serg on 4/23/18.
 */
public abstract class HeaderPanel extends MenuPanel {

    @FindBy(xpath = "//span[@class='filter-option pull-left']")
    private WebElement userName;

    @FindBy(xpath = "//span[@class = 'icon-email']")
    private WebElement messagesButton;

    public boolean isUserNameDisplayed() {
        logger.info("Checking whether user name displayed");
        return ElementHelper.isElementDisplayed(userName);
    }

    public String getUserName() {
        logger.info("Getting user name");
        return userName.getText();
    }

    public MessagesPage openMessagesPage() {
        logger.info("Opening Messages page");
        ActionHelper.clickWithJS(messagesButton);
        return new MessagesPage();
    }
}
