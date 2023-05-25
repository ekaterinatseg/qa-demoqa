package org.tsegelnikova.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.tsegelnikova.base.BaseForm;

public class ChildNestedFrame extends BaseForm {
    private static final By LOCATOR = By.tagName("body");
    private static final String FORM_NAME = "Child Frame";
    private final WebDriver driver;

    public ChildNestedFrame(WebDriver driver) {
        super(LOCATOR, FORM_NAME, driver);
        this.driver = driver;
    }

    public String getTextFromChildNestedFrame() {
        driver.switchTo().frame(0);
        return driver.findElement(LOCATOR).getText();
    }

}
