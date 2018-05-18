package com.summersoft.ctt.yycx.util;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenShotOnFailure {

    private final static String SCREEN_SHOT_PATH = "test-output/screen-shot";
    private static String SCREEN_SHOT_NAME = null;

    public static void takeScreentShot() throws IOException {
        File screenShotDir = new File(SCREEN_SHOT_PATH);
        if (!screenShotDir.exists()) {
            screenShotDir.mkdirs();
        }
        SimpleDateFormat smf=new SimpleDateFormat("MMddHHmmss");
        String curTime=smf.format(new Date());
        SCREEN_SHOT_NAME =curTime+".png";
        FileUtils.copyFile( (((TakesScreenshot) MyWebdriver.driver).getScreenshotAs(OutputType.FILE)),
                new File(SCREEN_SHOT_PATH + "/" + SCREEN_SHOT_NAME));
    }

    public static String getScreenShotPath() {
        return SCREEN_SHOT_PATH;
    }

    public static String getScreenShotName() {
        return SCREEN_SHOT_NAME;
    }

}