package bspb.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

/**
 * Created by Serg on 5/9/18.
 */
public class ScreenshotUtils {

    public static void takeScreenshotIfFailure(ITestResult testResult) {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            File file = ((TakesScreenshot) BrowserManager.getBrowser()).getScreenshotAs(OutputType.FILE);
            File folder = new File(System.getProperty("user.dir") + File.separator + "screenshots" + File.separator + new SimpleDateFormat("dd.MM.yyyy").format(Calendar.getInstance().getTime()));

            if (!folder.exists()) {
                folder.mkdirs();
            }

            try {
                FileUtils.copyFile(file, new File(folder + File.separator + "errorScreenshots_" + testResult.getName() + " - " + Arrays.toString(testResult.getParameters()) + ".jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
