package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BrowserFactory {
    private static WebDriver driver;
    private static String browser;
    private static String os;
    private static Logger log = Logger.getLogger(BrowserFactory.class.getName());
    private static String winExtension = ".exe";
    private static String linuxExtension = "";
    private static String chromedriver = "chromedriver";
    private static String geckodriver = "geckodriver";

    private BrowserFactory() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = createDriver();
        }
        return driver;
    }

    private static WebDriver createDriver() {
        os = System.getProperty("os.name").toLowerCase();
        browser = PropertyReader.getTestProperty("browser").toLowerCase();
        String extension = getExtension(os);
        try {
            String canonPath = CommonFunctions.getCanonicalPathToResource();
            switch (browser) {
                case "chrome":
                    driver = setChromeDriver(canonPath, extension);
                    break;
                case "firefox":
                    driver = setFireFoxDriver(canonPath, extension);
                    break;
            }
        } catch (Exception ex) {
            log.log(Level.SEVERE, "Error with driver!", ex);
        }
        return driver;
    }

    private static String getExtension(String os) {
        if (os.contains("windows")) return winExtension;
        else if (os.contains("linux")) return linuxExtension;
        else return null;
    }

    private static WebDriver setChromeDriver(String path, String extension) {
        System.setProperty("webdriver.chrome.driver",
                new StringBuilder().append(path).append(chromedriver).append(extension).toString());
        return driver = new ChromeDriver(getChromeOptions());
    }

    private static WebDriver setFireFoxDriver(String path, String extension) {
        System.setProperty("webdriver.gecko.driver",
                new StringBuilder().append(path).append(geckodriver).append(extension).toString());
        return driver = new FirefoxDriver(getFirefoxOptions());
    }

    private static FirefoxOptions getFirefoxOptions() {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setAcceptUntrustedCertificates(true);
        profile.setPreference("browser.download.folderList", 2);
        profile.setPreference("browser.download.manager.showWhenStarting", false);
        profile.setPreference("browser.download.dir", new StringBuilder()
                .append(CommonFunctions.getCanonicalPathToResource()).append("downloads").toString());
        profile.setPreference("browser.helperApps.alwaysAsk.force", false);
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
                "application/x-debian-package,application/vnd.microsoft.portable-executable,application/octet-stream");
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);
        return options;
    }

    private static ChromeOptions getChromeOptions() {
        HashMap<String, Object> chromePreference = new HashMap<>();
        chromePreference.put("profile.default_content_settings.popups", 0);
        chromePreference.put("safebrowsing.enabled", "true");
        chromePreference.put("download.default_directory", new StringBuilder()
                .append(CommonFunctions.getCanonicalPathToResource()).append("downloads").toString());
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePreference);
        return options;
    }
}