
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class Utility {

    private static final Logger logger = LoggerFactory.getLogger(Utility.class);

    public static void takeScreenshot(WebDriver driver, Scenario scenario) {

        logger.error("Scenario " + scenario.getName() + " failed. Taking screenshot");

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File(scenario.getId() +".jpg"));
        } catch (IOException e) {
            logger.error("Failed to take screenshot because " + e.getMessage());
            e.printStackTrace();
        }
    }
}
