package org.tsegelnikova.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tsegelnikova.util.ParsingUtil;
import org.tsegelnikova.util.WaitUtil;

public abstract class BaseForm {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseForm.class);
    private final By uniqueFormLocator;
    private final String formName;
    private final WebDriver driver;

    public BaseForm(By uniqueFormLocator, String formName, WebDriver driver) {
        WaitUtil.waitTimeout(uniqueFormLocator, ParsingUtil.getConfig().getStandardWaitTimeout());
        this.uniqueFormLocator = uniqueFormLocator;
        this.formName = formName;
        this.driver = driver;
    }

    public boolean isFormOpen() {
        LOGGER.info("{} is opening", formName);
        return !driver.findElements(uniqueFormLocator).isEmpty() &&
                driver.findElement(uniqueFormLocator).isDisplayed();
    }

    public By getUniqueLocator() {
        return uniqueFormLocator;
    }
}
