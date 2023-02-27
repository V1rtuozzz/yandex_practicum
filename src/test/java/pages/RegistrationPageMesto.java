package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPageMesto {

    private WebDriver driver;
    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By signUpButton = By.className("auth-form__button");

    public RegistrationPageMesto(WebDriver driver){
        this.driver = driver;
    }
    public void setUsername(String email) {
        driver.findElement(emailField).sendKeys(email);
    }
    // метод заполняет поле «Пароль»
    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys();
    }
    // метод кликает по кнопке «Регистрация»
    public void clickSignUpButton() {
        driver.findElement(signUpButton).click();
    }
    // метод регистрации в приложении: объединяет ввод email, пароля и клик по кнопке
    public void register(String email, String password){
        setUsername(email);
        setPassword(password);
        clickSignUpButton();
    }
}