package exercise.frontend;

import exercise.TestBase;
import exercise.config.SeleniumConfig;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

@Slf4j
public class FrontendTestHelper extends TestBase {

    protected SeleniumConfig seleniumConfig;

    protected static final String logInEmail = "automation_exercise1690879787833@test.com";
    protected static final String logInPassword = "AutomationExercise123";

    @BeforeMethod
    public void setUp(){
        seleniumConfig = new SeleniumConfig();
        seleniumConfig.setupWebDriver(DriverManagerType.CHROME);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (seleniumConfig != null) {
            seleniumConfig.closeWebDriver();
        }
    }

    //General
    public void waitForElementToBeVisible(SeleniumConfig seleniumConfig, By webElement) {
        try {
            new WebDriverWait(seleniumConfig.getWebDriver(), 1).until(ExpectedConditions.visibilityOfElementLocated(webElement));
        } catch (StaleElementReferenceException | NoSuchElementException var2) {
            log.info("Caught exception when trying to find element': " + var2.getMessage());
            throw var2;
        }
    }

    public void waitForElementToBeClickable(SeleniumConfig seleniumConfig, By webElement) {
        try {
            new WebDriverWait(seleniumConfig.getWebDriver(), 1).until(ExpectedConditions.elementToBeClickable(webElement));
        } catch (StaleElementReferenceException | NoSuchElementException var2) {
            log.info("Caught exception when trying to find element': " + var2.getMessage());
            throw var2;
        }
    }

    public void clickOnElement(SeleniumConfig seleniumConfig, By webElement){
        try {
            seleniumConfig.getWebDriver().findElement(webElement).click();
        } catch (StaleElementReferenceException | NoSuchElementException var2) {
            log.info("Caught exception when trying to find element': " + var2.getMessage());
            throw var2;
        }
    }

    public void enterTextOnElementFiled(SeleniumConfig seleniumConfig, By webElement, String text){
        try {
            seleniumConfig.getWebDriver().findElement(webElement).sendKeys(text);
        } catch (StaleElementReferenceException | NoSuchElementException var2) {
            log.info("Caught exception when trying to find element': " + var2.getMessage());
            throw var2;
        }
    }

}
