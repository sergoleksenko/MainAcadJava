import bspb.pages.CurrencyExchangePage;
import bspb.pages.MessagesPage;
import bspb.pages.WelcomePage;
import bspb.utils.BrowserManager;
import bspb.utils.CSVReader;
import bspb.utils.ScreenshotUtils;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.text.DecimalFormat;
import java.util.Iterator;

/**
 * Created by Serg on 4/18/18.
 */
public class BankSaintPetersburgTest {

    private static final String USER_NAME = "Королёва Ольга";
    private static final String CURRENCY_EXCHANGE_SUCCESS = "Payment transferred successfully";

    @DataProvider(name = "messageData")
    public Iterator<Object[]> messageDataFromCsv() {
        return CSVReader.readMessagesFromCsv();
    }

    @BeforeMethod
    public void openBrowser() {
        BrowserManager.open();
    }

    @AfterMethod
    public void closeBrowser(ITestResult testResult) {
        ScreenshotUtils.takeScreenshotIfFailure(testResult);
        BrowserManager.close();
    }

    @Test(description = "login test")
    public void test01Login() {
        WelcomePage welcomePage = BrowserManager.openBspb().login().completeLogin();
        Assert.assertTrue(welcomePage.isUserNameDisplayed(), "There is no user name on the page");
        Assert.assertEquals(USER_NAME, welcomePage.getUserName(), "User name on the page don't equal " + USER_NAME + ".");
    }

    @Test(description = "closing balance test")
    public void test02ClosingBalance() {
        float closingBalance = BrowserManager.openBspb().login().completeLogin().openAccountsStatementsPage().getClosingBalance();
        Assert.assertTrue(closingBalance > 0, "Closing balance is less or equals 0.");
    }

    @Test(description = "currency exchange test")
    public void test03CurrencyExchange() {
        CurrencyExchangePage currencyExchangePage = BrowserManager.openBspb().login().completeLogin().openCurrencyExchangePage();
        String sellingAmount = new DecimalFormat("#0.00").format(currencyExchangePage.getAccountBalance("USD") * 0.1);
        String currencyExchangeSuccessMessage = currencyExchangePage.currencySelling("USD", "RUB", sellingAmount, "Details message for exchange").calculate().confirm().getCurrencyExchangeSuccessMessage();
        Assert.assertEquals(CURRENCY_EXCHANGE_SUCCESS, currencyExchangeSuccessMessage, "Currency exchange was unsuccess.");
    }

    @Test(dataProvider = "messageData", description = "messages test")
    public void test04Messages(String message) {
        MessagesPage messagesPage = BrowserManager.openBspb().login().completeLogin().openMessagesPage().newMessage().sendMessage(message);
        Assert.assertTrue(messagesPage.isMessageSent(message), "Message was not sending.");
    }
}
