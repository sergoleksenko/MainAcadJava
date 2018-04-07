import org.openqa.selenium.support.PageFactory;

/**
 * Created by Serg on 4/7/18.
 */
public class BasePage {

    public BasePage() {
        PageFactory.initElements(Browser.browser, this);
    }
}
