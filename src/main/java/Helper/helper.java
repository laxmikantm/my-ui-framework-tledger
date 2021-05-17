package Helper;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;

import javax.imageio.ImageIO;

/**************************
 *  (C) L Somni            *
 ***************************/

public class helper {

	public static String TOTAL_PRICE;

    public static FluentWait<WebDriver> fluentWait(WebDriver driver) {
        return new FluentWait<WebDriver>(driver)
                .withTimeout(50, TimeUnit.SECONDS)
                .pollingEvery(250, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class)
                .ignoring(NotFoundException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(InvalidElementStateException.class)
                .ignoring(TimeoutException.class);
    }

    public static String CaptureScreen(WebDriver driver, String ImagesPath) {
        TakesScreenshot oScn = (TakesScreenshot) driver;
        File oScnShot = oScn.getScreenshotAs(OutputType.FILE);
        File oDest = new File(ImagesPath + ".jpg");
        try {
            FileUtils.copyFile(oScnShot, oDest);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return ImagesPath + ".jpg";
    }

    public static void takeScreenSnapShot(final WebDriver driver, String prefix) throws IOException {
        String fileName = "";
        fileName += prefix;
        DateFormat dateFormat = new SimpleDateFormat("-dd-MM-yy-hhmmss");
        Date date = new Date();
        fileName += dateFormat.format(date);
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile, new File("target/snapshots/" + fileName + ".jpg"));
        } catch (Exception e) {
            System.out.println("Unable to access folder for Snapshots");
        }
        return;
    }

    public static void takeFieldSnapshot(WebDriver driver, WebElement element, String prefix) throws IOException {
        String fileName = "";
        fileName += prefix;
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yy-hhmmss");
        Date date = new Date();
        fileName += dateFormat.format(date);
        File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Point p = element.getLocation();
        int width = element.getSize().getWidth();
        int height = element.getSize().getHeight();
        BufferedImage img = null;
        img = ImageIO.read(screen);
        BufferedImage dest = img.getSubimage(p.getX(), p.getY(), width,
                height);

        ImageIO.write(dest, "png", screen);
        File f = null;
        FileUtils.copyFile(screen, new File("target/snaps/elementSpecific/" + fileName + ".jpg"));
    }

    public static String getRandomPostFix(){
        return RandomStringUtils.randomAlphabetic(2);
    }

}
