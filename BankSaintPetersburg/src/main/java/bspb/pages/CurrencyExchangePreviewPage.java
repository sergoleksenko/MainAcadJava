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

//    public HeaderPanel onHeader() {
//        return new HeaderPanel();
//    }
//
//    public MenuPanel onMenu() {
//        return new MenuPanel();
//    }

    public CurrencyExchangeSuccessPage confirm() {
        WaitHelper waitHelper = new WaitHelper();

        logger.info("Confirming currency exchange");
        waitHelper.waitAndSwitchToFrame(confirmationFrame);
        waitHelper.waitForElementVisible(confirmButton).click();

        BrowserManager.browser.switchTo().defaultContent();

        return new CurrencyExchangeSuccessPage();
    }
}
