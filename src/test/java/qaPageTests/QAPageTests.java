package qaPageTests;

import factory.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.courses.QACoursesBasePage;


public class QAPageTests {

    private WebDriver driver;
    private String path = "";//"/catalog/courses?categories=testing";


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
    public void CountOfCoursesTest() {
        QACoursesBasePage qaBasePage = new QACoursesBasePage(driver);
        qaBasePage.open(path);
        qaBasePage.educationClick();
        qaBasePage.qaClick();
        qaBasePage.countOfCourses();
    }
}