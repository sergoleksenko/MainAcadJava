import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Serg on 4/2/18.
 */
public class FacebookHomePage extends BasePage {

    @FindBy(xpath = "//div[@id = 'userNav1']")
    private WebElement userProfileLink;

    public boolean isUserProfileLinkDisplayed() {
        logger.info("Check data on the Home page");

        return isElementDisplayed(userProfileLink);
    }
}
