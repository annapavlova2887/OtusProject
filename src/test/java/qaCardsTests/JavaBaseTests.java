package qaCardsTests;

import factory.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.courses.CoursPage;
import data.qaData.JavaBasic;

public class JavaBaseTests {
    private WebDriver driver;
    private String path = "/catalog/courses?categories=testing";


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
    public void JavaBaseNameTest() {
        CoursPage javaBasic = new CoursPage(driver);
        javaBasic.open(path);
        javaBasic.cardClick(JavaBasic.CARD_NAME);
        javaBasic.checkElement(JavaBasic.NAME.getSelector(), JavaBasic.NAME.getData());
        javaBasic.checkElement(JavaBasic.DISCRIPTION.getSelector(), JavaBasic.DISCRIPTION.getData());
        javaBasic.checkElement(JavaBasic.DURATION.getSelector(), JavaBasic.DURATION.getData());
        javaBasic.checkElement(JavaBasic.FORM.getSelector(), JavaBasic.FORM.getData());
    }
}
