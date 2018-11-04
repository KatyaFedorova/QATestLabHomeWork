package HomeWork2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeWork2 {

  private static WebDriver driver;
  private static String adminUrl = "http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/";

  public static void main(String[] args) {
      // first test
      scriptA();
      // second test
      scriptB();
  }

  private static void scriptA() {
      setDriver();
      openUrl(adminUrl);
      login();
      logout();
    }

  private static void scriptB() {
      setDriver();
      openUrl(adminUrl);
      login();
      checkOpenedTabAfterRefresh("tab-AdminDashboard");
      checkOpenedTabAfterRefresh("subtab-AdminParentOrders");
      checkOpenedTabAfterRefresh("subtab-AdminParentCustomerThreads");
      checkOpenedTabAfterRefresh("subtab-AdminParentModulesSf");
      checkOpenedTabAfterRefresh("subtab-AdminParentThemes");
      checkOpenedTabAfterRefresh("subtab-AdminStats");
      checkOpenedTabAfterRefresh("subtab-AdminParentShipping");
      checkOpenedTabAfterRefresh("subtab-AdminParentPayment");
      checkOpenedTabAfterRefresh("subtab-AdminInternational");
      checkOpenedTabAfterRefresh("subtab-ShopParameters");
      checkOpenedTabAfterRefresh("subtab-AdminParentCustomer");
      checkOpenedTabAfterRefresh("subtab-AdminAdvancedParameters");
      checkOpenedTabAfterRefresh("subtab-AdminCatalog");
      logout();
    }

  private static void checkOpenedTabAfterRefresh(String tabName) {
    click(String.format("#%s .title", tabName));
    System.out.println("The name of active section is " + getElement(String.format("#%s .title span", tabName)).getText());
    driver.navigate().refresh();
    verifyAttributePresent("#" + tabName, "class", "active");
  }

  private static void setDriver () {
    // TODO: edit with className.class.getresourses("nameOfGeckorriverInFolderResourses").getPath
    System.setProperty("webdriver.gecko.driver", "C:\\Users\\Федя\\Documents\\GitHub\\HomeWork2\\src\\main\\resources\\geckodriver.exe");
    driver =  new FirefoxDriver();
  }
  private static void openUrl(String url) {
    driver.get(url);
  }

  private static void login() {
    set("[name = \"email\"]", "webinar.test@gmail.com");
    set("[name = \"passwd\"]", "Xcg7299bnSmMuRLp9ITw");
    click("[name = \"submitLogin\"]");
  }

  private static void logout() {
    click(".employee_avatar_small");
    click("[id = \"header_logout\"]");
  }

  private static void set(String locator, String value) {
    getElement(locator).sendKeys(value);
  }

  private static WebElement getElement(String locator) {
    return driver.findElement(By.cssSelector(locator));
  }

  private static void click(String locator) {
    new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.cssSelector(locator)));
    getElement(locator).click();
  }

  private static void verifyAttributePresent(String locator, String attribute, String value) {
      if (!getElement(locator).getAttribute(attribute).contains(value)) {
        throw new RuntimeException(String.format("Attribute \"%s\" doesn`t conains value \"%s\"", attribute, value));
      }
  }
}
