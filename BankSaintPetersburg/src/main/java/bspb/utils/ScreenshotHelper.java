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
 * Created by Serg on 5/15/18.
 */
public class ScreenshotHelper {

    public static void takeScreenshot(ITestResult iTestResult) {
        File scrFile = ((TakesScreenshot) BrowserManager.getBrowser()).getScreenshotAs(OutputType.FILE);
        File folder = new File(System.getProperty("user.dir") + File.separator + "screenshots" + File.separator + new SimpleDateFormat("dd.MM.yyyy").format(Calendar.getInstance().getTime()));
        File scrName = new File(folder + File.separator + "errorScreenshots_" + iTestResult.getName() + " - " + Arrays.toString(iTestResult.getParameters()) + " - " + new SimpleDateFormat("HH_mm_ss").format(Calendar.getInstance().getTime()) + ".jpg");

        if (!folder.exists()) {
            folder.mkdirs();
        }

        try {
            FileUtils.copyFile(scrFile, scrName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
