package tek.tdd.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import tek.tdd.utilities.SeleniumUtilities;

public class BaseUITests extends SeleniumUtilities {

    @BeforeMethod
    public void initiateTestMethod(){
        super.openBrowser();
    }

    @AfterMethod
    public void endTestMethod() {
        //TODO ADD Screenshots
        super.quitBrowser();
    }

}
