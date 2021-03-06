package bspb.pages;

import bspb.utils.ActionHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Serg on 4/22/18.
 */
public class AccountsStatementsPage extends HeaderPanel {

    @FindBy(xpath = "//tr[@id = 'closing-balance-row']/th[@class = 'right amount']")
    private WebElement closingBalance;

    public float getClosingBalance() {
        logger.info("Getting closing balance");
        ActionHelper.scrollWithJS(closingBalance);
        return Float.parseFloat(closingBalance.getText().replace(" ", ""));
    }
}
