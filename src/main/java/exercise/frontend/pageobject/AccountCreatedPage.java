package exercise.frontend.pageobject;

import exercise.config.Paths;
import exercise.config.SeleniumConfig;
import exercise.frontend.FrontendTestHelper;
import org.openqa.selenium.By;

public class AccountCreatedPage extends FrontendTestHelper {

    By ACCOUNT_CREATED_TITLE = By.cssSelector("[data-qa='account-created']");
    By CONTINUE_BUTTON = By.cssSelector("[data-qa='continue-button']");

    public AccountCreatedPage(SeleniumConfig seleniumConfig) {
        this.seleniumConfig=seleniumConfig;
        seleniumConfig.getWebDriver().getCurrentUrl().equals(Paths.BASE_URL+Paths.ACCOUNT_CREATED);
    }

    public String getAccountCreatedTitle(){
        waitForElementToBeVisible(seleniumConfig,ACCOUNT_CREATED_TITLE);
        return seleniumConfig.getWebDriver().findElement(ACCOUNT_CREATED_TITLE).getText();
    }

    public void clickOnContinueButton(){
        waitForElementToBeClickable(seleniumConfig,CONTINUE_BUTTON);
        clickOnElement(seleniumConfig,CONTINUE_BUTTON);
    }




}
