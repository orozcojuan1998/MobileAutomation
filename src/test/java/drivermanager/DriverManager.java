package drivermanager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {

    protected AppiumDriver<?> driver;

    protected void createDriver(DesiredCapabilities capabilities) throws MalformedURLException {
        driver = new AndroidDriver<RemoteWebElement>(new URL("http://ondemand.saucelabs.com:80/wd/hub"),capabilities);
    }

    public void quitDriver(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }

    public AppiumDriver<?> getDriver(DesiredCapabilities capabilities) throws MalformedURLException {
        if (driver == null){
            createDriver(capabilities);
        }
        return driver;
    }


}
