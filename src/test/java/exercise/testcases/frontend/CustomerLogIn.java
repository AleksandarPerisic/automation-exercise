package exercise.testcases.frontend;

import exercise.frontend.FrontendTestHelper;
import exercise.frontend.pageobject.HomePage;
import exercise.frontend.pageobject.LogInPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomerLogIn extends FrontendTestHelper {

    @Test
    public void successfulUserLogIn(){
        HomePage homePage = new HomePage(seleniumConfig);
        homePage.clickOnLogInButton();
        LogInPage logInPage = new LogInPage(seleniumConfig);
        logInPage.enterLogInDetailsAndSubmit(logInEmail,logInPassword);
        Assert.assertEquals(homePage.getLoggedInAsText(),"Logged in as Automation Exercise");
    }
}
