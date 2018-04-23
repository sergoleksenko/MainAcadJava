package bspb.utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Serg on 4/23/18.
 */
public class ElementHelper {

    private Logger logger = LogManager.getLogger(this.getClass().getName());

    public ElementHelper() {
        PropertyConfigurator.configure("log4j.properties");
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException ex) {
            logger.error("Element not found. " + element);
            return false;
        }
    }

    public boolean isElementContainsText(WebElement element, String message) {
        return element.getText().contains(message);
    }

    public void selectDataFromComboBox(WebElement accountsField, String currency) {
        List<WebElement> accounts = accountsField.findElements(By.tagName("option"));

        for (WebElement element : accounts) {
            if (element.getAttribute("currency-code").equals(currency)) {
                element.click();
                break;
            }
        }
    }
}
