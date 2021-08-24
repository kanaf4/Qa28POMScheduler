package testssheduler;

import config.ConfigScheduler;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagesscheduler.SplashScreen;


public class LaunchAppTest extends ConfigScheduler {
    @Test
    public void launchtest(){
        String version = new SplashScreen(driver).getCurrentVersion();
        Assert.assertEquals(version,"0.0.3");
    }

}
