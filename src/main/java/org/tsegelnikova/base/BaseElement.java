package org.tsegelnikova.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tsegelnikova.util.WaitUtil;

public abstract class BaseElement {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseElement.class);
    private final By uniqueLocator;
    private final String elementName;
    private final WebDriver driver;

    public BaseElement(By uniqueLocator, String elementName, WebDriver driver) {
        this.uniqueLocator = uniqueLocator;
        this.elementName = elementName;
        this.driver = driver;
    }

    public void click() {
        LOGGER.info("Clicking on button: {}", elementName);
        WaitUtil.waitForElementToBeClickable(uniqueLocator)
                .click();
    }

    public By getUniqueLocator() {
        return uniqueLocator;
    }

    public void scrollToElement() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", WaitUtil.waitTimeout(uniqueLocator));
    }
}
