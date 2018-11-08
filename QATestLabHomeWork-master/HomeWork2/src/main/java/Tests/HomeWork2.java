package Tests;

import Base.BaseScript;
import Utils.Properties;

import java.util.ArrayList;
import java.util.List;

public class HomeWork2 extends BaseScript {

  private static String adminUrl = Properties.getAdminUrl();

  public static void main(String[] args) {
      // first test
      setDriver();
      openUrl(adminUrl);
      login();
      logout();

      // second test
      setDriver();
      openUrl(adminUrl);
      login();
      List<String> tabsName = new ArrayList<String>();
      tabsName.add("tab-AdminDashboard");
      tabsName.add("subtab-AdminParentOrders");
      tabsName.add("subtab-AdminParentCustomerThreads");
      tabsName.add("subtab-AdminParentModulesSf");
      tabsName.add("subtab-AdminParentThemes");
      tabsName.add("subtab-AdminStats");
      tabsName.add("subtab-AdminParentShipping");
      tabsName.add("subtab-AdminParentPayment");
      tabsName.add("subtab-AdminInternational");
      tabsName.add("subtab-ShopParameters");
      tabsName.add("subtab-AdminParentCustomer");
      tabsName.add("subtab-AdminAdvancedParameters");
      tabsName.add("subtab-AdminCatalog");
      for (String name : tabsName) {
          checkOpenedTabAfterRefresh(name);
      }

      logout();
  }

    private static void login() {
        set("[name = \"email\"]", "webinar.test@gmail.com");
        set("[name = \"passwd\"]", "Xcg7299bnSmMuRLp9ITw");
        click("[name = \"submitLogin\"]");
    }

    private static void checkOpenedTabAfterRefresh(String tabName) {
        BaseScript.click(String.format("#%s .title", tabName));
        System.out.println("The name of active section is " + BaseScript.getElement(String.format("#%s .title span", tabName)).getText());
        driver.navigate().refresh();
        // выполняем проверку что пользователь остается в том же разделе после перезагрузки страницы.
        verifyAttributePresent("#" + tabName, "class", "active");
    }

    private static void logout() {
        click(".employee_avatar_small");
        click("[id = \"header_logout\"]");
    }

}
