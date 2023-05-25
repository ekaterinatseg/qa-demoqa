package org.tsegelnikova.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.tsegelnikova.config.BrowsersFactory;

import java.time.Duration;

public class WaitUtil {
    private WaitUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static WebElement waitTimeout(By element) {
        return waitTimeout(element, ParsingUtil.getConfig().getStandardWaitTimeout());
    }

    public static WebElement waitTimeout(By element, int time) {
        WebDriverWait wait = new WebDriverWait(BrowsersFactory.getDriver(), Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public static void waitUntilInvisibility(By element, int time) {
        WebDriverWait wait = new WebDriverWait(BrowsersFactory.getDriver(), Duration.ofSeconds(time));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
    }

    public static WebElement waitForElementToBeClickable(By element) {
        return waitForElementToBeClickable(element, ParsingUtil.getConfig().getStandardWaitTimeout());
    }

    public static WebElement waitForElementToBeClickable(By element, int time) {
        WebDriverWait wait = new WebDriverWait(BrowsersFactory.getDriver(), Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitFrame(By frameName) {
        waitFrame(frameName, ParsingUtil.getConfig().getStandardWaitTimeout());
    }

    public static void waitFrame(By frameName, int time) {
        WebDriverWait wait = new WebDriverWait(BrowsersFactory.getDriver(), Duration.ofSeconds(time));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameName));
    }

    public static void waitTabTargetCount(int tabCount) {
        waitTabTargetCount(tabCount, ParsingUtil.getConfig().getStandardWaitTimeout());
    }

    public static void waitTabTargetCount(int tabCount, int time) {
        WebDriverWait wait = new WebDriverWait(BrowsersFactory.getDriver(), Duration.ofSeconds(time));
        wait.until(ExpectedConditions.numberOfWindowsToBe(tabCount));
    }
}
