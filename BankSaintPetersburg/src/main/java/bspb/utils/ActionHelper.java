package bspb.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by Serg on 4/24/18.
 */
public class ActionHelper {

    public static void moveToElement(WebElement element) {
        new Actions(BrowserManager.getBrowser()).moveToElement(element).build().perform();
    }
}
