package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

// page object — класс для страницы
public class LoginPageMesto {

    private WebDriver driver;
    // локаторы
    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By signInButton = By.className("auth-form__button");
    private By registrationButton = By.className("header__auth-link");

    // Конструктор класса page object
    public LoginPageMesto(WebDriver driver){
        this.driver = driver;
    }
    // метод проверяет, активна ли кнопка «Войти»
    public boolean checkSignInIsEnabled() {

        return driver.findElement(signInButton).isEnabled();
    }
    // метод кликает по кнопке «Войти»
    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }
    // метод логина
    public void login(String username, String password){
        setUsername(username);
        setPassword(password);
        clickSignInButton();
    }

    private void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    private void setUsername(String username) {
        driver.findElement(emailField).sendKeys(username);
    }

    // метод кликает по кнопке «Регистрация»
        public void clickRegistrationButton() {
        driver.findElement(registrationButton).click();
        }
        // метод проверяет текст кнопки «Регистрация»
        public void checkTextRegistrationButton() {
            assertEquals("Текст не совпадает", "Регистрация", driver.findElement(registrationButton).getText());
        }
    }