package ru.ext.webtest.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper {
    private WebDriver driver;

    public NavigationHelper(WebDriver driver) {
        this.driver = driver;
    }


    public void openMainPage() {
      driver.get("http://localhost/addressbook/");
    }

    public void openContactCreationPage() {
      driver.findElement(By.linkText("add new")).click();
    }

    public void openGroupPage() {
      driver.findElement(By.linkText("groups")).click();
    }
}
