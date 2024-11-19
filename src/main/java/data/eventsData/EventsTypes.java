package data.eventsData;

import org.openqa.selenium.By;

public enum EventsTypes {
    ALL_EVENTS (By.xpath("//div[@class = 'dod_new-events-dropdown js-dod_new_events-dropdown dod_new-events-dropdown_opened']/child::div[2]/child::a[1]")),
    INTENSIVES (By.xpath("//div[@class = 'dod_new-events-dropdown js-dod_new_events-dropdown dod_new-events-dropdown_opened']/child::div[2]/child::a[2]")),
    DOD (By.xpath("//div[@class = 'dod_new-events-dropdown js-dod_new_events-dropdown dod_new-events-dropdown_opened']/child::div[2]/child::a[3]")),
    OPEN_VEBINARS (By.xpath("//div[@class = 'dod_new-events-dropdown js-dod_new_events-dropdown dod_new-events-dropdown_opened']/child::div[2]/child::a[4]")),
    ONLINE_MEETUPS (By.xpath("//div[@class = 'dod_new-events-dropdown js-dod_new_events-dropdown dod_new-events-dropdown_opened']/child::div[2]/child::a[5]"));

    private By selector;

    EventsTypes(By selector){
        this.selector = selector;
    }

    public By getSelector() {
        return selector;
    }
}
