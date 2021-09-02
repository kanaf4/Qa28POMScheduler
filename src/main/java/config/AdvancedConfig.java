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

public class AdvancedConfig {
    protected AppiumDriver<MobileElement> driver;

    @BeforeSuite
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("deviceName","Nexus");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"8.0");
        capabilities.setCapability("appPackage","com.h6ah4i.android.example.advrecyclerview");
        //capabilities.setCapability("appActivity", ".launcher.MainActivity");

        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("app","C:\\Users\\97253\\Desktop\\QA\\LESSONS\\Lesson_43(30.08.2021)/AdvancedRecyclerView.apk");

        driver =new AppiumDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);



    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
    }
}