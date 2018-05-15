package bspb.pages;

import bspb.utils.BrowserManager;
import bspb.utils.WaitHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Serg on 4/22/18.
 */
public class CurrencyExchangePreviewPage extends HeaderPanel {

    @FindBy(xpath = "//button[@id = 'confirm']")
    private WebElement confirmButton;

    @FindBy(xpath = "//iframe[@id = 'confirmation-frame']")
    private WebElement confirmationFrame;

    public CurrencyExchangeSuccessPage confirm() {
        logger.info("Confirming currency exchange");
        WaitHelper.waitAndSwitchToFrame(confirmationFrame);
        WaitHelper.waitForElementVisible(confirmButton).click();
        BrowserManager.getBrowser().switchTo().defaultContent();
        return new CurrencyExchangeSuccessPage();
    }
}
