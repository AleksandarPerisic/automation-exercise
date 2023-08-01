package exercise.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.UnreachableBrowserException;

import java.time.Duration;

@Getter
@Slf4j
public class SeleniumConfig {

    protected WebDriver webDriver;
    private Duration browserTimeout;

    public SeleniumConfig() {
        browserTimeout = Duration.ofSeconds(30);
    }

    public void setupWebDriver(DriverManagerType browserType) {
        webDriver =  initializeDriver(browserType);
        clearBrowserCookies(getWebDriver());
        webDriver.get(Paths.BASE_URL);
    }

    private WebDriver initializeDriver(DriverManagerType browserType) {
        if (browserType.equals(DriverManagerType.FIREFOX)) {
            WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
            final FirefoxProfile profile = new FirefoxProfile();
            final FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setProfile(profile);
            webDriver = new FirefoxDriver(firefoxOptions);

        } else if (browserType.equals(DriverManagerType.CHROME)) {
            WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
            ChromeOptions options = new ChromeOptions();
            options.setAcceptInsecureCerts(true);
            options.addArguments("--start-maximized");
            webDriver = new ChromeDriver(options);

        } else if (browserType.equals(DriverManagerType.EDGE)) {
            WebDriverManager.getInstance(DriverManagerType.EDGE).setup();
            InternetExplorerOptions options = new InternetExplorerOptions();
            webDriver = new InternetExplorerDriver(options);
        }
        return webDriver;

    }

    public void clearBrowserCookies(WebDriver webDriver) {
        log.info("clear cookies");
        try {
            webDriver.manage().deleteAllCookies();
        } catch (Exception e) {
            log.error("Could not clear cookies", e);
        }
    }

    public void closeWebDriver() {
        log.info("Closing browser window");
        try {
            webDriver.quit();
        } catch (UnreachableBrowserException | NullPointerException e) {
            log.debug("No webDriver to close for this session ");
        }
    }

}
