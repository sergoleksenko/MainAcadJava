import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Serg on 4/2/18.
 */
public class Browser {

    public static WebDriver browser;

    public static void open() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
        browser = new ChromeDriver();
        maximizeBrowser();
    }

    public static void close() {
        if (browser != null)
            browser.quit();
    }

    private static void maximizeBrowser() {
        browser.manage().window().setPosition(new Point(0, 0));
        browser.manage().window().setSize(new Dimension(1920, 1080));
    }

    public static FacebookStartPage openWebPage(String url) {
        browser.get(url);

        return PageFactory.initElements(browser, FacebookStartPage.class);
    }
}
