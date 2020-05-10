package ru.ext.webtest;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AddressbookTest extends TestBase {

  @Test
  public void createGroup() throws Exception {
    openGroupPage();
    clickNewGroupButton();
    inputNewGroupInfo(new Group("template", "123", "456"));
    clickEnterInformationButton();
    returnToGroupPage();
  }

  @Test
  public void createContact() throws Exception {
    openContactCreationPage();
    inputNewContactData(new Contact("Martin", "Huaman", "Survey No. 13, DivyaSree Omega\nKondapur Village\nHyderabad, Telangana 500084", "+1 536 882747", "mail@incl.org", "alt@iftrc.com"));
    submitContactData();
    openMainPage();
  }

  @Test
  public void deleteGroup() {
    openGroupPage();
    selectFirstGroup();
    clickDeleteGroupButton();
    returnToGroupPage();
  }

  @Test
  public void deleteContact() {
    selectFirstContact();
    clickDeleteContactButton();
    confirmContactDeleteAlert();
  }

}
