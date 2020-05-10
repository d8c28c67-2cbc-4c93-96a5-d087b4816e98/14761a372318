package ru.ext.webtest.tests;

import org.testng.annotations.*;
import ru.ext.webtest.model.Contact;
import ru.ext.webtest.model.Group;

public class AddressbookTest extends TestBase {

  @Test
  public void createGroup() throws Exception {
    app.getNavigationHelper().openMainPage();
    app.getNavigationHelper().openGroupPage();
    app.getGroupHelper().clickNewGroupButton();
    app.getGroupHelper().inputNewGroupInfo(new Group("template", "123", "456"));
    app.getGroupHelper().clickEnterInformationButton();
    app.getGroupHelper().returnToGroupPage();
  }

  @Test
  public void createContact() throws Exception {
    app.getNavigationHelper().openMainPage();
    app.getNavigationHelper().openContactCreationPage();
    app.getContactHelper().inputNewContactData(new Contact("Martin", "Huaman", "Survey No. 13, DivyaSree Omega\nKondapur Village\nHyderabad, Telangana 500084", "+1 536 882747", "mail@incl.org", "alt@iftrc.com"));
    app.getContactHelper().submitContactData();
    app.getNavigationHelper().openMainPage();
  }

  @Test
  public void deleteGroup() {
    app.getNavigationHelper().openMainPage();
    app.getNavigationHelper().openGroupPage();
    app.getGroupHelper().selectFirstGroup();
    app.getGroupHelper().clickDeleteGroupButton();
    app.getGroupHelper().returnToGroupPage();
  }

  @Test
  public void deleteContact() {
    app.getNavigationHelper().openMainPage();
    app.getContactHelper().selectFirstContact();
    app.getContactHelper().clickDeleteContactButton();
    app.getContactHelper().confirmContactDeleteAlert();
  }

}
