package org.tsegelnikova.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.tsegelnikova.base.BaseForm;
import org.tsegelnikova.elements.Button;
import org.tsegelnikova.util.WaitUtil;

public class AlertsPage extends BaseForm {
    private static final String FORM_NAME = "Alerts Page";
    private static final By LOCATOR = By.xpath("//*[@id='javascriptAlertsWrapper']");
    private final WebDriver driver;
    private final Button alerts;
    private final Button buttonConfirmBox;
    private final Button promptBox;

    public AlertsPage(WebDriver driver) {
        super(LOCATOR, FORM_NAME, driver);
        this.driver = driver;
        this.alerts = new Button(By.xpath("//*[@id='alertButton']"), "Alerts", driver);
        this.buttonConfirmBox = new Button(By.xpath("//*[@id='confirmButton']"), "Confirm box", driver);
        this.promptBox = new Button(By.xpath("//*[@id='promtButton']"), "Prompt box", driver);
    }

    public void clickButton() {
        WaitUtil.waitTimeout(alerts.getUniqueLocator());
        alerts.scrollToElement();
        alerts.click();
    }

    public void clickConfirm() {
        WaitUtil.waitTimeout(buttonConfirmBox.getUniqueLocator());
        buttonConfirmBox.scrollToElement();
        buttonConfirmBox.click();
    }

    public void clickPrompt() {
        WaitUtil.waitTimeout(promptBox.getUniqueLocator());
        promptBox.scrollToElement();
        promptBox.click();
    }

    public String getAlertText() {
        return driver.switchTo().alert().getText();
    }

    public void clickOkOnAlert() {
        driver.switchTo().alert().accept();
    }

    public String getTextFromConfirm() {
        return driver.findElement(By.xpath("//*[@id='confirmResult']")).getText();
    }

    public String getTextFromPromt() {
        return driver.findElement(By.xpath("//*[@id='promptResult']")).getText();
    }

    public void sentTextToAlert(String name) {
        driver.switchTo().alert().sendKeys(name);
    }
}
