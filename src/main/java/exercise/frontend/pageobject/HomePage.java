package exercise.frontend.pageobject;

import exercise.config.Paths;
import exercise.config.SeleniumConfig;
import exercise.frontend.FrontendTestHelper;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;

@Slf4j
public class HomePage extends FrontendTestHelper {

    By SLIDER = By.id("slider");
    By SIGNUP_LOGIN_BUTTON = By.cssSelector("[href='/login']");
    By LOGOUT_BUTTON = By.cssSelector("[href='/logout']");
    By DELETE_ACCOUNT_BUTTON = By.cssSelector("[href='/delete_account']");
    By LOGGED_IN_AS = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a");

    public HomePage(SeleniumConfig seleniumConfig){
        this.seleniumConfig=seleniumConfig;
        seleniumConfig.getWebDriver().getCurrentUrl().equals(Paths.BASE_URL);
    }

    public void clickOnLogInButton(){
        waitForElementToBeClickable(seleniumConfig, SIGNUP_LOGIN_BUTTON);
        clickOnElement(seleniumConfig, SIGNUP_LOGIN_BUTTON);
    }

    public String getLoggedInAsText(){
        waitForElementToBeVisible(seleniumConfig,LOGGED_IN_AS);
        return seleniumConfig.getWebDriver().findElement(LOGGED_IN_AS).getText();
    }

}
