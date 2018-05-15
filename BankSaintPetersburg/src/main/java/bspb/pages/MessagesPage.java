package bspb.pages;

import bspb.utils.ElementHelper;
import bspb.utils.WaitHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by Serg on 4/22/18.
 */
public class MessagesPage extends HeaderPanel {

    @FindBy(xpath = "//a[@id = 'new-message-btn']")
    private WebElement newMessageButton;

    @FindBy(xpath = "//div[@class = 'one-liner']/span")
    private List<WebElement> messages;

    public NewMessagePage newMessage() {
        logger.info("Opening new message page");
        newMessageButton.click();
        return new NewMessagePage();
    }

    public boolean isMessageSent(String message) {
        logger.info("Checking whether message was sending");
        return ElementHelper.isElementDisplayed(WaitHelper.waitForAllElementsVisible(messages).stream().filter(ms -> ms.getText().contains(message)).findAny().get());
    }
}
