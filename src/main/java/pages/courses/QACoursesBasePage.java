package pages.courses;
import data.qaData.JavaBasic;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.AbsBasePage;

public class QACoursesBasePage extends AbsBasePage {
    public QACoursesBasePage(WebDriver driver) {
        super(driver);
    }

    private int countOfCourses = 10;
    private By cardsSelector = By.xpath("//div[@class= 'sc-18q05a6-1 bwGwUO' ]/child::*");

    public void countOfCourses() {
        assertCount(cardsSelector, countOfCourses);
        logger.info("Количество курсов соответствует ожидаемому");
    }

    public void cardClick(JavaBasic data) {
        WebElement card = getElement(data.getSelector());
        action.moveToElement(card);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(card));
        action.click(card);
        action.perform();
    }
}