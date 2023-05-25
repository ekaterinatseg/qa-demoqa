package org.tsegelnikova.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.tsegelnikova.dto.Browsers;
import org.tsegelnikova.dto.Config;
import org.tsegelnikova.util.ParsingUtil;

import java.time.Duration;

public class BrowsersFactory {
    private static WebDriver driver = getDriver();

    private static void initBrowser() {
        Config config = ParsingUtil.getConfig();

        Browsers browserName = Browsers.valueOf(config.getBrowserName().toUpperCase());

        if (browserName == Browsers.CHROME) {
            driver = createChromeBrowser(config.getBrowserArguments());
        } else if (browserName == Browsers.FIREFOX) {
            driver = createFirefoxBrowser(config.getBrowserArguments());
        } else {
            throw new RuntimeException("Not existing browser");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(config.getImplicitWaitTimeout()));
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            initBrowser();
        }

        return driver;
    }

    public static void quit() {
        driver.quit();
        driver = null;
    }

    private static RemoteWebDriver createChromeBrowser(String arguments) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments(arguments);
        return new ChromeDriver(options);
    }

    private static RemoteWebDriver createFirefoxBrowser(String arguments) {
        WebDriverManager.chromedriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments(arguments);
        return new FirefoxDriver(options);
    }
}
