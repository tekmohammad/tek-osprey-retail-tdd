package tek.tdd.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseSetup {

    private static WebDriver driver;
    private Properties properties;

    //Read Property File In Constructor of BaseSetup Class.
    public BaseSetup() {
        try {
            //File Path
            String filePath = System.getProperty("user.dir")
                    + "/src/test/resources/config/application-config.properties";
            File propertyFile = new File(filePath);
            FileInputStream fileInputStream = new FileInputStream(propertyFile);
            properties = new Properties();
            properties.load(fileInputStream);
        }catch (IOException ex) {
            throw new RuntimeException("Config file is not accessible " + ex.getMessage());
        }
    }

    public void openBrowser() {

        String retailUrl = this.properties.getProperty("ui.url");
        String browserType = this.properties.getProperty("ui.browser");
        boolean isHeadless = Boolean.parseBoolean(this.properties.getProperty("ui.isHeadless"));

        //Cross Browsing Setup.
        switch (browserType) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                if (isHeadless) chromeOptions.addArguments("--headless");
                driver = new ChromeDriver(chromeOptions);
                break;
            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                if (isHeadless) edgeOptions.addArguments("--headless");
                driver = new EdgeDriver(edgeOptions);
                break;
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (isHeadless) firefoxOptions.addArguments("--headless");
                driver = new FirefoxDriver(firefoxOptions);
                break;
            default:
                throw new RuntimeException("Wrong Browser Type");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get(retailUrl);
    }

    public void quitBrowser() {
        if (driver != null)
            driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
