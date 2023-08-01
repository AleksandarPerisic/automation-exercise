package exercise.testcases.frontend;

import exercise.frontend.FrontendTestHelper;
import exercise.frontend.pageobject.AccountCreatedPage;
import exercise.frontend.pageobject.HomePage;
import exercise.frontend.pageobject.LogInPage;
import exercise.frontend.pageobject.SignUpPage;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;

@Slf4j
public class CustomerRegistration extends FrontendTestHelper{

    @Test()
    public void successfulUserRegistration() {
        HomePage homePage = new HomePage(seleniumConfig);
        homePage.clickOnLogInButton();
        LogInPage logInPage = new LogInPage(seleniumConfig);
        logInPage.enterSignUpDetailsAndSubmit("Automation Exercise", validEmail);
        SignUpPage signUpPage = new SignUpPage(seleniumConfig);
        signUpPage.enterAllSignUpDetailsAndSubmit(createValidUserRequest(validEmail));
        AccountCreatedPage accountCreatedPage = new AccountCreatedPage(seleniumConfig);
        Assert.assertEquals(accountCreatedPage.getAccountCreatedTitle(),"ACCOUNT CREATED!");
    }
}
