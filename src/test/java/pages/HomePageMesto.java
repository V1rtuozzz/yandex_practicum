package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePageMesto {
    private WebDriver driver;

    private By profileTitle = By.className("profile__title");
    private By editProfileButton = By.className("profile__edit-button");
    private By activity = By.id("profile__description");

    public HomePageMesto(WebDriver driver) {
        this.driver = driver;
    }

    // метод ожидания прогрузки данных профиля
    public void waitForLoadProfileData() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(driver -> (driver.findElement(profileTitle).getText() != null
                && !driver.findElement(profileTitle).getText().isEmpty()
        ));
    }
    // метод для нажатия на кнопку редактирования профиля
    public void clickEditButton(){
            driver.findElement(editProfileButton).click();
    }

    public void waitForChangedActivity(String changed) {
        // здесь нужно дождаться, чтобы текст в элементе «Занятие» стал равен значению из параметра

        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.textToBePresentInElementLocated(activity, changed));
       }
}
