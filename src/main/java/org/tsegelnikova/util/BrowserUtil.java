package org.tsegelnikova.util;

import org.tsegelnikova.config.BrowsersFactory;

import java.util.ArrayList;
import java.util.List;

public class BrowserUtil {
    private BrowserUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static void switchTab(int numberOfTab) {
        List<String> browserTabs = new ArrayList<>(BrowsersFactory.getDriver().getWindowHandles());
        BrowsersFactory.getDriver().switchTo().window(browserTabs.get(numberOfTab));
    }

    public static void closeTab(int numberOfTab) {
        List<String> browserTabs = new ArrayList<>(BrowsersFactory.getDriver().getWindowHandles());
        BrowsersFactory.getDriver().switchTo().window(browserTabs.get(numberOfTab)).close();
    }
}
