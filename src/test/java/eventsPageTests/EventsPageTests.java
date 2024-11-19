package eventsPageTests;

import factory.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.events.EventsBasePage;
import data.eventsData.EventsTypes;

public class EventsPageTests {
    private WebDriver driver;
    private String path = "";


    @BeforeAll
    public static void init() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void initDriver() {
        this.driver = new WebDriverFactory().getDriver();
    }

    @AfterEach
    public void close() {
        if (this.driver != null) {
            this.driver.close();
            this.driver.quit();
        }
    }

    @Test
    public void CountOfEvents() {
        EventsBasePage eventsPage = new EventsBasePage(driver);
        eventsPage.open(path);
        eventsPage.educationClick();
        eventsPage.eventsClick();
        eventsPage.selectType(EventsTypes.OPEN_VEBINARS);
        eventsPage.checkType();
    }

    @Test
    public void CheckEventsDate() {
        EventsBasePage eventsPage = new EventsBasePage(driver);
        eventsPage.open(path);
        eventsPage.educationClick();
        eventsPage.eventsClick();
        eventsPage.checkDate();
    }
}
