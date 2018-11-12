package Utils;

import org.openqa.selenium.remote.BrowserType;

public class Properties {
    private static final String HOST = "http://prestashop-automation.qatestlab.com.ua";
    private static final String ADMIN_URL = HOST + "/admin147ajyvk0/";
    private static final String DEFAULT_BROWSER = BrowserType.FIREFOX;

    public static String getBaseUrl() {
        return System.getProperty(EnvironmentVariables.BASE_URL.toString(), HOST);
    }

    public static String getAdminUrl() {
        return System.getProperty(EnvironmentVariables.BASE_ADMIN_URL.toString(), ADMIN_URL);
    }

    public static String getBrowser() {
        return System.getProperty(EnvironmentVariables.BROWSER.toString(), DEFAULT_BROWSER);
    }
}

enum EnvironmentVariables {
    BASE_URL("env.url"),
    BASE_ADMIN_URL("env.admin.url"),
    BROWSER("browser");

    private String value;
    EnvironmentVariables(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
