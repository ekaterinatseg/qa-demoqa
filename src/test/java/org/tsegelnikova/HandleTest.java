package org.tsegelnikova;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.tsegelnikova.base.BaseTest;
import org.tsegelnikova.config.BrowsersFactory;
import org.tsegelnikova.pages.*;
import org.tsegelnikova.util.BrowserUtil;
import org.tsegelnikova.util.WaitUtil;

public class HandleTest extends BaseTest {
    @Test
    public void test() {
        MainPage alertsFrameWindowsButton = new MainPage(BrowsersFactory.getDriver());
        Assert.assertTrue(alertsFrameWindowsButton.isFormOpen(), "Form isn't open");
        alertsFrameWindowsButton.clickAlertsFrameButton();

        LeftMenu leftMenu = new LeftMenu(BrowsersFactory.getDriver());
        WaitUtil.waitTimeout(leftMenu.getUniqueLocator());
        leftMenu.clickBrowserWindowsButton();

        BrowserWindows browserWindowsPage = new BrowserWindows(BrowsersFactory.getDriver());
        WaitUtil.waitTimeout(browserWindowsPage.getUniqueLocator());
        Assert.assertTrue(browserWindowsPage.isFormOpen(), "Form isn't open");
        browserWindowsPage.clickNewTabButton();
        WaitUtil.waitTabTargetCount(2);
        BrowserUtil.switchTab(1);
        SamplePage samplePage = new SamplePage(BrowsersFactory.getDriver());
        WaitUtil.waitTimeout(samplePage.getUniqueLocator());
        Assert.assertTrue(samplePage.isFormOpen(), "Form isn't open");
        BrowserUtil.closeTab(1);
        BrowserUtil.switchTab(0);
        Assert.assertTrue(browserWindowsPage.isFormOpen(), "Form isn't open");

        leftMenu.clickElementsButton();
        leftMenu.clickLinksButton();

        LinksPage linksPage = new LinksPage(BrowsersFactory.getDriver());
        WaitUtil.waitTimeout(linksPage.getUniqueLocator());
        Assert.assertTrue(linksPage.isFormOpen(), "Form isn't open");
        linksPage.clickHomeLink();
        WaitUtil.waitTabTargetCount(2);
        BrowserUtil.switchTab(1);
        Assert.assertTrue(alertsFrameWindowsButton.isFormOpen(), "Form isn't open");
        BrowserUtil.closeTab(1);
        BrowserUtil.switchTab(0);
        Assert.assertTrue(linksPage.isFormOpen(), "Form isn't open");
    }
}
