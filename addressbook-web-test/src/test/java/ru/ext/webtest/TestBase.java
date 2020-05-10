package ru.ext.webtest;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

public class TestBase {
    private WebDriver driver;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
      driver = new FirefoxDriver();
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

      openMainPage();
      login("admin", "secret");
    }

    protected void openMainPage() {
      driver.get("http://localhost/addressbook/");
    }

    protected void clickDeleteGroupButton() {
      driver.findElement(By.xpath("(//input[@name='delete'])[2]")).click();
    }

    protected void selectFirstGroup() {
      driver.findElement(By.name("selected[]")).click();
    }

    protected void confirmContactDeleteAlert() {
      assertTrue(closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));
    }

    protected void clickDeleteContactButton() {
      driver.findElement(By.xpath("//input[@value='Delete']")).click();
    }

    protected void selectFirstContact() {
      driver.findElement(By.xpath("//table[@id='maintable']/tbody/tr[2]/td/input")).click();
    }

    protected void submitContactData() {
      driver.findElement(By.name("submit")).click();
    }

    protected void inputNewContactData(Contact contact) {
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

    protected void openContactCreationPage() {
      driver.findElement(By.linkText("add new")).click();
    }

    protected void returnToGroupPage() {
      driver.findElement(By.linkText("group page")).click();
    }

    protected void clickEnterInformationButton() {
      driver.findElement(By.name("submit")).click();
    }

    protected void inputNewGroupInfo(Group group) {
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

    protected void clickNewGroupButton() {
      driver.findElement(By.name("new")).click();
    }

    protected void openGroupPage() {
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
