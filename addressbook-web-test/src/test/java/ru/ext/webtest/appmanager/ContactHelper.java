package ru.ext.webtest.appmanager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ru.ext.webtest.model.Contact;

public class ContactHelper {
    private WebDriver driver;
    private boolean acceptNextAlert = true;

    public ContactHelper(WebDriver driver) {

        this.driver = driver;
    }

    public void confirmContactDeleteAlert() {
        Assert.assertTrue(closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));
    }

    public void clickDeleteContactButton() {
        driver.findElement(By.xpath("//input[@value='Delete']")).click();
    }

    public void selectFirstContact() {
        driver.findElement(By.xpath("//table[@id='maintable']/tbody/tr[2]/td/input")).click();
    }

    public void submitContactData() {
        driver.findElement(By.name("submit")).click();
    }

    public void inputNewContactData(Contact contact) {
        driver.findElement(By.name("firstname")).click();
        driver.findElement(By.name("firstname")).clear();
        driver.findElement(By.name("firstname")).sendKeys(contact.getFirstname());
        driver.findElement(By.name("lastname")).click();
        driver.findElement(By.name("lastname")).clear();
        driver.findElement(By.name("lastname")).sendKeys(contact.getLastname());
        driver.findElement(By.name("address")).click();
        driver.findElement(By.name("address")).clear();
        driver.findElement(By.name("address")).sendKeys(contact.getAddress());
        driver.findElement(By.name("mobile")).click();
        driver.findElement(By.name("home")).click();
        driver.findElement(By.name("home")).click();
        driver.findElement(By.name("home")).clear();
        driver.findElement(By.name("home")).sendKeys(contact.getHomePhoneNumber());
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys(contact.getEmail1());
        driver.findElement(By.name("email2")).click();
        driver.findElement(By.name("email2")).clear();
        driver.findElement(By.name("email2")).sendKeys(contact.getEmail2());
        driver.findElement(By.name("theform")).click();
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}