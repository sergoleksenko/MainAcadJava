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

    private void login() {
        FacebookHomePage facebookHomePage = BrowserManager.openFacebook().login(user);
        Assert.assertTrue(facebookHomePage.isUserProfileLinkDisplayed(), "Couldn't found element on the page,");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test01Login() {
        login();
    }

    @Test
    public void test02Login() {
        login();
    }

    @Test
    public void test03Login() {
        login();
    }

    @Test
    public void test04Login() {
        login();
    }
}
