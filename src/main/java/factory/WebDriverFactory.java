package factory;
import exceptions.BrowserNotFoundExpectation;
import factory.impl.ChromeSettings;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFactory {

    private String browserName = System.getProperty("browser");

    public WebDriver getDriver() {
        switch (browserName.toLowerCase().trim()) {
            case "chrome": {
                return new ChromeDriver((ChromeOptions) new ChromeSettings().setting());
            }
        }
        throw new BrowserNotFoundExpectation(browserName);
    }

}