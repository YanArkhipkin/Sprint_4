package model;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;
    //Кнопка Принять куки
    private final static By COOKIE_CONFIRM_BUTTON = By.id("rcc-confirm-button");

    //Вопросы и ответы
    //Сколько это стоит? И как оплатить?
    private final static By HOW_IT_COST = By.id("accordion__heading-0");
    private final static By HOW_IT_COST_ANSWER = By.xpath("//*[@id=\"accordion__panel-0\"]/p");
    //Хочу сразу несколько самокатов! Так можно?
    private final static By NEED_SEVERAL_SCOOTERS = By.id("accordion__heading-1");
    private final static By NEED_SEVERAL_SCOOTERS_ANSWER = By.xpath("//*[@id=\"accordion__panel-1\"]/p");
    //Как рассчитывается время аренды?
    private final static By RENT_TIME_CALCULATED = By.id("accordion__heading-2");
    private final static By RENT_TIME_CALCULATED_ANSWER = By.xpath("//*[@id=\"accordion__panel-2\"]/p");
    //Можно ли заказать самокат прямо на сегодня?
    private final static By ORDER_SCOOTER_TODAY = By.id("accordion__heading-3");
    private final static By ORDER_SCOOTER_TODAY_ANSWER = By.xpath("//*[@id=\"accordion__panel-3\"]/p");
    //Можно ли продлить заказ или вернуть самокат раньше?
    private final static By RETURN_SCOOTER_EARLIER = By.id("accordion__heading-4");
    private final static By RETURN_SCOOTER_EARLIER_ANSWER = By.xpath("//*[@id=\"accordion__panel-4\"]/p");
    //Вы привозите зарядку вместе с самокатом?
    private final static By DELIVER_CHARGE = By.id("accordion__heading-5");
    private final static By DELIVER_CHARGE_ANSWER = By.xpath("//*[@id=\"accordion__panel-5\"]/p");
    //Можно ли отменить заказ?
    private final static By CANCEL_ORDER = By.id("accordion__heading-6");
    private final static By CANCEL_ORDER_ANSWER = By.xpath("//*[@id=\"accordion__panel-6\"]/p");
    //Я живу за МКАДом, привезёте?
    private final static By DELIVER_BEYOND_MKAD = By.id("accordion__heading-7");
    private final static By DELIVER_BEYOND_MKAD_ANSWER = By.xpath("//*[@id=\"accordion__panel-7\"]/p");
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    public void cookieConfirmButtonClick() {
        driver.findElement(COOKIE_CONFIRM_BUTTON).click();
    }
    public void theFirstQuestionClick() {
        driver.findElement(HOW_IT_COST).click();
    }
    public String theFirstAnswerText() {
        String firstText = driver.findElement(HOW_IT_COST_ANSWER).getText();
        return firstText;
    }
    public void theSecondQuestionClick() {
        driver.findElement(NEED_SEVERAL_SCOOTERS).click();
    }
    public String theSecondAnswerText() {
        String secondText = driver.findElement(NEED_SEVERAL_SCOOTERS_ANSWER).getText();
        return secondText;
    }
    public void theThirdQuestionClick() {
        driver.findElement(RENT_TIME_CALCULATED).click();
    }
    public String theThirdAnswerText() {
        String thirdText = driver.findElement(RENT_TIME_CALCULATED_ANSWER).getText();
        return thirdText;
    }
    public void theFourthQuestionClick() {
        driver.findElement(ORDER_SCOOTER_TODAY).click();
    }
    public String theFourthAnswerText() {
        String fourthText = driver.findElement(ORDER_SCOOTER_TODAY_ANSWER).getText();
        return fourthText;
    }
    public void theFifthQuestionClick() {
        driver.findElement(RETURN_SCOOTER_EARLIER).click();
    }
    public String theFifthAnswerText() {
        String fifthText = driver.findElement(RETURN_SCOOTER_EARLIER_ANSWER).getText();
        return fifthText;
    }
    public void theSixthQuestionClick() {
        driver.findElement(DELIVER_CHARGE).click();
    }
    public String theSixthAnswerText() {
        String sixthText = driver.findElement(DELIVER_CHARGE_ANSWER).getText();
        return sixthText;
    }
    public void theSeventhQuestionClick() {
        driver.findElement(CANCEL_ORDER).click();
    }
    public String theSeventhAnswerText() {
        String seventhText = driver.findElement(CANCEL_ORDER_ANSWER).getText();
        return seventhText;
    }
    public void theEighthQuestionClick() {
        driver.findElement(DELIVER_BEYOND_MKAD).click();
    }
    public String theEighthAnswerText() {
        String eighthText = driver.findElement(DELIVER_BEYOND_MKAD_ANSWER).getText();
        return eighthText;
    }
}
