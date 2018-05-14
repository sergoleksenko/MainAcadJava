package bspb.utils;

import bspb.pages.LoginPage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Serg on 4/18/18.
 */
public class BrowserManager {

    private static final String URL = "http://idemo.bspb.ru/";
    private static ThreadLocal<WebDriver> browser = new ThreadLocal<>();
    private static Logger logger = LogManager.getLogger(BrowserManager.class);

    public static WebDriver getBrowser() {
        return browser.get();
    }

    public static void open() {
        PropertyConfigurator.configure("log4j.properties");
        String browserType = System.getProperty("browser");

        if (browserType == null) {
            browserType = "chrome";
        } else {
            browserType = browserType.toLowerCase();
        }

        logger.info("Opening " + browserType + "browser window");

        switch (browserType) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
                browser.set(new ChromeDriver());
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver");
                browser.set(new FirefoxDriver());
                break;
            case "safari":
                browser.set(new SafariDriver());
                break;
            default:
                logger.error("Oops! Looks like something went wrong");
        }

        getBrowser().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        maximize(browserType);
    }

    public static void close() {
        if (getBrowser() != null) {
            logger.info("Closing browser window");
            getBrowser().quit();
        }
    }

    private static void maximize(String browserType) {
        logger.info("Maximizing browser window");

        if (browserType.equals("chrome")) {
            getBrowser().manage().window().setPosition(new Point(0, 0));
            getBrowser().manage().window().setSize(new Dimension(1920, 1080));
        } else {
            getBrowser().manage().window().maximize();
        }
    }

    public static LoginPage openBspb() {
        logger.info("Go to url " + URL);
        getBrowser().get(URL);

        return new LoginPage();
    }
}
