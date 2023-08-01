package exercise.frontend.pageobject;

import exercise.config.Paths;
import exercise.config.SeleniumConfig;
import exercise.frontend.FrontendTestHelper;
import exercise.models.RegisterRequest;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.Select;

@Slf4j
public class SignUpPage extends FrontendTestHelper {
    By TITLE_RADIO_BUTTON = By.cssSelector("[data-qa='title']");
    By MR_RADIO_BUTTON = By.id("id_gender1");
    By MRS_RADIO_BUTTON = By.id("id_gender2");
    By NAME_FILED = By.cssSelector("[data-qa='name']");
    By EMAIL_FILED = By.cssSelector("[data-qa='email']");
    By PASSWORD_FILED = By.cssSelector("[data-qa='password']");
    By DAYS_DROPDOWN = By.cssSelector("[data-qa='days']");
    By MONTHS_DROPDOWN = By.cssSelector("[data-qa='months']");
    By YEARS_DROPDOWN = By.cssSelector("[data-qa='years']");
    By NEWSLETTER_CHECKBOX = By.id("newsletter");
    By OPTION_CHECKBOX = By.id("optin");
    By FIRSTNAME_FILED = By.cssSelector("[data-qa='first_name']");
    By LASTNAME_FILED = By.cssSelector("[data-qa='last_name']");
    By COMPANY_FILED = By.cssSelector("[data-qa='company']");
    By ADDRESS_FILED = By.cssSelector("[data-qa='address']");
    By ADDRESS2_FILED = By.cssSelector("[data-qa='address2']");
    By COUNTRY_DROPDOWN = By.cssSelector("[data-qa='country']");
    By STATE_FILED = By.cssSelector("[data-qa='state']");
    By CITY_FILED = By.cssSelector("[data-qa='city']");
    By ZIPCODE_FILED = By.cssSelector("[data-qa='zipcode']");
    By MOBILE_NUMBER_FILED = By.cssSelector("[data-qa='mobile_number']");
    By SUBMIT_BUTTON = By.cssSelector("[data-qa='create-account']");

    public SignUpPage(SeleniumConfig seleniumConfig){
        this.seleniumConfig=seleniumConfig;
        seleniumConfig.getWebDriver().getCurrentUrl().equals(Paths.BASE_URL+Paths.SIGNUP);
    }

    public void clickOnTitleMrButton(){
        waitForElementAndClickOnIt(MR_RADIO_BUTTON);
    }
    public void clickOnTitleMrsButton(){
        waitForElementAndClickOnIt(MRS_RADIO_BUTTON);
    }
    public void enterNameField(String name){
        waitForElementAndEnterText(NAME_FILED,name);
    }
    public void enterEmailField(String email){
        waitForElementAndEnterText(EMAIL_FILED,email);
    }
    public void enterPasswordField(String password){
        waitForElementAndEnterText(PASSWORD_FILED,password);
    }
    public void selectDaysFromDropdown(String day){
        waitForElementAndSelectFromDropdownByValue(DAYS_DROPDOWN,day);
    }
    public void selectMonthsFromDropdown(String month){
        waitForElementAndSelectFromDropdownByValue(MONTHS_DROPDOWN,month);
    }
    public void selectYearsFromDropdown(String year){
        waitForElementAndSelectFromDropdownByValue(YEARS_DROPDOWN,year);
    }
    public void clickOnNewsletterCheckbox(){
        waitForElementAndClickOnIt(NEWSLETTER_CHECKBOX);
    }
    public void clickOnOptionCheckbox(){
        waitForElementAndClickOnIt(OPTION_CHECKBOX);
    }
    public void enterFirstNameField(String firstname){
        waitForElementAndEnterText(FIRSTNAME_FILED,firstname);
    }
    public void enterLastNameField(String lastname){
        waitForElementAndEnterText(LASTNAME_FILED,lastname);
    }
    public void enterCompanyNameField(String company){
        waitForElementAndEnterText(COMPANY_FILED,company);
    }
    public void enterAddressField(String address){
        waitForElementAndEnterText(ADDRESS_FILED,address);
    }
    public void enterAddress2Field(String address){
        waitForElementAndEnterText(ADDRESS2_FILED,address);
    }
    public void selectCountryFromDropdown(String country){
        waitForElementAndSelectFromDropdownByValue(COUNTRY_DROPDOWN,country);
    }
    public void enterStateNameField(String state){
        waitForElementAndEnterText(STATE_FILED,state);
    }
    public void enterCityNameField(String city){
        waitForElementAndEnterText(CITY_FILED,city);
    }
    public void enterZipCodeField(String zipcode){
        waitForElementAndEnterText(ZIPCODE_FILED,zipcode);
    }
    public void enterMobileNumberField(String mobile){
        waitForElementAndEnterText(MOBILE_NUMBER_FILED,mobile);
    }
    public void clickOnSubmitButton(){
        waitForElementAndClickOnIt(SUBMIT_BUTTON);
    }

    public void enterAllSignUpDetailsAndSubmit(RegisterRequest registerRequest){
        if(registerRequest.getTitle().equals("Mr"))
            clickOnTitleMrButton();
        else clickOnTitleMrsButton();
        //enterNameField(registerRequest.getName());
        //enterEmailField(registerRequest.getEmail());
        enterPasswordField(registerRequest.getPassword());
        selectDaysFromDropdown(registerRequest.getBirth_date());
        selectMonthsFromDropdown(registerRequest.getBirth_month());
        selectYearsFromDropdown(registerRequest.getBirth_year());
        clickOnNewsletterCheckbox();
        clickOnOptionCheckbox();
        enterFirstNameField(registerRequest.getFirstname());
        enterLastNameField(registerRequest.getLastname());
        enterCompanyNameField(registerRequest.getCompany());
        enterAddressField(registerRequest.getAddress1());
        enterAddress2Field(registerRequest.getAddress2());
        selectCountryFromDropdown(registerRequest.getCountry());
        enterStateNameField(registerRequest.getState());
        enterCityNameField(registerRequest.getCity());
        enterZipCodeField(registerRequest.getZipcode());
        enterMobileNumberField(registerRequest.getMobile_number());
        clickOnSubmitButton();
    }

    private void waitForElementAndEnterText(By webElement, String text){
        waitForElementToBeVisible(seleniumConfig,webElement);
        seleniumConfig.getWebDriver().findElement(webElement).clear();
        enterTextOnElementFiled(seleniumConfig,webElement,text);
    }

    private void waitForElementAndClickOnIt(By webElement){
        waitForElementToBeClickable(seleniumConfig,webElement);
        clickOnElement(seleniumConfig,webElement);
    }

    private void waitForElementAndSelectFromDropdownByValue(By webElement, String value){
        waitForElementToBeClickable(seleniumConfig,webElement);
        Select dropdown = new Select(seleniumConfig.getWebDriver().findElement(webElement));
        try {
            dropdown.selectByValue(value);
        }
        catch (StaleElementReferenceException | NoSuchElementException var2){
            log.info("Caught exception when trying to find element': " + var2.getMessage());
            throw var2;
        }
    }
}
