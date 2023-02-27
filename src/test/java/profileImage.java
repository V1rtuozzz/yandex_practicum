import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class profileImage {

    private WebDriver driver;

    @Test
    public void test() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qa-mesto.praktikum-services.ru/");

        // Авторизация
        driver.findElement(By.id("email")).sendKeys("makhmutov_16@gmail.com");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.className("auth-form__button")).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("profile__image")));
        // Клик по изображению профиля
        driver.findElement(By.cssSelector(".profile__image")).click();
        // Ввод ссылки в поле ссылки на изображение
        driver.findElement(By.id("owner-avatar")).sendKeys("https://sun9-21.userapi.com/impg/OUEEwThFTLibV_mUwoYep0YFVpjVkwlIJW60gw/fOAdhcXDYVw.jpg?size=1620x2160&quality=95&sign=0939b3f69aef12a2e779a304b77d2178&type=album");
        // Сохранение нового изображения
        driver.findElement(By.xpath(".//form[@name='edit-avatar']/button[text()='Сохранить']")).click();
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
