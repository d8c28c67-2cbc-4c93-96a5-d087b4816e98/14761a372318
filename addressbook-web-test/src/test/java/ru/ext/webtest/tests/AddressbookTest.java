package ru.ext.webtest.tests;

import org.testng.annotations.*;
import ru.ext.webtest.model.Contact;
import ru.ext.webtest.model.Group;

public class AddressbookTest extends TestBase {

  @Test
  public void createGroup() throws Exception {
    app.openMainPage();
    app.openGroupPage();
    app.clickNewGroupButton();
    app.inputNewGroupInfo(new Group("template", "123", "456"));
    app.clickEnterInformationButton();
    app.returnToGroupPage();
  }

  @Test
  public void createContact() throws Exception {
    app.openMainPage();
    app.openContactCreationPage();
    app.inputNewContactData(new Contact("Martin", "Huaman", "Survey No. 13, DivyaSree Omega\nKondapur Village\nHyderabad, Telangana 500084", "+1 536 882747", "mail@incl.org", "alt@iftrc.com"));
    app.submitContactData();
    app.openMainPage();
  }

  @Test
  public void deleteGroup() {
    app.openMainPage();
    app.openGroupPage();
    app.selectFirstGroup();
    app.clickDeleteGroupButton();
    app.returnToGroupPage();
  }

  @Test
  public void deleteContact() {
    app.openMainPage();
    app.selectFirstContact();
    app.clickDeleteContactButton();
    app.confirmContactDeleteAlert();
  }

}
