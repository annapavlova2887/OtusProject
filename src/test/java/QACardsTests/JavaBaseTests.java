package QACardsTests;

import factory.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.MainPage;
import pages.courses.CoursPage;
import pages.courses.QACoursesBasePage;
import qaData.JavaBasic;

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
        MainPage cardsPage = new MainPage(driver);
        cardsPage.open(path);
        QACoursesBasePage javaBasePage = new QACoursesBasePage(driver);
        javaBasePage.cardClick(JavaBasic.CARD_NAME.getSelector());
        CoursPage javaBasic = new CoursPage(driver);
        javaBasic.checkElement(JavaBasic.NAME.getSelector(), JavaBasic.NAME.getData());
        javaBasic.checkElement(JavaBasic.DISCRIPTION.getSelector(), JavaBasic.DISCRIPTION.getData());
        javaBasic.checkElement(JavaBasic.DURATION.getSelector(), JavaBasic.DURATION.getData());
        javaBasic.checkElement(JavaBasic.FORM.getSelector(), JavaBasic.FORM.getData());
    }
}
