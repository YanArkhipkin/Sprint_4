import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import model.DeliverPageAboutRent;
import model.DeliverPageWhoIsScooterFor;

@RunWith(Parameterized.class)
public class CreateOrderTest {
    //на хроме тест падает
    private FirefoxDriver driverFirefox;
    private ChromeDriver driver;
    //Модальное окно Заказ оформлен

    private String firstName;
    private String lastName;
    private String deliverAddress;
    private String phoneNumber;

    public CreateOrderTest(String firstName, String lastName, String deliverAddress, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.deliverAddress = deliverAddress;
        this.phoneNumber = phoneNumber;
    }

    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][] {
                {"Василий", "Иванов", "Москва, Ленина, 23", "+79976195794"},
                {"Иван", "Васильев", "Москва, Сталина, 57", "+79961235769"},
        };
    }

    @Test
    public void createOrdersWithDifferentDataChromeTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        new WebDriverWait(driver, 3);

        DeliverPageWhoIsScooterFor orderFirstPage = new DeliverPageWhoIsScooterFor(driver);
        orderFirstPage.headerOrderButtonClick();
        orderFirstPage.firstNameSendKeys(firstName);
        orderFirstPage.lastNameSendKeys(lastName);
        orderFirstPage.deliverAddressSendKeys(deliverAddress);
        orderFirstPage.chooseMetroStation();
        orderFirstPage.phoneNumberSendKeys(phoneNumber);
        orderFirstPage.nextButtonClick();

        new WebDriverWait(driver, 2);

        DeliverPageAboutRent orderSecondPage = new DeliverPageAboutRent(driver);
        orderSecondPage.chooseDeliverDate();
        new WebDriverWait(driver, 2);
        orderSecondPage.chooseDeliverDate();
        orderSecondPage.chooseDurationOfDays();
        orderSecondPage.middleOrderButtonCLick();
        orderSecondPage.confirmOrderClick();

        //Проверяется наличие кнопки Посмотреть статус после завершения заказа
        driver.findElement(By.xpath("//div[@class='Order_NextButton__1_rCA']/button[text()='Посмотреть статус']")).isDisplayed();

        driver.quit();

    }


    @Test
    public void createOrdersWithDifferentDataFirefoxTest() {
        System.setProperty("webdriver.gecko.driver", "C:\\WebDriver\\bin\\firefoxDriver\\geckodriver.exe");
        driverFirefox = new FirefoxDriver();
        driverFirefox.get("https://qa-scooter.praktikum-services.ru/");
        new WebDriverWait(driverFirefox, 3);

        DeliverPageWhoIsScooterFor orderFirstPage = new DeliverPageWhoIsScooterFor(driverFirefox);
        orderFirstPage.headerOrderButtonClick();
        orderFirstPage.firstNameSendKeys(firstName);
        orderFirstPage.lastNameSendKeys(lastName);
        orderFirstPage.deliverAddressSendKeys(deliverAddress);
        orderFirstPage.chooseMetroStation();
        orderFirstPage.phoneNumberSendKeys(phoneNumber);
        orderFirstPage.nextButtonClick();

        new WebDriverWait(driverFirefox, 2);

        DeliverPageAboutRent orderSecondPage = new DeliverPageAboutRent(driverFirefox);
        orderSecondPage.chooseDeliverDate();
        new WebDriverWait(driverFirefox, 2);
        orderSecondPage.chooseDeliverDate();
        orderSecondPage.chooseDurationOfDays();
        orderSecondPage.middleOrderButtonCLick();
        orderSecondPage.confirmOrderClick();

        //Проверяется наличие кнопки Посмотреть статус после завершения заказа
        driverFirefox.findElement(By.xpath("//div[@class='Order_NextButton__1_rCA']/button[text()='Посмотреть статус']")).isDisplayed();

        driverFirefox.quit();
    }
}
