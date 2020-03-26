package helpers;

import org.openqa.selenium.remote.DesiredCapabilities;

public class CapabilitiesSetup {


    public CapabilitiesSetup(){}

    public DesiredCapabilities AndroidSetUp(String name){

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app","sauce-storage:ebay.apk");
        capabilities.setCapability("username",System.getenv("SAUCE_USER"));
        capabilities.setCapability("accessKey", System.getenv("ACCESS_KEY"));
        capabilities.setCapability("deviceName","Google Pixel 3 XL GoogleAPI Emulator");
        capabilities.setCapability("deviceOrientation","portrait");
        capabilities.setCapability("appiumVersion","1.16.0");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("platformVersion","9.0");
        capabilities.setCapability("name", name);

        return capabilities;
    }
}
