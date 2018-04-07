import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


/**
 * Created by Serg on 4/4/18.
 */
public class FlyUIATest {

    private WebDriver browser;

    @BeforeClass
    public void openBrowser() {
        String chromeDriver;

        if (System.getProperty("os.name").equals("Mac OS X")) {
            chromeDriver = "chromedriver";
        } else {
            chromeDriver = "chromedriver.exe";
        }

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/" + chromeDriver);
        browser = new ChromeDriver();
        maximizeBrowser();
    }

    private void maximizeBrowser() {
        Point targetPosition = new Point(0, 0);
        browser.manage().window().setPosition(targetPosition);
        Dimension targetSize = new Dimension(1920, 1080);
        browser.manage().window().setSize(targetSize);
    }

    @AfterClass
    public void closeBrowser() {
        browser.quit();
    }

    @Test
    public void testSearch() throws InterruptedException {
        browser.get("https://www.flyuia.com");

        browser.findElement(By.className("ensurance__button-full-width")).click();

        browser.findElement(By.id("mat-input-0")).sendKeys("Херсон");
        (new WebDriverWait(browser, 5)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class = 'ng-tns-c11-3']"))).click();

        browser.findElement(By.id("mat-input-1")).sendKeys("Київ");
        (new WebDriverWait(browser, 5)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class = 'ng-tns-c11-4']"))).click();

        System.out.println(browser.findElement(By.xpath("//input[@id = 'mat-input-0']/parent::div/descendant::div[last()]")).getText());
        System.out.println(browser.findElement(By.xpath("//input[@id = 'mat-input-1']/parent::div/descendant::div[last()]")).getText());
    }
}
