package Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.URL;

public abstract class BaseScript {

    protected static WebDriver driver;

    protected static void setDriver() {
        // проследить, что бы geckodriver соответствовал ОС на которой воспроизводятся тесты
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//src//resources//geckodriver");
        driver =  new FirefoxDriver();
    }

    public static WebElement getElement(String locator) {
        return driver.findElement(By.cssSelector(locator));
    }

    protected static void openUrl(String url) {
        driver.get(url);
    }

    public static void click(String locator) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.cssSelector(locator)));
        getElement(locator).click();
    }

    protected static void set(String locator, String value) {
        getElement(locator).sendKeys(value);
    }

    protected static void verifyAttributePresent(String locator, String attribute, String value) {
        if (!getElement(locator).getAttribute(attribute).contains(value)) {
            throw new RuntimeException(String.format("Attribute \"%s\" doesn`t conains value \"%s\"", attribute, value));
        }
    }
}
