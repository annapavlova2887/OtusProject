package pages;

import common.AbsCommon;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public abstract class AbsBasePage extends AbsCommon {
    public AbsBasePage(WebDriver driver) {
        super(driver);
    }

    private String BASE_URL = System.getProperty("base.url");
    private String educButtSelector = "[title='Обучение']";
    private String testButtonSelector = "//a[contains(text(),'Тестирование')]";
    private String allCoursesSelector = "//p[contains(text(), 'Все курсы')]";

    public void open(String path) {
        driver.get(BASE_URL + path);
    }

    public WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> getElements(By locator) {
        return driver.findElements(locator);
    }

    public AbsBasePage buttonClick(WebElement element) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        return this;
    }

    public void educationClick() {
        WebElement educButton = getElement(By.cssSelector(educButtSelector));
        WebElement allCoursesHead = getElement(By.xpath(allCoursesSelector));
        Assertions.assertFalse(allCoursesHead.isDisplayed());
        webDriverWait.until(ExpectedConditions.visibilityOf(educButton));
        action.moveToElement(educButton);
        action.perform();
        Assertions.assertTrue(allCoursesHead.isDisplayed());
    }

    public void qaClick() {
        WebElement testingButt = getElement(By.xpath(testButtonSelector));
        buttonClick(testingButt);
    }

    public void assertCount(By locator, int data) {
        List<WebElement> countOfelements = getElements(locator);
        int expectedCount = countOfelements.size();
        Assertions.assertEquals(data, expectedCount);
    }
}