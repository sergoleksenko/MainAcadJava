import bspb.pages.CurrencyExchangePage;
import bspb.pages.MessagesPage;
import bspb.pages.WelcomePage;
import bspb.utils.BrowserManager;
import bspb.utils.CsvReader;
import bspb.utils.TestListener;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.LocalTime;
import java.util.Iterator;

/**
 * Created by Serg on 4/18/18.
 */
@Listeners(TestListener.class)
public class BankSaintPetersburgTest {

    private static final String USER_NAME = "Королёва Ольга";
    private static final String CURRENCY_EXCHANGE_SUCCESS = "Payment transferred successfully";

    @DataProvider(name = "messageData")
    public Iterator<Object[]> messageDataFromCsv() {
        return CsvReader.readMessagesFromCsv();
    }

    @BeforeMethod
    public void openBrowser() {
        BrowserManager.open();
    }

    @AfterMethod
    public void closeBrowser() {
        BrowserManager.close();
    }

    @Test(description = "login test")
    public void test01Login() {
        WelcomePage welcomePage = BrowserManager.openBspb().login().completeLogin();
        Assert.assertTrue(welcomePage.isUserNameDisplayed(), "There is no user name on the page");
        Assert.assertEquals(welcomePage.getUserName(), USER_NAME, "User name on the page don't equal " + USER_NAME + ".");
    }

    @Test(description = "closing balance test")
    public void test02ClosingBalance() {
        float closingBalance = BrowserManager.openBspb().login().completeLogin().openAccountsStatementsPage().getClosingBalance();
        Assert.assertTrue(closingBalance > 0, "Closing balance is less or equals 0.");
    }

    @Test(description = "currency exchange test")
    public void test03CurrencyExchange() {
        CurrencyExchangePage currencyExchangePage = BrowserManager.openBspb().login().completeLogin().openCurrencyExchangePage();
        String currencyExchangeSuccessMessage = currencyExchangePage.fillFormForCurrencySelling("USD", "RUB", 0.1, "Details message for exchange").clickCalculateButton().confirm().getCurrencyExchangeSuccessMessage();
        Assert.assertEquals(currencyExchangeSuccessMessage, CURRENCY_EXCHANGE_SUCCESS, "Currency exchange was unsuccess.");
    }

    @Test(dataProvider = "messageData", description = "messages test")
    public void test04Messages(String message) {
        message = message + " - " + LocalTime.now();
        MessagesPage messagesPage = BrowserManager.openBspb().login().completeLogin().openMessagesPage().newMessage().sendMessage(message);
        Assert.assertTrue(messagesPage.isMessageSent(message), "Message was not sending.");
    }
}
