package bspb.pages;

import bspb.utils.BrowserManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Serg on 4/18/18.
 */
public abstract class BasePage {

    protected Logger logger = LogManager.getLogger(this.getClass().getName());

    public BasePage() {
        PropertyConfigurator.configure("log4j.properties");
        PageFactory.initElements(BrowserManager.browser, this);
    }
}
