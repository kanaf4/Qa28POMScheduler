package testsscheduler;

import config.ConfigScheduler;
import dto.Authdto;
import dto.Eventdto;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pagesscheduler.HomeScreen;
import pagesscheduler.SplashScreen;


public class EventCreateTest extends ConfigScheduler {

    @Test
    public void eventCreationTest() {

        boolean isEventCreated =
                new SplashScreen(driver)
                        .checkVersion("0.0.3")
                        .loginWithDto(Authdto.builder().email("john@gmail.com").password("Jj123456$").build())
                        .skipWizard()
                        .initCreationEven()
                        .fillCreationEditForm("Even", "DV", 3, 30)
                        .confirmCreationEven()
                        .isFabAddPresent();
        Assert.assertTrue(isEventCreated);
    }

    @Test
    public void eventCreationTestDto() {

        boolean isEventCreated =
                new SplashScreen(driver)
                        .checkVersion("0.0.3")
                        .loginWithDto(Authdto.builder().email("john@gmail.com").password("Jj123456$")
                                .build())
                        .skipWizard()
                        .initCreationEven()
                        .fillCreationEditForm(Eventdto.builder().title("newEvent").type("TP").breaks(2).ammount(35).build())
                        .confirmCreationEven()
                        .isFabAddPresent();
        Assert.assertTrue(isEventCreated);
    }

    @AfterTest
    public void postCon() {
        new HomeScreen(driver)
                .openMenu()
                .logout();
    }
}
