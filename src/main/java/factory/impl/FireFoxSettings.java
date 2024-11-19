package factory.impl;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;

public class FireFoxSettings implements IWebDriverSettings {

    @Override
    public AbstractDriverOptions setting() {
        FirefoxOptions fireFoxOptions = new FirefoxOptions();
        fireFoxOptions.addArguments("--start-fullscreen");
        fireFoxOptions.addArguments("--disable-popup-blocking");
        fireFoxOptions.addArguments("--disable-notifications");
        return fireFoxOptions;
    }
}
