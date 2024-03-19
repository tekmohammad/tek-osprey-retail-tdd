package tek.tdd.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import tek.tdd.base.BaseUITests;
import tek.tdd.pages.HomePage;
import tek.tdd.utilities.SeleniumUtilities;

public class SetupTests extends BaseUITests {


    @Test
    public void testRetailLogo() {
        HomePage homePage = new HomePage();

        boolean isDisplayed = isElementDisplayed(homePage.topNavLogo);

        Assert.assertTrue(isDisplayed, "Top left corner Logo should displayed always");
    }

}
