package ru.ext.webtest.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ru.ext.webtest.model.Contact;

public class ContactHelper extends HelperBase{

    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void confirmContactDeleteAlert() {
        Assert.assertTrue(closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));
    }

    public void clickDeleteContactButton() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void selectFirstContact() {
        click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td/input"));
    }

    public void submitContactData() {
        click(By.name("submit"));
    }

    public void inputNewContactData(Contact contact) {
        type(By.name("firstname"), contact.getFirstname());
        type(By.name("lastname"), contact.getLastname());
        type(By.name("address"), contact.getAddress());
        type(By.name("home"), contact.getHomePhoneNumber());
        type(By.name("email"), contact.getEmail1());
        type(By.name("email2"), contact.getEmail2());
        click(By.name("theform"));
    }

}