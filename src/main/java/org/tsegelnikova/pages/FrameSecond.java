package org.tsegelnikova.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.tsegelnikova.base.BaseForm;

public class FrameSecond extends BaseForm {
    private static final String FORM_NAME = "Frame Second";
    private static final By LOCATOR = By.id("frame2");
    private final WebDriver driver;

    public FrameSecond(WebDriver driver) {
        super(LOCATOR, FORM_NAME, driver);
        this.driver = driver;
    }

    public String getTextFromSecondFrame() {
        driver.switchTo().frame("frame2");
        return driver.findElement(By.tagName("body")).getText();
    }
}
