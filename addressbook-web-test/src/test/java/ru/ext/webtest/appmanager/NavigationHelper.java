package ru.ext.webtest.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase{

    public NavigationHelper(WebDriver driver) {
        super(driver);
    }


    public void openMainPage() {
      driver.get("http://localhost/addressbook/");
    }

    public void openContactCreationPage() {
      click(By.linkText("add new"));
    }

    public void openGroupPage() {
      click(By.linkText("groups"));
    }
}
