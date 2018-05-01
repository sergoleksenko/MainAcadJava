package bspb.utils;

import bspb.pages.LoginPage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
        logger.info("Opening Chrome browser window");
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");

        browser.set(new ChromeDriver());
        maximize();
    }

    public static void close() {
        if (getBrowser() != null) {
            logger.info("Closing browser window");
            getBrowser().quit();
        }
    }

    private static void maximize() {
        logger.info("Maximizing browser window");
        getBrowser().manage().window().setPosition(new Point(0, 0));
        getBrowser().manage().window().setSize(new Dimension(1920, 1080));
    }

    public static LoginPage openBspb() {
        logger.info("Go to url " + URL);
        getBrowser().get(URL);

        return new LoginPage();
    }
}
