package Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public abstract class BaseScript {

    protected WebDriver driver;

    protected void setDriver() {
        // TODO: edit with className.class.getresourses("nameOfGeckorriverInFolderResourses").getPath
        URL url = ClassLoader.getResource("geckodriver.exe");
        System.setProperty("webdriver.gecko.driver", url.toString());
        driver =  new FirefoxDriver();
    }

    public  WebElement getElement(String locator) {
        return driver.findElement(By.cssSelector(locator));
    }

    protected void openUrl(String url) {
        driver.get(url);
    }

    public void click(String locator) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.cssSelector(locator)));
        getElement(locator).click();
    }

    protected void set(String locator, String value) {
        getElement(locator).sendKeys(value);
    }

    protected void verifyAttributePresent(String locator, String attribute, String value) {
        if (!getElement(locator).getAttribute(attribute).contains(value)) {
            throw new RuntimeException(String.format("Attribute \"%s\" doesn`t conains value \"%s\"", attribute, value));
        }
    }
}
