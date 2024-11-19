package factory;
import exceptions.BrowserNotFoundExpectation;
import factory.impl.ChromeSettings;
import factory.impl.FireFoxSettings;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverFactory {

    private String browserName = System.getProperty("browser");

    public WebDriver getDriver() {
        switch (browserName.toLowerCase().trim()) {
            case "chrome": {
                return new ChromeDriver((ChromeOptions) new ChromeSettings().setting());
            } case "firefox": {
                return new FirefoxDriver((FirefoxOptions) new FireFoxSettings().setting());
            }
        }
        throw new BrowserNotFoundExpectation(browserName);
    }

}