import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Serg on 4/2/18.
 */
public class BrowserManager {

    private static ThreadLocal<WebDriver> browser = new ThreadLocal<>();
    private static Logger logger = LogManager.getLogger(BrowserManager.class);

    public static WebDriver getBrowser() {
        return browser.get();
    }

    public static void open() {
        String chromeDriver;
        PropertyConfigurator.configure("log4j.properties");

        if (System.getProperty("os.name").equals("Mac OS X")) {
            chromeDriver = "chromedriver";
        } else {
            chromeDriver = "chromedriver.exe";
        }

        logger.info("open browser");
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/" + chromeDriver);
        browser.set(new ChromeDriver());
        maximizeBrowser();
    }

    public static void close() {
        if (getBrowser() != null)
            logger.info("close browser");
            getBrowser().quit();
    }

    private static void maximizeBrowser() {
        logger.info("maximize browser");
        getBrowser().manage().window().setPosition(new Point(0, 0));
        getBrowser().manage().window().setSize(new Dimension(1920, 1080));
    }

    public static FacebookStartPage openFacebook() {
        logger.info("open Facebook");
        getBrowser().get("https://www.facebook.com");

        return new FacebookStartPage();
    }
}
