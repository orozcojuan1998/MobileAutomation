package steps;

import com.saucelabs.common.SauceOnDemandAuthentication;
import com.saucelabs.common.SauceOnDemandSessionIdProvider;
import com.saucelabs.junit.SauceOnDemandTestWatcher;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import drivermanager.DriverManager;
import drivermanager.DriverType;
import helpers.CapabilitiesSetup;
import io.appium.java_client.AppiumDriver;
import org.junit.Rule;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;

public class Hook {

    private AppiumDriver<?> driver;
    private DriverManager driverManager = new DriverManager();
    private CapabilitiesSetup capabilitiesSetup = new CapabilitiesSetup();

    @Before
    public void setUp(Scenario scenario) throws MalformedURLException {
        driver = driverManager.getDriver(capabilitiesSetup.AndroidSetUp(scenario.getName()));
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()){
            ((JavascriptExecutor) driver).executeScript("sauce:job-result=" + ("failed"));
        }
        else {
            ((JavascriptExecutor) driver).executeScript("sauce:job-result=" + ("passed"));
        }

        driverManager.quitDriver();
    }

    public AppiumDriver<?> getDriver() {
        return driver;
    }

}
