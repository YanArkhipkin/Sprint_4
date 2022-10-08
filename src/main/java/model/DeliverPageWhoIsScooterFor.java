package model;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeliverPageWhoIsScooterFor {
    private WebDriver driver;
    //Кнопка "Заказать"
    private final static By HEADER_ORDER_BUTTON = By.xpath("//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");

    //Поле "Имя"
    private final static By FIRST_NAME = By.xpath("//input[@placeholder='* Имя']");

    //Поле "Фамилия"
    private final static By LAST_NAME = By.xpath("//input[@placeholder='* Фамилия']");
    //Поле "Адрес"
    private final static By DELIVER_ADDRESS = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    //Поле "Станция метро" и ее выбор
    private final static By METRO_STATION = By.xpath("//input[@placeholder='* Станция метро']");

    //Поле "Телефон"
    private final static By PHONE_NUMBER = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");

    //Кнопка "Далее"
    private final static By NEXT_BUTTON = By.className("Button_Middle__1CSJM");

    public DeliverPageWhoIsScooterFor(WebDriver driver) {
        this.driver = driver;
    }

    public void headerOrderButtonClick() {
        driver.findElement(HEADER_ORDER_BUTTON).click();
    }

    public void firstNameSendKeys(String firstName) {
        driver.findElement(FIRST_NAME).sendKeys(firstName);
    }

    public void lastNameSendKeys(String lastName) {
        driver.findElement(LAST_NAME).sendKeys(lastName);
    }

    public void deliverAddressSendKeys(String deliverAddress) {
        driver.findElement(DELIVER_ADDRESS).sendKeys(deliverAddress);
    }

    public void chooseMetroStation() {
        driver.findElement(METRO_STATION).click();
        new WebDriverWait(driver, 2);
        driver.findElement(METRO_STATION).sendKeys(Keys.DOWN);
        driver.findElement(METRO_STATION).sendKeys(Keys.ENTER);
    }

    public void phoneNumberSendKeys(String phoneNumber) {
        driver.findElement(PHONE_NUMBER).sendKeys(phoneNumber);
    }

    public void nextButtonClick() {
        driver.findElement(NEXT_BUTTON).click();
    }
}
