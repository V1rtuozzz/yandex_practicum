import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class scrollToFirstCard {
    private WebDriver driver;

    @Test
    public void test() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa-mesto.praktikum-services.ru/");
        // Авторизация
        driver.findElement(By.id("email")).sendKeys("makhmutov_16@gmail.com");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.className("auth-form__button")).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("places__list")));
        // Поиск карточки контента и скролл до неё
        WebElement element = driver.findElement(By.className("places__list"));
        // Прокрутка страницы до футера
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
