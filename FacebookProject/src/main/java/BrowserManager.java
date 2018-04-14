import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Serg on 4/2/18.
 */
public class BrowserManager {

    public static WebDriver browser;

    public static void open() {
        String chromeDriver;

        if (System.getProperty("os.name").equals("Mac OS X")) {
            chromeDriver = "chromedriver";
        } else {
            chromeDriver = "chromedriver.exe";
        }

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/" + chromeDriver);
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

    public static FacebookStartPage openFacebook() {
        browser.get("https://www.facebook.com");

        return new FacebookStartPage();
    }
}
