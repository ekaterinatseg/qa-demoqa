package org.tsegelnikova.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.tsegelnikova.base.BaseForm;

public class SamplePage extends BaseForm {
    private static final String FORM_NAME = "Sample Page";
    private static final By LOCATOR = By.xpath("//*[@id='sampleHeading']");

    public SamplePage(WebDriver driver) {
        super(LOCATOR, FORM_NAME, driver);
    }
}
