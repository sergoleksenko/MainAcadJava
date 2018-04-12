import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Serg on 4/7/18.
 */
public class BasePage {

    protected final Logger logger = LogManager.getLogger(this.getClass().getName());

    public BasePage() {
        PropertyConfigurator.configure("log4j.properties");
        PageFactory.initElements(Browser.browser, this);
    }
}
