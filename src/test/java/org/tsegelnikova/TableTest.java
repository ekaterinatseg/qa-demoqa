package org.tsegelnikova;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.tsegelnikova.base.BaseTest;
import org.tsegelnikova.config.BrowsersFactory;
import org.tsegelnikova.dto.User;
import org.tsegelnikova.pages.*;
import org.tsegelnikova.util.WaitUtil;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class TableTest extends BaseTest {
    @Test(dataProvider = "users")
    public void tablesTest(User user) {
        MainPage elementsMainPageButton = new MainPage(BrowsersFactory.getDriver());
        Assert.assertTrue(elementsMainPageButton.isFormOpen(), "Form isn't open");

        elementsMainPageButton.clickElementsButton();

        LeftMenu leftMenu = new LeftMenu(BrowsersFactory.getDriver());

        WaitUtil.waitTimeout(leftMenu.getUniqueLocator());
        leftMenu.clickWebTablesButton();
        WebTables webTables = new WebTables(BrowsersFactory.getDriver());
        Assert.assertTrue(webTables.isFormOpen(), "Form isn't open");

        List<User> originsUsers = webTables.getListFromTable();

        webTables.clickAddButton();
        RegistrationForm registrationForm = new RegistrationForm(BrowsersFactory.getDriver());
        Assert.assertTrue(registrationForm.isFormOpen(), "Form isn't open");

        registrationForm.sendStringToFirstName(user.getFirstName());
        registrationForm.sendStringToLastName(user.getLastName());
        registrationForm.sendStringToEmail(user.getEmail());
        registrationForm.sendStringToAge(user.getAge().toString());
        registrationForm.sendStringToSalary(user.getSalary().toString());
        registrationForm.sendStringToDepartment(user.getDepartment());

        registrationForm.clickSubmitButton();

        WaitUtil.waitUntilInvisibility(registrationForm.getUniqueLocator(), 30);
        Assert.assertFalse(registrationForm.isFormOpen(), "Form is open");

        List<User> afterAdd = webTables.getListFromTable();
        Assert.assertEquals(afterAdd.get(afterAdd.size() - 1), user);
        webTables.clickDeleteUser(afterAdd.size());

        List<User> afterRemove = webTables.getListFromTable();
        Assert.assertEquals(afterRemove.size(), originsUsers.size());

    }

    @DataProvider(name = "users")
    public Object[][] dpMethod() throws IOException, URISyntaxException {
        List<User> regularUsersJson = User.getUsersFromJson("users.json");

        return regularUsersJson
                .stream()
                .map(student -> new Object[]{student})
                .toArray(Object[][]::new);
    }
}
