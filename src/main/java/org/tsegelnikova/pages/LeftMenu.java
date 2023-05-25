package org.tsegelnikova.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.tsegelnikova.base.BaseForm;
import org.tsegelnikova.elements.Button;
import org.tsegelnikova.util.WaitUtil;

public class LeftMenu extends BaseForm {
    private static final String FORM_NAME = "Left Menu";
    private static final By LOCATOR = By.xpath("//*[@class='element-list collapse show']");
    private final Button alerts;
    private final Button nestedFrames;
    private final Button frames;
    private final Button browserWindows;
    private final Button elementsButton;
    private final Button linksButton;
    private final Button webTablesButton;

    public LeftMenu(WebDriver driver) {
        super(LOCATOR, FORM_NAME, driver);

        this.alerts = new Button(By.xpath("//*[@class='btn btn-light ']//*[text()='Alerts']"), "Alerts", driver);
        this.nestedFrames = new Button(By.xpath("//*[@class='btn btn-light ']//*[text()='Nested Frames']"), "Nested frames", driver);
        this.frames = new Button(By.xpath("//*[@class='btn btn-light ']//*[text()='Frames']"), "Frames", driver);
        this.browserWindows = new Button(By.xpath("//*[@class='btn btn-light ']//*[text()='Browser Windows']"), "Browser windows", driver);
        this.elementsButton = new Button(By.xpath("//*[@class='header-text'][contains(text(), 'Elements')]"), "Elements", driver);
        this.linksButton = new Button(By.xpath("//*[@id='item-5']"), "Links", driver);
        this.webTablesButton = new Button(By.xpath("//*[@id='item-3']"), "Web tables", driver);
    }

    public void clickAlertsButton() {
        WaitUtil.waitTimeout(alerts.getUniqueLocator());
        alerts.scrollToElement();
        alerts.click();
    }

    public void clickNestedFramesButton() {
        WaitUtil.waitTimeout(nestedFrames.getUniqueLocator());
        nestedFrames.scrollToElement();
        nestedFrames.click();
    }

    public void clickFramesButton() {
        WaitUtil.waitTimeout(frames.getUniqueLocator());
        frames.scrollToElement();
        frames.click();
    }

    public void clickBrowserWindowsButton() {
        WaitUtil.waitTimeout(browserWindows.getUniqueLocator());
        browserWindows.scrollToElement();
        browserWindows.click();
    }

    public void clickElementsButton() {
        elementsButton.click();
    }

    public void clickLinksButton() {
        WaitUtil.waitTimeout(linksButton.getUniqueLocator());
        linksButton.scrollToElement();
        linksButton.click();
    }

    public void clickWebTablesButton() {
        WaitUtil.waitTimeout(webTablesButton.getUniqueLocator());
        webTablesButton.scrollToElement();
        webTablesButton.click();
    }
}
