package bspb.pages;

import bspb.utils.ElementHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Serg on 4/22/18.
 */
public class CurrencyExchangePage extends BasePage {

    @FindBy(xpath = "//select[@id = 'acc1']")
    private WebElement fromAccountField;

    @FindBy(xpath = "//select[@id = 'acc2']")
    private WebElement toAccountField;

    @FindBy(xpath = "//input[@id = 'from-amount']")
    private WebElement sellingField;

    @FindBy(xpath = "//textarea[@name = 'payment.details']")
    private WebElement detailsField;

    @FindBy(xpath = "//input[@id = 'forward']")
    private WebElement calculateButton;

    public HeaderPanel onHeader() {
        return new HeaderPanel();
    }

    public MenuPanel onMenu() {
        return new MenuPanel();
    }

    public CurrencyExchangePreviewPage calculate(float currencyAmount, String detailsMessage) throws InterruptedException {
        ElementHelper elementHelper = new ElementHelper();
        logger.info("Clicking on calculate button");

        elementHelper.selectDataFromComboBox(fromAccountField, "USD");
        elementHelper.selectDataFromComboBox(toAccountField, "RUB");
        sellingField.sendKeys(Float.toString(currencyAmount));
        detailsField.sendKeys(detailsMessage);
        calculateButton.click();

        return new CurrencyExchangePreviewPage();
    }
}
