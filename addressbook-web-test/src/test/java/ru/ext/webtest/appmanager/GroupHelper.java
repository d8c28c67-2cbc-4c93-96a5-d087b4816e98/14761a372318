package ru.ext.webtest.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.ext.webtest.model.Group;

public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver driver) {
        super(driver);
    }

    public void clickDeleteGroupButton() {
        click(By.xpath("(//input[@name='delete'])[2]"));
    }

    public void selectFirstGroup() {
        click(By.name("selected[]"));
    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    public void inputNewGroupInfo(Group group) {
        type(By.name("group_name"), group.getGroupName());
        type(By.name("group_header"), group.getGroupHeader());
        type(By.name("group_footer"), group.getGroupFooter());
    }

    public void clickEnterInformationButton() {
        click(By.name("submit"));
    }

    public void clickNewGroupButton() {
        click(By.name("new"));
    }
}
