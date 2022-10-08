package model;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeliverPageAboutRent {
    private WebDriver driver;

    //Поле "Дата"
    private final static By DELIVER_DATE = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    //Поле "Число дней"
    private final static By DURATION_OF_DAYS = By.className("Dropdown-placeholder");
    private final static By CHOOSE_DURATION_OF_DAYS = By.xpath("//div[@class=\"Dropdown-menu\"]/div[text()='двое суток']");

    //Кнопка "Заказать"
    private final static By MIDDLE_ORDER_BUTTON = By.xpath("//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");

    //Кнопка "Да"
    private final static By CONFIRM_ORDER = By.xpath("//div[@class='Order_Buttons__1xGrp']/button[text()='Да']");

    public DeliverPageAboutRent(WebDriver driver) {
        this.driver = driver;
    }

    public void chooseDeliverDate() {
        driver.findElement(DELIVER_DATE).click();
        new WebDriverWait(driver, 2);
        driver.findElement(DELIVER_DATE).sendKeys(Keys.DOWN);
        driver.findElement(DELIVER_DATE).sendKeys(Keys.ENTER);
    }

    public void chooseDurationOfDays() {
        driver.findElement(DURATION_OF_DAYS).click();
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"Dropdown-menu\"]")));
        driver.findElement(CHOOSE_DURATION_OF_DAYS).click();
    }

    public void middleOrderButtonCLick() {
        driver.findElement(MIDDLE_ORDER_BUTTON).click();
    }

    public void confirmOrderClick() {
        driver.findElement(CONFIRM_ORDER).click();
    }

}
