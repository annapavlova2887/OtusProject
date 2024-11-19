package data.qaData;

import org.openqa.selenium.By;

public enum JavaBasic {
    CARD_NAME (By.xpath("//a[@href='/lessons/java-qa-basic']"), "Java QA Engineer. Basic"),
    NAME (By.cssSelector("[class = 'sc-1og4wiw-0 sc-s2pydo-1 iLVLDh diGrSa']"), "Java QA Engineer. Basic"),
    DISCRIPTION (By.cssSelector("[class = 'sc-1og4wiw-0 sc-s2pydo-3 jfNqTr dZDxRw']"), "Курс по автоматизации тестирования на Java для начинающих: синтаксис Java, автотесты для UI и API, фреймворки"),
    DURATION (By.xpath("//div[@class='sc-3cb1l3-3 jeNzke']/descendant::p[position()=3]"), "5 месяцев"),
    FORM (By.xpath("//div[@class='sc-3cb1l3-3 jeNzke']/descendant::p[position()=4]"), "Онлайн");

    private By selector;
    private String data;

    JavaBasic(By selector, String data) {
        this.selector = selector;
        this.data = data;
    }

    public By getSelector() {
        return selector;
    }

    public String getData() {
        return data;
    }
}
