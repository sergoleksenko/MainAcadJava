package bspb.pages;

/**
 * Created by Serg on 4/22/18.
 */
public class WelcomePage extends BasePage {

    public HeaderPanel onHeader() {
        return new HeaderPanel();
    }

    public MenuPanel onMenu() {
        return new MenuPanel();
    }
}
