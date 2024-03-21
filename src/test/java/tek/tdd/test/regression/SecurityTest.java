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
    public void validateLoginWithValidCredentials(String username, String password) {
        /*
        Navigate to sign in page and sing in with valid username and password.
        Validate user successfully signed in.
         */
        clickOnElement(homePage.signInButton);

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
        clickOnElement(homePage.signInButton);

        loginPage.doLogin(username, password);

        String actualErrorMessage = getElementText(loginPage.errorMessage);
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage,
                "Error Message Should Display");
    }


    @DataProvider(name = "negativeTestData")
    private String[][] negativeTestData(){
        String[][] data = {
                {"wrong@email.com", "12345678Ab@" , "Wrong Password or username.try again"},
                {"mohammad_osprey@tekschool.us", "invalid@Password", "Wrong Password or username.try again"},
                {"wrong@email.com", "invlaid@Password", "Wrong Password or username.try again"}
        };

        return data;
    }

}
