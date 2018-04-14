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
    private User user = new User(System.getProperty("email"), System.getProperty("password"));

    @BeforeClass
    public void openBrowser() {
        BrowserManager.open();
    }

    @AfterClass
    public void closeBrowser() {
        BrowserManager.close();
    }

    @Test
    public void loginTest() {
        FacebookHomePage facebookHomePage = BrowserManager.openFacebook().login(user);
        Assert.assertTrue(facebookHomePage.isUserProfileLinkDisplayed(), "Couldn't found element on the page,");
    }
}
