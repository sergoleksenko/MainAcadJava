import bspb.pages.CurrencyExchangePage;
import bspb.pages.MessagesPage;
import bspb.pages.WelcomePage;
import bspb.utils.BrowserManager;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.DecimalFormat;

/**
 * Created by Serg on 4/18/18.
 */
public class BankSaintPetersburgTest {

    private static final String USER_NAME = "Королёва Ольга";
    private static final String CURRENCY_EXCHANGE_SUCCESS = "Payment transferred successfully";
    private static final String MESSAGE = "Test message in the SaintPetersburg bank application - " + java.time.LocalTime.now();

    @BeforeMethod
    public void openBrowser() {
        BrowserManager.open();
    }

    @AfterMethod
    public void closeBrowser() {
        BrowserManager.close();
    }

    @Test
    public void test01Login() {
        WelcomePage welcomePage = BrowserManager.openBspb().login().completeLogin();
        Assert.assertTrue(welcomePage.isUserNameDisplayed(), "There is no user name on the page");
        Assert.assertEquals(USER_NAME, welcomePage.getUserName(), "User name on the page don't equal " + USER_NAME + ".");
    }

    @Test
    public void test02ClosingBalance() {
        float closingBalance = BrowserManager.openBspb().login().completeLogin().openAccountsStatementsPage().getClosingBalance();
        Assert.assertTrue(closingBalance > 0, "Closing balance is less or equals 0.");
    }

    @Test
    public void test03CurrencyExchange() {
        CurrencyExchangePage currencyExchangePage = BrowserManager.openBspb().login().completeLogin().openCurrencyExchangePage();
        String sellingAmount = new DecimalFormat("#0.00").format(currencyExchangePage.getAccountBalance("USD") * 0.1);
        String currencyExchangeSuccessMessage = currencyExchangePage.currencySelling("USD", "RUB", sellingAmount, "Details message for exchange").calculate().confirm().getCurrencyExchangeSuccessMessage();
        Assert.assertEquals(CURRENCY_EXCHANGE_SUCCESS, currencyExchangeSuccessMessage, "Currency exchange was unsuccess.");
    }

    @Test
    public void test04Messages() {
        MessagesPage messagesPage = BrowserManager.openBspb().login().completeLogin().openMessagesPage().newMessage().sendMessage(MESSAGE);
        Assert.assertTrue(messagesPage.isMessageSent(MESSAGE), "Message was not sending.");
    }
}
