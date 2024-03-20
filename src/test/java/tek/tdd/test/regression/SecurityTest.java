package tek.tdd.test.regression;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tek.tdd.base.BaseUITests;
import tek.tdd.pages.HomePage;
import tek.tdd.pages.LoginPage;

public class SecurityTest extends BaseUITests {

    @DataProvider(name = "validCredentials")
    public String[][] validCredentialProvider() {
        String[][] data = {
                {"mohammad_osprey@tekschool.us", "12345678Ab@"},
                {"Mansoor@gmail.com" , "Ruya@2014"}
        };
        return data;
    }

    @Test(dataProvider = "validCredentials")
    public void validLoginWithValidCredentials(String username, String password) {
        /*
        Navigate to sign in page and sing in with valid username and password.
        Validate user successfully signed in.
         */
        HomePage homePage = new HomePage();
        clickOnElement(homePage.signInButton);

        LoginPage loginPage = new LoginPage();

        loginPage.doLogin(username, password);

        boolean isLogoutBtnDisplayed = isElementDisplayed(homePage.logoutButton);

        Assert.assertTrue(isLogoutBtnDisplayed,
                "After Success login, Logout button should display in home page");
    }


    @Test(dataProvider = "negativeTestData")
    public void validateLoginWithInvalidCredentials(
            String username,
            String password,
            String expectedErrorMessage
    ) {
        HomePage homePage = new HomePage();
        clickOnElement(homePage.signInButton);

        LoginPage loginPage = new LoginPage();

        loginPage.doLogin(username, password);

        String actualErrorMessage = getElementText(loginPage.errorMessage);
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage,
                "Error Message Should Display");
    }


    @DataProvider(name = "negativeTestData")
    private String[][] negativeTestData(){
        String[][] data = {
                {"wrong@email.com", "12345678Ab@" , "wrong username or password"},
                {"mohammad_osprey@tekschool.us", "invalid@Password", "wrong username or password"},
                {"wrong@email.com", "invlaid@Password", "wrong username or password"}
        };

        return data;
    }

}
