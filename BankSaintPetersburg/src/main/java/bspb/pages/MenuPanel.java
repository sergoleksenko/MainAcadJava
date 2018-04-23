package bspb.pages;

import bspb.pages.AccountsStatementsPage;
import bspb.pages.CurrencyExchangePage;
import bspb.utils.BrowserManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Serg on 4/23/18.
 */
public class MenuPanel {

    private Logger logger = LogManager.getLogger(this.getClass().getName());

    @FindBy(xpath = "//a[@id = 'accounts-index']")
    private WebElement accountsMenu;

    @FindBy(xpath = "//a[@id = 'statements-statement']")
    private WebElement statementsMenuItem;

    @FindBy(xpath = "//a[@id = 'currency-rates']")
    private WebElement currencyMenu;

    @FindBy(xpath = "//a[@id = 'currency-exchange']")
    private WebElement exchangeMenuItem;

    public MenuPanel() {
        PropertyConfigurator.configure("log4j.properties");
        PageFactory.initElements(BrowserManager.browser, this);
    }

    public AccountsStatementsPage openAccountsStatementsPage() {
        Actions actions = new Actions(BrowserManager.browser);

        logger.info("Opening Statements page");
        actions.moveToElement(accountsMenu).build().perform();
        statementsMenuItem.click();

        return new AccountsStatementsPage();
    }

    public CurrencyExchangePage openCurrencyExchangePage() {
        Actions actions = new Actions(BrowserManager.browser);

        logger.info("Opening Currency Exchange  page");
        actions.moveToElement(currencyMenu).build().perform();
        exchangeMenuItem.click();

        return new CurrencyExchangePage();
    }
}
