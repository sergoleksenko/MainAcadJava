package bspb.pages;

import bspb.utils.BrowserManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Serg on 4/23/18.
 */
public class CurrencyExchangeSuccessPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class, 'alert-success')]")
    private WebElement currencyExchangeSuccessMessage;

    public HeaderPanel onHeader() {
        return new HeaderPanel();
    }

    public MenuPanel onMenu() {
        return new MenuPanel();
    }

    public String getCurrencyExchangeSuccessMessage() {
        logger.info("Getting message after currency exchange");

        return (new WebDriverWait(BrowserManager.browser, 5)).until(ExpectedConditions.visibilityOf(currencyExchangeSuccessMessage)).getText(); //currencyExchangeSuccessMessage.getText();
    }
}
