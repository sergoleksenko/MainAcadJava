package bspb.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Serg on 4/22/18.
 */
public class AccountsStatementsPage extends BasePage {

    @FindBy(xpath = "//tr[@id = 'closing-balance-row']/th[@class = 'right amount']")
    private WebElement closingBalance;

    public HeaderPanel onHeader() {
        return new HeaderPanel();
    }

    public MenuPanel onMenu() {
        return new MenuPanel();
    }

    public float getClosingBalance() {
        logger.info("Getting closing balance");

        return Float.parseFloat(closingBalance.getText().replace(" ", ""));
    }
}
