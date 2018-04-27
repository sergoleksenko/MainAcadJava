package bspb.pages;

import bspb.utils.BrowserManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Serg on 4/22/18.
 */
public class CurrencyExchangePreviewPage extends BasePage {

    @FindBy(xpath = "//button[@id = 'confirm']")
    private WebElement confirmButton;

    @FindBy(xpath = "//iframe[@id = 'confirmation-frame']")
    private WebElement confirmationFrame;

    public HeaderPanel onHeader() {
        return new HeaderPanel();
    }

    public MenuPanel onMenu() {
        return new MenuPanel();
    }

    public CurrencyExchangeSuccessPage confirm() {
        logger.info("Confirming currency exchange");
        (new WebDriverWait(BrowserManager.browser, 5)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(confirmationFrame));
        (new WebDriverWait(BrowserManager.browser, 5)).until(ExpectedConditions.visibilityOf(confirmButton)).click();
//        confirmButton.click();
        BrowserManager.browser.switchTo().defaultContent();

        return new CurrencyExchangeSuccessPage();
    }
}
