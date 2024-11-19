package pages.events;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.AbsBasePage;
import data.eventsData.EventsTypes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class EventsBasePage extends AbsBasePage {
    public EventsBasePage(WebDriver driver) {
        super(driver);
    }

    private String typeData = "Открытый вебинар";
    private By typeSelector = By.cssSelector("[class=dod_new-type__text]");
    private By eventSelectSelector = By.xpath("//div[@class='dod_new-events-dropdown js-dod_new_events-dropdown']/child::div[1]");
    private By eventSelectOpenSelector = By.xpath("//div[@class = 'dod_new-events-dropdown js-dod_new_events-dropdown dod_new-events-dropdown_opened']/child::div[2]");
    private By eventDateSelector = By.xpath("//div[@class = 'dod_new-event__time']/child::span[1]/child::span[2]");

    public void selectType(EventsTypes type) {
        WebElement eventSelector = getElement(eventSelectSelector);
        eventSelector.click();
        WebElement openEventSelector = getElement(eventSelectOpenSelector);
        webDriverWait.until(ExpectedConditions.visibilityOf(openEventSelector));
        Assertions.assertTrue(openEventSelector.isDisplayed());
        WebElement select = getElement(type.getSelector());
        webDriverWait.until(ExpectedConditions.visibilityOf(select));
        select.click();
    }

    public void checkType() {
        List<WebElement> allEvents = getElements(typeSelector);
        for (WebElement el: allEvents) {
            Assertions.assertEquals(typeData, el.getText());
        }
        logger.info("Тип мероприятия соответствует: " + typeData);
    }

    public void checkDate() {
        List<WebElement> allDates = getElements(eventDateSelector);
        LocalDate now = LocalDate.now();
        ZoneId defaultZoneId = ZoneId.systemDefault();
        Instant instant = now.atStartOfDay(defaultZoneId).toInstant();
        Date dateNow = Date.from(instant);

        int yy = now.getYear();
        SimpleDateFormat formatter = new SimpleDateFormat("d MMMM yyyy", new Locale("ru"));

        for (WebElement el : allDates) {
        String dateFromCard = el.getText().trim() + " " + yy;
        try {
            Date date = formatter.parse(dateFromCard);
            Assertions.assertTrue(date.getTime() >= dateNow.getTime());
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        logger.info("Указанные даты больше или равны текущей");
    }
}
