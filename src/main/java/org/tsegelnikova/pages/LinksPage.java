package org.tsegelnikova.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.tsegelnikova.base.BaseForm;
import org.tsegelnikova.elements.Links;
import org.tsegelnikova.util.WaitUtil;

public class LinksPage extends BaseForm {
    private static final String FORM_NAME = "Links Page";
    private static final By LOCATOR = By.xpath("//*[@id='linkWrapper']");
    private final Links homeLink;

    public LinksPage(WebDriver driver) {
        super(LOCATOR, FORM_NAME, driver);
        this.homeLink = new Links(By.xpath("//*[@id='simpleLink']"), "Home link", driver);
    }

    public void clickHomeLink() {
        WaitUtil.waitTimeout(homeLink.getUniqueLocator());
        homeLink.click();
    }
}
