package io.paulsbruce.dev.fingerprintdemo.appium.webdriver;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;

/**
 * Created by paul on 6/22/17.
 */

public class LocalDevWebDriver extends AndroidDriver {

    public LocalDevWebDriver() throws Exception {
        super(new URL("http://127.0.0.1:4723/wd/hub"), getCaps());
        this.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    private static DesiredCapabilities getCaps() {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("deviceName", "arbitrary since we don't use UDID"); // still needed to tell appium to not use UDID
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability(CapabilityType.VERSION, "6.0.1");

        String filePath = new File("../app/build/outputs/apk/app-debug.apk").getAbsolutePath();
        capabilities.setCapability("app", filePath);

        return capabilities;
    }
}