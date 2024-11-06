package pages.courses;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.AbsBasePage;

public class QACoursesBasePage extends AbsBasePage {
    public QACoursesBasePage(WebDriver driver) {
        super(driver);
    }

    private int countOfCourses = 10;
    private By cardsSelector = By.xpath("//div[@class= 'sc-18q05a6-1 bwGwUO' ]/child::*");

    public void countOfCourses() {
        assertCount(cardsSelector, countOfCourses);
    }

    public void cardClick (By selector) {
        WebElement card = getElement(selector);
        buttonClick(card);
    }


}