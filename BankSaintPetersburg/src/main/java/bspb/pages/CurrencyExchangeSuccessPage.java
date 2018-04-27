package bspb.pages;

import bspb.utils.WaitHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

        return new WaitHelper().waitForElementVisible(currencyExchangeSuccessMessage).getText();
    }
}
