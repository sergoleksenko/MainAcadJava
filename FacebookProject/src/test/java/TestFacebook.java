import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
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
        FacebookHomePage facebookHomePage = BrowserManager.openFacebook().login(user);
        Assert.assertTrue(facebookHomePage.isUserProfileLinkDisplayed(), "Couldn't found element on the page,");
        System.out.println("loginTest");
    }

    @Test
    public void test02Login() {
        FacebookHomePage facebookHomePage = BrowserManager.openFacebook().login(user);
        Assert.assertTrue(facebookHomePage.isUserProfileLinkDisplayed(), "Couldn't found element on the page,");
        System.out.println("loginTest");
    }

    @Test
    public void test03Login() {
        FacebookHomePage facebookHomePage = BrowserManager.openFacebook().login(user);
        Assert.assertTrue(facebookHomePage.isUserProfileLinkDisplayed(), "Couldn't found element on the page,");
        System.out.println("loginTest");
    }

    @Test
    public void test04Login() {
        FacebookHomePage facebookHomePage = BrowserManager.openFacebook().login(user);
        Assert.assertTrue(facebookHomePage.isUserProfileLinkDisplayed(), "Couldn't found element on the page,");
        System.out.println("loginTest");
    }
}
