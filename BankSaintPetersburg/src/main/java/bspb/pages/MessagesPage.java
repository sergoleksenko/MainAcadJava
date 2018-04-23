package bspb.pages;

import bspb.utils.BrowserManager;
import bspb.utils.ElementHelper;
import bspb.utils.WaitHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by Serg on 4/22/18.
 */
public class MessagesPage extends BasePage {

    @FindBy(xpath = "//a[@id = 'new-message-btn']")
    private WebElement newMessageButton;

    @FindBy(xpath = "//div[@class = 'one-liner']/span")
    private List<WebElement> messages;

    public HeaderPanel onHeader() {
        return new HeaderPanel();
    }

    public MenuPanel onMenu() {
        return new MenuPanel();
    }

    public NewMessagePage newMessage() {
        logger.info("Opening new message page");
        newMessageButton.click();

        return new NewMessagePage();
    }

    public boolean isMessageSent(String message) {
        ElementHelper elementHelper = new ElementHelper();

        logger.info("Checking whether message was sending");
        for (WebElement element : new WaitHelper().waitForAllElementsVisible(messages)) {
            if (elementHelper.isElementContainsText(element, message)) {
                return true;
            }
        }

        return false;
    }
}
