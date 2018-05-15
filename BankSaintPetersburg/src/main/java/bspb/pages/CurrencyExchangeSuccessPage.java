package bspb.pages;

import bspb.utils.WaitHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Serg on 4/23/18.
 */
public class CurrencyExchangeSuccessPage extends HeaderPanel {

    @FindBy(xpath = "//div[contains(@class, 'alert-success')]")
    private WebElement currencyExchangeSuccessMessage;

    public String getCurrencyExchangeSuccessMessage() {
        logger.info("Getting message after currency exchange");
        return WaitHelper.waitForElementVisible(currencyExchangeSuccessMessage).getText();
    }
}
