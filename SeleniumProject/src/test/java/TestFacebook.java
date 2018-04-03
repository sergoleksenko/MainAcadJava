import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Serg on 4/2/18.
 */
public class TestFacebook {

    /*
    Input your own email/password for Facebook
    Also you have to copy chrome driver for your OS into SeleniumProject/drivers directory
    */
    private static final String EMAIL = "";
    private static final String PASSWORD = "";

    @BeforeClass
    public void openBrowser() {
        Browser.open();
    }

    @AfterClass
    public void closeBrowser() {
        Browser.close();
    }

    @Test
    public void loginTest() {
        FacebookHomePage facebookHomePage = Browser.openWebPage("https://www.facebook.com").login(EMAIL, PASSWORD);
        Assert.assertTrue(facebookHomePage.isUserProfileLinkDisplayed());
    }
}
