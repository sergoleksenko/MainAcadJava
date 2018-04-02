import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Serg on 4/2/18.
 */
public class FacebookHomePage {

    @FindBy(xpath = "//div[@id = 'userNav']")
    private WebElement userProfileLink;

    public boolean isUserProfileLinkDisplayed() {
        return userProfileLink.isDisplayed();
    }
}
