package org.tsegelnikova.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.tsegelnikova.base.BaseForm;
import org.tsegelnikova.elements.Button;
import org.tsegelnikova.elements.TextField;

public class RegistrationForm extends BaseForm {
    private static final String FORM_NAME = "Registration Form";
    private static final By LOCATOR = By.xpath("//*[@id='userForm']");
    private final TextField firstName;
    private final TextField lastName;
    private final TextField email;
    private final TextField age;
    private final TextField salary;
    private final TextField department;
    private final Button submitButton;

    public RegistrationForm(WebDriver driver) {
        super(LOCATOR, FORM_NAME, driver);

        this.firstName = new TextField(By.xpath("//*[@id='firstName']"), "First Name", driver);
        this.lastName = new TextField(By.xpath("//*[@id='lastName']"), "Last Name", driver);
        this.email = new TextField(By.xpath("//*[@id='userEmail']"), "Email", driver);
        this.age = new TextField(By.xpath("//*[@id='age']"), "Age", driver);
        this.salary = new TextField(By.xpath("//*[@id='salary']"), "Salary", driver);
        this.department = new TextField(By.xpath("//*[@id='department']"), "Department", driver);
        this.submitButton = new Button(By.xpath("//*[@id='submit']"), "Submit Button", driver);
    }

    public void sendStringToFirstName(String string) {
        firstName.sendStringByXpath(string);
    }

    public void sendStringToLastName(String string) {
        lastName.sendStringByXpath(string);
    }

    public void sendStringToEmail(String string) {
        email.sendStringByXpath(string);
    }

    public void sendStringToAge(String string) {
        age.sendStringByXpath(string);
    }

    public void sendStringToSalary(String string) {
        salary.sendStringByXpath(string);
    }

    public void sendStringToDepartment(String string) {
        department.sendStringByXpath(string);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }
}
