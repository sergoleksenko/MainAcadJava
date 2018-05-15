package bspb.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Serg on 4/23/18.
 */
public class NewMessagePage extends HeaderPanel {

    @FindBy(xpath = "//textarea[@name = 'message.text']")
    private WebElement contentField;

    @FindBy(xpath = "//button[@id = 'send-button']")
    private WebElement sendButton;

    public MessagesPage sendMessage(String message) {
        logger.info("Sending new message");
        contentField.sendKeys(message);
        sendButton.click();
        return new MessagesPage();
    }
}
