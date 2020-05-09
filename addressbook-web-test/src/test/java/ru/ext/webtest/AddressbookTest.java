package ru.ext.webtest;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AddressbookTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    openMainPage();
    login("admin", "secret");
  }

  private void openMainPage() {
    driver.get("http://localhost/addressbook/");
  }

  @Test
  public void groupCreationTestCase() throws Exception {
    openGroupPage();
    clickNewGroupButton();
    inputNewGroupInfo(new Group("template", "123", "456"));
    clickEnterInformationButton();
    returnToGroupPage();
  }

  @Test
  public void contactCreationTestCase() throws Exception {
    openContactCreationPage();
    inputNewContactData(new Contact("Martin", "Huaman", "Survey No. 13, DivyaSree Omega\nKondapur Village\nHyderabad, Telangana 500084", "+1 536 882747", "mail@incl.org", "alt@iftrc.com"));
    submitContactData();
    openMainPage();
  }

  private void submitContactData() {
    driver.findElement(By.name("submit")).click();
  }

  private void inputNewContactData(Contact contact) {
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

  private void openContactCreationPage() {
    driver.findElement(By.linkText("add new")).click();
  }

  private void returnToGroupPage() {
    driver.findElement(By.linkText("group page")).click();
  }

  private void clickEnterInformationButton() {
    driver.findElement(By.name("submit")).click();
  }

  private void inputNewGroupInfo(Group group) {
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

  private void clickNewGroupButton() {
    driver.findElement(By.name("new")).click();
  }

  private void openGroupPage() {
    driver.findElement(By.linkText("groups")).click();
  }

  private void login(String username, String password) {
    driver.findElement(By.name("user")).clear();
    driver.findElement(By.name("user")).sendKeys(username);
    driver.findElement(By.name("pass")).clear();
    driver.findElement(By.name("pass")).sendKeys(password);
    driver.findElement(By.id("LoginForm")).submit();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
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
