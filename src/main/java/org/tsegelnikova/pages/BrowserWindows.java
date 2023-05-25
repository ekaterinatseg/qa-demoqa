package org.tsegelnikova.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.tsegelnikova.base.BaseForm;
import org.tsegelnikova.elements.Button;

public class BrowserWindows extends BaseForm {
    private static final String FORM_NAME = "Browser Windows Page";
    private static final By LOCATOR = By.xpath("//*[@id='browserWindows']");
    private final Button newTab;

    public BrowserWindows(WebDriver driver) {
        super(LOCATOR, FORM_NAME, driver);
        this.newTab = new Button(By.xpath("//*[@id='tabButton']"), "New tab", driver);
    }

    public void clickNewTabButton() {
        newTab.scrollToElement();
        newTab.click();
    }
}
