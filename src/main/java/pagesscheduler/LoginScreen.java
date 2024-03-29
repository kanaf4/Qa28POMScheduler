package pagesscheduler;

import dto.Authdto;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.FindBy;

public class LoginScreen extends BaseScreen {

    public LoginScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
    @AndroidFindBy(xpath = "//*[@resource-id ='com.example.svetlana.scheduler:id/log_email_input']")
    MobileElement emailEditText;
    @AndroidFindBy(xpath = "//*[@resource-id = 'com.example.svetlana.scheduler:id/log_password_input']")
    MobileElement passwordlEditText;
    @AndroidFindBy(xpath = "//*[@resource-id = 'com.example.svetlana.scheduler:id/login_btn']")
    MobileElement loginButton;
    @AndroidFindBy (xpath = "//*[@resource-id ='android:id/message']")
    MobileElement errorMes;

    public LoginScreen fillEmail(String email){
        type(emailEditText,email);
        return this;
    }
    public LoginScreen fillPassword(String password){
        type(passwordlEditText,password);
        return this;
    }
    public WizardScreen clickLoginButton(){
        higeKeyboard();
        loginButton.click();
        return new WizardScreen(driver);
    }
    public WizardScreen loginWithDto(Authdto auth){
        type(emailEditText, auth.getEmail());
        type(passwordlEditText, auth.getPassword());
        higeKeyboard();
        loginButton.click();
        return new WizardScreen(driver);
    }
    public LoginScreen fillFormLogin (Authdto auth){
        type(emailEditText,auth.getEmail());
        type(passwordlEditText, auth.getPassword());
        return this;
    }

    public LoginScreen errorLogin(){
        higeKeyboard();
        loginButton.click();
        return this;
    }
    public String errorMessage(){
        //should(errorMes,10);
        return errorMes.getText();
    }
}
