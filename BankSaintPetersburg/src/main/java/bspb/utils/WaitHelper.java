package bspb.utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by Serg on 4/23/18.
 */
public class WaitHelper {

    private Logger logger = LogManager.getLogger(this.getClass().getName());

    public WaitHelper() {
        PropertyConfigurator.configure("log4j.properties");
    }

    public List<WebElement> waitForAllElementsVisible(List<WebElement> elements) {
        logger.info("Waiting when all elements will be visible");
        try {
            return new WebDriverWait(BrowserManager.browser, 5).until(ExpectedConditions.visibilityOfAllElements(elements));
        } catch (TimeoutException ex) {
            logger.error("There are no any messages on the Message page.");
            return null;
        }
    }

    public WebElement waitForElementVisible(WebElement element) {
        logger.info("Waiting when element will be visible");
        try {
            return (new WebDriverWait(BrowserManager.browser, 5)).until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException ex) {
            logger.error("Element not found.");
            return null;
        }
    }

    public void waitAndSwitchToFrame(WebElement frame) {
        logger.info("Waiting for a frame");
        try {
            (new WebDriverWait(BrowserManager.browser, 5)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
        } catch (TimeoutException ex) {
            logger.error("Frame not found.");
        }
    }
}
