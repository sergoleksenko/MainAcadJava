package bspb.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Serg on 4/22/18.
 */
public class CurrencyExchangePreviewPage extends HeaderPanel {

    @FindBy(xpath = "//button[@id = 'confirm']")
    private WebElement confirmButton;

//    public HeaderPanel onHeader() {
//        return new HeaderPanel();
//    }
//
//    public MenuPanel onMenu() {
//        return new MenuPanel();
//    }

    public CurrencyExchangeSuccessPage confirm() {
        logger.info("Confirming currency exchange");
        confirmButton.click();

        return new CurrencyExchangeSuccessPage();
    }
}
