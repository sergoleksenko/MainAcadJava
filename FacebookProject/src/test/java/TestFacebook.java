import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by Serg on 4/2/18.
 */
public class TestFacebook {

    /*
    Input your own email/password for Facebook
    Also you have to copy chrome driver for your OS into SeleniumProject/drivers directory
    */
    private User user = new User(System.getProperty("email"), System.getProperty("password"));

    @BeforeMethod
    public void openBrowser() {
        BrowserManager.open();
    }

    @AfterMethod
    public void closeBrowser() {
        BrowserManager.close();
    }

    @Test
    public void loginTest() throws InterruptedException {
        FacebookHomePage facebookHomePage = BrowserManager.openFacebook().login(user);
        Thread.sleep(5000);
        Assert.assertTrue(facebookHomePage.isUserProfileLinkDisplayed(), "Couldn't found element on the page,");
        System.out.println("loginTest");
    }
}
