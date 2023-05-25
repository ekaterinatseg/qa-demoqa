package org.tsegelnikova.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.tsegelnikova.base.BaseForm;
import org.tsegelnikova.elements.Button;

public class MainPage extends BaseForm {
    private static final String FORM_NAME = "Main Page";
    private static final By LOCATOR = By.xpath("//*[@class='card mt-4 top-card']");
    private final Button alertsFrameWindows;
    private final Button elements;

    public MainPage(WebDriver driver) {
        super(LOCATOR, FORM_NAME, driver);

        this.alertsFrameWindows = new Button(By.xpath("//*[@class='card mt-4 top-card']//*[text()='Alerts, Frame & Windows']"),
                "Alerts frame windows", driver);

        this.elements = new Button(By.xpath("//*[@class='card mt-4 top-card']//*[text()='Elements']"),
                "Elements", driver);
    }

    public void clickAlertsFrameButton() {
        alertsFrameWindows.scrollToElement();
        alertsFrameWindows.click();
    }

    public void clickElementsButton() {
        elements.scrollToElement();
        elements.click();
    }
}
