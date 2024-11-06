package pages.courses;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.AbsBasePage;

public class CoursPage extends AbsBasePage {
    public CoursPage(WebDriver driver) {
        super(driver);
    }
    public void checkElement(By selector, String data) {
        WebElement element = getElement(selector);
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
        Assertions.assertEquals(data, element.getText().trim());
    }
}
