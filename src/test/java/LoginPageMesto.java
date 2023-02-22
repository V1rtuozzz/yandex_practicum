import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// Шаг 1. Создали page object — класс для страницы
public class LoginPageMesto {
    // Шаг 2. Добавили поле driver
    private WebDriver driver;
    // Шаг 3. Добавили локаторы
    // локатор поля «Email»
    private By emailField = By.id("email");
    // локатор поля «Пароль»
    private By passwordField = By.id("password");
    // локатор кнопки входа в приложение
    private By signInButton = By.className("auth-form__button");

    // Шаг 4. Добавили конструктор класса page object
    public LoginPageMesto(WebDriver driver){
        this.driver = driver; // Инициализировали в нём поле driver
    }
    // Шаг 5. Добавили метод, который кликает по кнопке «Войти»
    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }
} 