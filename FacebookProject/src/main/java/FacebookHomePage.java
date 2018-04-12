import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Serg on 4/2/18.
 */
public class FacebookHomePage extends BasePage {

    @FindBy(xpath = "//div[@id = 'userNav']")
    private WebElement userProfileLink;

    public boolean isUserProfileLinkDisplayed() {
        boolean userProfileLink = false;

        try {
            userProfileLink = this.userProfileLink.isDisplayed();
            logger.info("Check data on the Home page");
        } catch (NoSuchElementException ex) {
            logger.error("Element not found. " + this.userProfileLink);
        }

        return userProfileLink;
    }
}
