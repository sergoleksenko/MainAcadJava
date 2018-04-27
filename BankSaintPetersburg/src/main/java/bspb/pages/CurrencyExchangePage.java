package bspb.pages;

import bspb.utils.ElementHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Serg on 4/22/18.
 */
public class CurrencyExchangePage extends HeaderPanel {

    @FindBy(xpath = "//select[@id = 'acc1']")
    private WebElement fromAccountField;

    @FindBy(xpath = "//select[@id = 'acc2']")
    private WebElement toAccountField;

    @FindBy(xpath = "//input[@id = 'from-amount']")
    private WebElement sellingField;

    @FindBy(xpath = "//textarea[@name = 'payment.details']")
    private WebElement detailsField;

    @FindBy(xpath = "//button[@id = 'forward']")
    private WebElement calculateButton;

//    public HeaderPanel onHeader() {
//        return new HeaderPanel();
//    }

//    public MenuPanel onMenu() {
//        return new MenuPanel();
//    }

    public float getAccountBalance(String accountCurrency) {
        logger.info("Getting account balance");
        String accountBalance = new ElementHelper().getAccountFromComboBox(fromAccountField, accountCurrency).getText().split(":")[1].replace(" ", "").replace("\n", "");
        logger.info("Account balance is " + accountBalance);

        return Float.parseFloat(accountBalance.substring(0, accountBalance.length() - 1));
    }

    public CurrencyExchangePage currencySelling(String accountCurrencyFrom, String accountCurrencyTo, String currencyAmount, String detailsMessage) {
        ElementHelper elementHelper = new ElementHelper();

        logger.info("Choosing accounts and filling fields selling and details");
        elementHelper.getAccountFromComboBox(fromAccountField, accountCurrencyFrom).click();
        elementHelper.getAccountFromComboBox(toAccountField, accountCurrencyTo).click();
        sellingField.sendKeys(currencyAmount);
        detailsField.sendKeys(detailsMessage);

        return new CurrencyExchangePage();
    }

    public CurrencyExchangePreviewPage calculate() {
        logger.info("Clicking on calculate button");
        calculateButton.click();

        return new CurrencyExchangePreviewPage();
    }
}
