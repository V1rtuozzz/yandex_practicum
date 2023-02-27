package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// Класс заголовка
public class HeaderPageMesto {

    private WebDriver driver;
    // локатор для элемента c email в заголовке страницы
    private By headerUser = By.className("header__user");

    public HeaderPageMesto(WebDriver driver){
        this.driver = driver;
    }
    // метод ожидания загрузки страницы
    public void waitForLoadHeader(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("header__user")));
    }
    // метод для получения текста элемента в заголовке
        public String emailInHeader(){
        return
            driver.findElement(headerUser).getText();
        }
}