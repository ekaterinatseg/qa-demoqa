package org.tsegelnikova;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.tsegelnikova.base.BaseTest;
import org.tsegelnikova.config.BrowsersFactory;
import org.tsegelnikova.pages.AlertsPage;
import org.tsegelnikova.pages.LeftMenu;
import org.tsegelnikova.pages.MainPage;
import org.tsegelnikova.util.WaitUtil;

import java.util.UUID;

public class AlertTest extends BaseTest {
    @Test
    public void test() {
        MainPage alertsFrameWindowsButton = new MainPage(BrowsersFactory.getDriver());
        Assert.assertTrue(alertsFrameWindowsButton.isFormOpen(), "Form isn't open");

        alertsFrameWindowsButton.clickAlertsFrameButton();

        LeftMenu leftMenu = new LeftMenu(BrowsersFactory.getDriver());
        WaitUtil.waitTimeout(leftMenu.getUniqueLocator());
        leftMenu.clickAlertsButton();
        AlertsPage alertsPage = new AlertsPage(BrowsersFactory.getDriver());
        WaitUtil.waitTimeout(alertsPage.getUniqueLocator());
        Assert.assertTrue(alertsPage.isFormOpen(), "Form isn't open");

        alertsPage.clickButton();
        Assert.assertEquals(alertsPage.getAlertText(), "You clicked a button", "Text isn't correct");
        alertsPage.clickOkOnAlert();

        alertsPage.clickConfirm();
        Assert.assertEquals(alertsPage.getAlertText(), "Do you confirm action?", "Text isn't correct");
        alertsPage.clickOkOnAlert();
        Assert.assertEquals(alertsPage.getTextFromConfirm(), "You selected Ok", "Text isn't correct");

        WaitUtil.waitTimeout(alertsPage.getUniqueLocator());
        alertsPage.clickPrompt();
        Assert.assertEquals(alertsPage.getAlertText(), "Please enter your name", "Text isn't correct");
        String randomString = UUID.randomUUID().toString();
        alertsPage.sentTextToAlert(randomString);
        alertsPage.clickOkOnAlert();
        Assert.assertEquals(alertsPage.getTextFromPromt(), "You entered " + randomString, "Text isn't correct");
    }
}
