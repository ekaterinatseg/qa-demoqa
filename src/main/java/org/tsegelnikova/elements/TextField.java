package org.tsegelnikova.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.tsegelnikova.base.BaseElement;
import org.tsegelnikova.config.BrowsersFactory;
import org.tsegelnikova.util.WaitUtil;

public class TextField extends BaseElement {
    public TextField(By uniqueLocator, String elementName, WebDriver driver) {
        super(uniqueLocator, elementName, driver);
    }

    public void sendStringByXpath(String value) {
        WaitUtil.waitTimeout(this.getUniqueLocator());
        BrowsersFactory.getDriver().findElement(this.getUniqueLocator()).sendKeys(value);
    }
}
