import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import model.MainPage;
import static org.hamcrest.CoreMatchers.is;

public class CheckAnswersRightTest {
    //В каждом тесте проверяется правильность текстов в ответах
    private ChromeDriver driver;
    private final static String URL = "https://qa-scooter.praktikum-services.ru/";

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL);
    }

    @Test
    public void correspondingFirstTextOpensAfterClick() {
        MainPage mainPage = new MainPage(driver);
        mainPage.cookieConfirmButtonClick();
        mainPage.theFirstQuestionClick();
        MatcherAssert.assertThat(mainPage.theFirstAnswerText(), is("Сутки — 400 рублей. Оплата курьеру — наличными или картой."));
    }

    @Test
    public void correspondingSecondTextOpensAfterClick() {
        MainPage mainPage = new MainPage(driver);
        mainPage.cookieConfirmButtonClick();
        mainPage.theSecondQuestionClick();
        MatcherAssert.assertThat(mainPage.theSecondAnswerText(), is("Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."));
    }

    @Test
    public void correspondingThirdTextOpensAfterClick() {
        MainPage mainPage = new MainPage(driver);
        mainPage.cookieConfirmButtonClick();
        mainPage.theThirdQuestionClick();
        MatcherAssert.assertThat(mainPage.theThirdAnswerText(), is("Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."));
    }

    @Test
    public void correspondingFourthTextOpensAfterClick() {
        MainPage mainPage = new MainPage(driver);
        mainPage.cookieConfirmButtonClick();
        mainPage.theFourthQuestionClick();
        MatcherAssert.assertThat(mainPage.theFourthAnswerText(), is("Только начиная с завтрашнего дня. Но скоро станем расторопнее."));
    }

    @Test
    public void correspondingFifthTextOpensAfterClick() {
        MainPage mainPage = new MainPage(driver);
        mainPage.cookieConfirmButtonClick();
        mainPage.theFifthQuestionClick();
        MatcherAssert.assertThat(mainPage.theFifthAnswerText(), is("Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."));
    }

    @Test
    public void correspondingSixthTextOpensAfterClick() {
        MainPage mainPage = new MainPage(driver);
        mainPage.cookieConfirmButtonClick();
        mainPage.theSixthQuestionClick();
        MatcherAssert.assertThat(mainPage.theSixthAnswerText(), is("Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."));
    }

    @Test
    public void correspondingSeventhTextOpensAfterClick() {
        MainPage mainPage = new MainPage(driver);
        mainPage.cookieConfirmButtonClick();
        mainPage.theSeventhQuestionClick();
        MatcherAssert.assertThat(mainPage.theSeventhAnswerText(), is("Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."));
    }

    @Test
    public void correspondingEighthTextOpensAfterClick() {
        MainPage mainPage = new MainPage(driver);
        mainPage.cookieConfirmButtonClick();
        mainPage.theEighthQuestionClick();
        MatcherAssert.assertThat(mainPage.theEighthAnswerText(), is("Да, обязательно. Всем самокатов! И Москве, и Московской области."));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
