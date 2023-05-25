package org.tsegelnikova.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.tsegelnikova.base.BaseForm;

public class NestedFrames extends BaseForm {
    private static final String FORM_NAME = "Nested Frames Page";
    private static final By LOCATOR = By.xpath("//*[@id='frame1']");
    private final WebDriver driver;

    public NestedFrames(WebDriver driver) {
        super(LOCATOR, FORM_NAME, driver);
        this.driver = driver;
    }

    public void switchToDefault() {
        driver.switchTo().defaultContent();
    }
}
