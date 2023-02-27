import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import org.hamcrest.MatcherAssert;
import pages.HeaderPageMesto;
import pages.LoginPageMesto;

// Класс с автотестом
public class checkEmailInHeader {

    private WebDriver driver;

    @Test
    public void checkEmailInHeader() {
        // создали драйвер для браузера Chrome
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        // перешли на страницу тестового приложения
        driver.get("https://qa-mesto.praktikum-services.ru/");

        // создай объект класса страницы авторизации
            LoginPageMesto objLoginPage = new LoginPageMesto(driver);

        // выполни авторизацию
        String email = "makhmutov_16@gmail.com";
        String password = "123456";
        // передавай эти переменные внутрь метода
                objLoginPage.login(email, password);

        // создай объект класса заголовка приложения
            HeaderPageMesto objHeaderPage = new HeaderPageMesto(driver);
        // дождись загрузки заголовка
            objHeaderPage.waitForLoadHeader();
        // получи текст элемента в заголовке
        String actual = objHeaderPage.emailInHeader();
        // сделай проверку, что полученное значение совпадает с email
        MatcherAssert.assertThat(actual, is(email));

    }
    @After
    public void tearDown() {
        // Закрой браузер
            driver.quit();
    }
}