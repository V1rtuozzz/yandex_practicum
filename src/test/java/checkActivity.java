import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import org.hamcrest.MatcherAssert;
import pages.HeaderPageMesto;
import pages.HomePageMesto;
import pages.LoginPageMesto;
import pages.ProfilePageMesto;

public class checkActivity {

    private WebDriver driver;

    @Test
    public void checkActivity() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa-mesto.praktikum-services.ru/");

        LoginPageMesto objLoginPage = new LoginPageMesto(driver);
        objLoginPage.login("makhmutov_16@gmail.com",
                "123456");

        // создай объект класса главной страницы приложения
        HomePageMesto objHomePage = new HomePageMesto(driver);
        // дождись загрузки данных профиля на главной странице
        objHomePage.waitForLoadProfileData();
        // кликни на кнопку редактирования профиля
        objHomePage.clickEditButton();
        // создай объект класса для поп-апа редактирования профиля
        ProfilePageMesto objProfilePage = new ProfilePageMesto(driver);
        // это переменная со значением, которое надо ввести в поле «Занятие»
        String newActivity = "Тестировщик";
        // в одном шаге проверь, что поле «Занятие» доступно для редактирования, и введи в него новое значение
        objProfilePage.ownerDescriptionChanged(newActivity);
        // сохрани изменения в профиле
        objProfilePage.saveActivity();
        // проверь, что поле «Занятие» на основной странице поменяло значение на новое
        objHomePage.waitForChangedActivity(newActivity);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}