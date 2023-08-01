package exercise.frontend.pageobject;

import exercise.config.Paths;
import exercise.config.SeleniumConfig;
import exercise.frontend.FrontendTestHelper;
import org.openqa.selenium.By;

public class LogInPage extends FrontendTestHelper {
    By LOGIN_EMAIL_FIELD = By.cssSelector("[data-qa='login-email']");
    By LOGIN_PASSWORD_FILED = By.cssSelector("[data-qa='login-password']");
    By LOGIN_BUTTON = By.cssSelector("[data-qa='login-button']");
    By SIGNUP_NAME_FILED = By.cssSelector("[data-qa='signup-name']");
    By SIGNUP_EMAIL_FILED = By.cssSelector("[data-qa='signup-email']");
    By SIGNUP_BUTTON = By.cssSelector("[data-qa='signup-button']");

    public LogInPage(SeleniumConfig seleniumConfig){
        this.seleniumConfig=seleniumConfig;
        seleniumConfig.getWebDriver().getCurrentUrl().equals(Paths.BASE_URL+Paths.LOGIN);
    }

    public void enterLogInEmailField(String logInEmail){
        waitForElementAndEnterText(LOGIN_EMAIL_FIELD,logInEmail);
    }
    public void enterLogInPasswordField(String logInPassword){
        waitForElementAndEnterText(LOGIN_PASSWORD_FILED,logInPassword);
    }
    public void clickOnLogInButton(){
        waitForElementAndClickOnIt(LOGIN_BUTTON);
    }
    public void enterSignUpNameField(String signUpName){
        waitForElementAndEnterText(SIGNUP_NAME_FILED,signUpName);
    }
    public void enterSignUpEmailField(String signUpEmail){
        waitForElementAndEnterText(SIGNUP_EMAIL_FILED,signUpEmail);
    }
    public void clickOnSignUpButton(){
        waitForElementAndClickOnIt(SIGNUP_BUTTON);
    }

    public void enterLogInDetailsAndSubmit(String logInEmail, String logInPassword){
        enterLogInEmailField(logInEmail);
        enterLogInPasswordField(logInPassword);
        clickOnLogInButton();
    }

    public void enterSignUpDetailsAndSubmit(String signUpName, String signUpEmail){
        enterSignUpNameField(signUpName);
        enterSignUpEmailField(signUpEmail);
        clickOnSignUpButton();
    }

    private void waitForElementAndEnterText(By webElement, String text){
        waitForElementToBeVisible(seleniumConfig,webElement);
        enterTextOnElementFiled(seleniumConfig,webElement,text);
    }

    private void waitForElementAndClickOnIt(By webElement){
        waitForElementToBeClickable(seleniumConfig,webElement);
        clickOnElement(seleniumConfig,webElement);
    }

}
