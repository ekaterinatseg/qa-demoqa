package org.tsegelnikova.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.tsegelnikova.base.BaseForm;

public class FrameFirst extends BaseForm {
    private static final String FORM_NAME = "Frame First";
    private static final By LOCATOR = By.id("frame1");
    private final WebDriver driver;

    public FrameFirst(WebDriver driver) {
        super(LOCATOR, FORM_NAME, driver);
        this.driver = driver;
    }

    public String getTextFromFirstFrame() {
        driver.switchTo().frame("frame1");
        return driver.findElement(By.tagName("body")).getText();
    }
}
