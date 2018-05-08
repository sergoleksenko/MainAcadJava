package bspb.utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

/**
 * Created by Serg on 4/23/18.
 */
public class ElementHelper {

    private static Logger logger = LogManager.getLogger(ElementHelper.class);

    public ElementHelper() {
        PropertyConfigurator.configure("log4j.properties");
    }

    public static boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException ex) {
            logger.error("Element not found. " + element);
            return false;
        }
    }

    public static boolean isElementContainsText(WebElement element, String message) {
        return element.getText().contains(message);
    }

    public static WebElement getAccountFromComboBox(WebElement accountField, String currency) {
        for (WebElement account : accountField.findElements(By.tagName("option"))) {
            if (account.getAttribute("currency-code").equals(currency)) {
                return account;
            }
        }

        return null;
    }
}
