import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Serg on 4/2/18.
 */
public class BrowserManager {

    public static WebDriver browser;
    private static Logger logger = LogManager.getLogger(BrowserManager.class);


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
        browser = new ChromeDriver();
        maximizeBrowser();
    }

    public static void close() {
        if (browser != null)
            logger.info("close browser");
            browser.quit();
    }

    private static void maximizeBrowser() {
        logger.info("maximize browser");
        browser.manage().window().setPosition(new Point(0, 0));
        browser.manage().window().setSize(new Dimension(1920, 1080));
    }

    public static FacebookStartPage openFacebook() {
        logger.info("open Facebook");
        browser.get("https://www.facebook.com");

        return new FacebookStartPage();
    }
}
