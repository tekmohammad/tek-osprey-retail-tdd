package tek.tdd.test.regression;

import org.testng.Assert;
import org.testng.annotations.Test;
import tek.tdd.base.BaseUITests;
import tek.tdd.pages.HomePage;
import tek.tdd.pages.LoginPage;

public class SecurityTest extends BaseUITests {


    @Test
    public void validLoginWithValidCredentials() {
        /*
        Navigate to sign in page and sing in with valid username and password.
        Validate user successfully signed in.
         */
        HomePage homePage = new HomePage();
        clickOnElement(homePage.signInButton);


        LoginPage loginPage = new LoginPage();

        sendText(loginPage.emailInput, "mohammad_osprey@tekschool.us");
        sendText(loginPage.passwordInput, "12345678Ab@");
        clickOnElement(loginPage.loginButton);

        boolean isLogoutBtnDisplayed = isElementDisplayed(homePage.logoutButton);

        Assert.assertTrue(isLogoutBtnDisplayed,
                "After Success login, Logout button should display in home page");
    }

}
