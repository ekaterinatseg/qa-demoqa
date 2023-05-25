package org.tsegelnikova.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.tsegelnikova.base.BaseForm;

public class Frames extends BaseForm {
    private static final String FORM_NAME = "Frames Page";
    private static final By LOCATOR = By.xpath("//*[@id='frame1Wrapper']");
    private final WebDriver driver;

    public Frames(WebDriver driver) {
        super(LOCATOR, FORM_NAME, driver);
        this.driver = driver;
    }

    public void switchToDefault() {
        driver.switchTo().defaultContent();
    }
}
