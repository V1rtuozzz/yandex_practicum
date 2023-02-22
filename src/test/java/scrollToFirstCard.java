import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class scrollToFirstCard {
    private WebDriver driver;

    @Test
    public void test() {
        // Создаём драйвер для браузера Chrome
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa-mesto.praktikum-services.ru/");
        // Выполни авторизацию
        driver.findElement(By.id("email")).sendKeys("makhmutov_16@gmail.com");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.className("auth-form__button")).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("places__list")));
        // Найди карточку контента и сделай скролл до неё
        WebElement element = driver.findElement(By.className("places__list"));
        // Прокрути страницу до футера
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}
