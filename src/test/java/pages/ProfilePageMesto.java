package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.sql.Driver;

public class ProfilePageMesto {

    private WebDriver driver;
    private By activity = By.id("owner-description");
    private By save = By.xpath("//*[@id=\"root\"]/div/div[1]/div/form/button[2]");

    public ProfilePageMesto (WebDriver driver){
        this.driver = driver;
    }

    // метод для проверки открытости поля «Занятие», удаления текста из неё и ввода нового значения из параметра
    public void ownerDescriptionChanged(String newValue) {
                driver.findElement(activity).isEnabled();
                driver.findElement(activity).clear();
                driver.findElement(activity).sendKeys(newValue);

    }

            // метод для нажатия на кнопку сохранения профиля
            public void saveActivity() {
        driver.findElement(save).click();

}

}
