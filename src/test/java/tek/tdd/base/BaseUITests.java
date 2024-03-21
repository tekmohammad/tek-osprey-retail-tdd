package tek.tdd.base;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerAdapter;
import org.openqa.selenium.bidi.log.Log;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import tek.tdd.pages.HomePage;
import tek.tdd.pages.LoginPage;
import tek.tdd.utilities.SeleniumUtilities;

@Listeners({ExtentITestListenerAdapter.class})
public class BaseUITests extends SeleniumUtilities {

    public HomePage homePage;
    public LoginPage loginPage;

    @BeforeMethod
    public void initiateTestMethod(){
        super.openBrowser();

        //Pages need initialized driver so after opening browser we Create Objects.
         homePage = new HomePage();
         loginPage = new LoginPage();
    }

    @AfterMethod
    public void endTestMethod() {
        //TODO ADD Screenshots
        super.quitBrowser();
    }

}
