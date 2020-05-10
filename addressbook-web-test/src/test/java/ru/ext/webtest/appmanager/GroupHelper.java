package ru.ext.webtest.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.ext.webtest.model.Group;

public class GroupHelper {
    private WebDriver driver;
    public GroupHelper() {
    }

    public GroupHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void clickDeleteGroupButton() {
      driver.findElement(By.xpath("(//input[@name='delete'])[2]")).click();
    }

    public void selectFirstGroup() {
      driver.findElement(By.name("selected[]")).click();
    }

    public void returnToGroupPage() {
      driver.findElement(By.linkText("group page")).click();
    }

    public void inputNewGroupInfo(Group group) {
      driver.findElement(By.name("group_name")).click();
      driver.findElement(By.name("group_name")).clear();
      driver.findElement(By.name("group_name")).sendKeys(group.getGroupName());
      driver.findElement(By.name("group_header")).click();
      driver.findElement(By.name("group_header")).clear();
      driver.findElement(By.name("group_header")).sendKeys(group.getGroupHeader());
      driver.findElement(By.name("group_footer")).click();
      driver.findElement(By.name("group_footer")).clear();
      driver.findElement(By.name("group_footer")).sendKeys(group.getGroupFooter());
    }

    public void clickEnterInformationButton() {
        driver.findElement(By.name("submit")).click();
    }

    public void clickNewGroupButton() {
      driver.findElement(By.name("new")).click();
    }
}
