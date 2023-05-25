package org.tsegelnikova.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.tsegelnikova.base.BaseForm;
import org.tsegelnikova.config.BrowsersFactory;
import org.tsegelnikova.dto.User;
import org.tsegelnikova.elements.Button;

import java.util.List;
import java.util.stream.Collectors;

public class WebTables extends BaseForm {
    private static final String FORM_NAME = "Web Tables";
    private static final By LOCATOR = By.xpath("//*[@class='rt-tr-group']");
    private final Button addButton;
    private final WebDriver driver;

    public WebTables(WebDriver driver) {
        super(LOCATOR, FORM_NAME, driver);
        this.driver = driver;
        this.addButton = new Button(By.xpath("//*[@id='addNewRecordButton']"), "Add", driver);
    }

    public void clickAddButton() {
        addButton.scrollToElement();
        addButton.click();
    }

    public void clickDeleteUser(int number) {
        Button deleteUser = new Button(By.xpath("//*[@id='delete-record-" + number + "']/*"), "deleteUser", driver);
        deleteUser.scrollToElement();
        deleteUser.click();
    }

    public List<User> getListFromTable() {
        return BrowsersFactory.getDriver()
                .findElements(getUniqueLocator())
                .stream()
                .filter(element -> !element.getText().isBlank())
                .map(element -> {
                    List<WebElement> user = element.findElements(By.xpath("div//*"));
                    return new User(
                            user.get(0).getText(),
                            user.get(1).getText(),
                            user.get(3).getText(),
                            Long.valueOf(user.get(2).getText()),
                            Long.valueOf(user.get(4).getText()),
                            user.get(5).getText()
                    );
                })
                .collect(Collectors.toList());
    }
}
