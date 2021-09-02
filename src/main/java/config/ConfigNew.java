package config;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ConfigNew {
    protected AppiumDriver<MobileElement> driver;

    @BeforeSuite
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("deviceName","Nex");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"8.0");
        capabilities.setCapability("appPackage","com.example.svetlana.scheduler");
        capabilities.setCapability("appActivity",".presentation.splashScreen.SplashScreenActivity");

        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("app","C:\\Users\\97253\\Desktop\\QA\\LESSONS\\Lesson_40(19.08.2021)mobileTest/v.0.0.3.apk");

        driver = new AppiumDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);



    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
    }
}
