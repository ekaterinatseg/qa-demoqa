package org.tsegelnikova;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.tsegelnikova.base.BaseTest;
import org.tsegelnikova.config.BrowsersFactory;
import org.tsegelnikova.pages.*;
import org.tsegelnikova.util.ParsingUtil;
import org.tsegelnikova.util.WaitUtil;

public class IframeTest extends BaseTest {
    @Test
    public void test() {
        MainPage alertsFrameWindowsButton = new MainPage(BrowsersFactory.getDriver());
        Assert.assertTrue(alertsFrameWindowsButton.isFormOpen(), "Form isn't open");
        alertsFrameWindowsButton.clickAlertsFrameButton();

        LeftMenu leftMenu = new LeftMenu(BrowsersFactory.getDriver());
        WaitUtil.waitTimeout(leftMenu.getUniqueLocator());
        Assert.assertTrue(leftMenu.isFormOpen(), "Form isn't open");

        leftMenu.clickNestedFramesButton();
        NestedFrames nestedFramesPage = new NestedFrames(BrowsersFactory.getDriver());
        ParentNestedFrame parentNestedFrame = new ParentNestedFrame(BrowsersFactory.getDriver());
        ChildNestedFrame childNestedFrame = new ChildNestedFrame(BrowsersFactory.getDriver());
        WaitUtil.waitTimeout(parentNestedFrame.getUniqueLocator());
        WaitUtil.waitFrame(nestedFramesPage.getUniqueLocator());
        Assert.assertEquals(childNestedFrame.getTextFromChildNestedFrame(), ParsingUtil.getTestData().getTextFromChildFrame(), "Text isn't correct");
        Assert.assertEquals(parentNestedFrame.getTextFromParentNestedFrame(), ParsingUtil.getTestData().getTextFromParentFrame(), "Text isn't correct");
        nestedFramesPage.switchToDefault();

        leftMenu.clickFramesButton();
        Frames frames = new Frames(BrowsersFactory.getDriver());
        Assert.assertTrue(frames.isFormOpen(), "Form isn't open");

        FrameFirst frameFirst = new FrameFirst(BrowsersFactory.getDriver());
        FrameSecond frameSecond = new FrameSecond(BrowsersFactory.getDriver());

        String textFromFrameFirst = frameFirst.getTextFromFirstFrame();
        frames.switchToDefault();
        String textFromFrameSecond = frameSecond.getTextFromSecondFrame();
        Assert.assertEquals(textFromFrameFirst, textFromFrameSecond, "Not equals");
        frames.switchToDefault();
    }
}
