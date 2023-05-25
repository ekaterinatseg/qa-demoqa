package org.tsegelnikova.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.tsegelnikova.base.BaseForm;

public class ParentNestedFrame extends BaseForm {
    private static final String FORM_NAME = "Parent Frame";
    private static final By LOCATOR = By.tagName("body");
    private final WebDriver driver;

    public ParentNestedFrame(WebDriver driver) {
        super(LOCATOR, FORM_NAME, driver);
        this.driver = driver;
    }

    public String getTextFromParentNestedFrame() {
        driver.switchTo().parentFrame();
        return driver.findElement(By.tagName("body")).getText();
    }
}
