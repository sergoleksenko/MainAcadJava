package bspb.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Serg on 4/23/18.
 */
public class NewMessagePage extends BasePage {

    @FindBy(xpath = "//textarea[@name = 'message.text']")
    private WebElement contentField;

    @FindBy(xpath = "//input[@id = 'send-button']")
    private WebElement sendButton;

    public HeaderPanel onHeader() {
        return new HeaderPanel();
    }

    public MenuPanel onMenu() {
        return new MenuPanel();
    }

    public MessagesPage sendMessage(String message) {
        logger.info("Sending new message");
        contentField.sendKeys(message);
        sendButton.click();

        return new MessagesPage();
    }
}
