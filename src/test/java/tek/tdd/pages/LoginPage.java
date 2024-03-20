package tek.tdd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek.tdd.utilities.SeleniumUtilities;

public class LoginPage extends SeleniumUtilities {

    public LoginPage(){
        //Initialize current session of Driver. to all the element
        //of the page.
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(name = "email")
    public WebElement emailInput;

    @FindBy(name = "password")
    public WebElement passwordInput;

    @FindBy(id = "loginBtn")
    public WebElement loginButton;
}