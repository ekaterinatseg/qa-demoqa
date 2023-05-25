package org.tsegelnikova.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.tsegelnikova.base.BaseElement;

public class Links extends BaseElement {

    public Links(By uniqueLocator, String elementName, WebDriver driver) {
        super(uniqueLocator, elementName, driver);
    }
}
