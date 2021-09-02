package pagesscheduler;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseScreen {
    AppiumDriver<MobileElement> driver;

    public BaseScreen(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    public void type (MobileElement element ,String text){
        if(text!=null){
            element.click();
            element.clear();
            element.sendKeys(text);
        }
    }
    public  void shouldHave(MobileElement element,String text, long timeout){
        new WebDriverWait(driver,timeout).until(ExpectedConditions.textToBePresentInElement(element,text));

    }
    public void should(MobileElement element,long timeout){
        new WebDriverWait(driver,timeout).until(ExpectedConditions.visibilityOf(element));
    }
    public void higeKeyboard(){
        driver.hideKeyboard();
    }
    public boolean isDisplayedWhithoutExeption(MobileElement element){
        try {
            return element.isDisplayed();
        }catch (Exception ex){
            return false;
        }
    }
}
