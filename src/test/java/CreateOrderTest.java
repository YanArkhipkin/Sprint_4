import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import model.DeliverPageAboutRent;
import model.DeliverPageWhoIsScooterFor;

@RunWith(Parameterized.class)
public class CreateOrderTest {
    //на хроме тест падает
    WebDriver driver;
    private final static String URL = "https://qa-scooter.praktikum-services.ru/";
    private final String firstName;
    private final String lastName;
    private final String deliverAddress;
    private final String phoneNumber;

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

    @Before
    public void setUp() {
        //WebDriverManager.chromedriver().setup();
        //driver = new ChromeDriver();
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get(URL);
        new WebDriverWait(driver, 3);
    }

    @Test
    public void createOrdersByPushHeaderButton() {
        DeliverPageWhoIsScooterFor orderFirstPage = new DeliverPageWhoIsScooterFor(driver);
        orderFirstPage.headerOrderButtonClick();
        orderFirstPage.firstNameSendKeys(firstName);
        orderFirstPage.lastNameSendKeys(lastName);
        orderFirstPage.deliverAddressSendKeys(deliverAddress);
        orderFirstPage.chooseMetroStation();
        orderFirstPage.phoneNumberSendKeys(phoneNumber);
        orderFirstPage.nextButtonClick();

        DeliverPageAboutRent orderSecondPage = new DeliverPageAboutRent(driver);
        orderSecondPage.chooseDeliverDate();
        orderSecondPage.chooseDeliverDate();
        orderSecondPage.chooseDurationOfDays();
        orderSecondPage.secondOrderButtonCLick();
        orderSecondPage.confirmOrderClick();

        //Проверяется наличие кнопки Посмотреть статус после завершения заказа
        driver.findElement(By.xpath("//div[@class='Order_NextButton__1_rCA']/button[text()='Посмотреть статус']")).isDisplayed();
    }

    @Test
    public void createOrdersByPushMiddleButton() {
        DeliverPageWhoIsScooterFor orderFirstPage = new DeliverPageWhoIsScooterFor(driver);
        orderFirstPage.middleOrderButtonClick();
        orderFirstPage.firstNameSendKeys(firstName);
        orderFirstPage.lastNameSendKeys(lastName);
        orderFirstPage.deliverAddressSendKeys(deliverAddress);
        orderFirstPage.chooseMetroStation();
        orderFirstPage.phoneNumberSendKeys(phoneNumber);
        orderFirstPage.nextButtonClick();

        DeliverPageAboutRent orderSecondPage = new DeliverPageAboutRent(driver);
        orderSecondPage.chooseDeliverDate();
        orderSecondPage.chooseDeliverDate();
        orderSecondPage.chooseDurationOfDays();
        orderSecondPage.secondOrderButtonCLick();
        orderSecondPage.confirmOrderClick();

        //Проверяется наличие кнопки Посмотреть статус после завершения заказа
        driver.findElement(By.xpath("//div[@class='Order_NextButton__1_rCA']/button[text()='Посмотреть статус']")).isDisplayed();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
