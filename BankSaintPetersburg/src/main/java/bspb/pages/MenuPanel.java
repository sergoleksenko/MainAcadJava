package bspb.pages;

import bspb.utils.ActionHelper;
import bspb.utils.BrowserManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Serg on 4/23/18.
 */
public abstract class MenuPanel {

    protected Logger logger = LogManager.getLogger(this.getClass().getName());

    @FindBy(xpath = "//div[@class = 'navbar-inner']//li[@id = 'accounts']")
    private WebElement accountsMenu;

    @FindBy(xpath = "//a[@id = 'statements-statement']")
    private WebElement statementsMenuItem;

    @FindBy(xpath = "//div[@class = 'navbar-inner']//li[@id = 'currency']")
    private WebElement currencyMenu;

    @FindBy(xpath = "//a[@id = 'currency-exchange']")
    private WebElement exchangeMenuItem;

    public MenuPanel() {
        PropertyConfigurator.configure("log4j.properties");
        PageFactory.initElements(BrowserManager.getBrowser(), this);
    }

    public AccountsStatementsPage openAccountsStatementsPage() {
        logger.info("Opening Statements page");
        ActionHelper.moveToElement(accountsMenu);
        statementsMenuItem.click();
        return new AccountsStatementsPage();
    }

    public CurrencyExchangePage openCurrencyExchangePage() {
        logger.info("Opening Currency Exchange page");
        ActionHelper.moveToElement(currencyMenu);
        exchangeMenuItem.click();
        return new CurrencyExchangePage();
    }
}
