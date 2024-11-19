package pages.courses;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CoursPage extends QACoursesBasePage {
    public CoursPage(WebDriver driver) {
        super(driver);
    }
    public void checkElement(By selector, String data) {
        WebElement element = getElement(selector);
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
        // TODO - что сравниваем (в логи передать элемент)
        Assertions.assertEquals(data, element.getText().trim());
        logger.info("Значение элемента соответсвует ожидаемому");
    }
}
