package ru.ext.webtest.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.ext.webtest.model.Contact;
import ru.ext.webtest.model.Group;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

public class ApplicationManager {
    private WebDriver driver;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    public void init() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        openMainPage();
        login("admin", "secret");
    }

    public void openMainPage() {
      driver.get("http://localhost/addressbook/");
    }

    public void clickDeleteGroupButton() {
      driver.findElement(By.xpath("(//input[@name='delete'])[2]")).click();
    }

    public void selectFirstGroup() {
      driver.findElement(By.name("selected[]")).click();
    }

    public void confirmContactDeleteAlert() {
      assertTrue(closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));
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

    public void openContactCreationPage() {
      driver.findElement(By.linkText("add new")).click();
    }

    public void returnToGroupPage() {
      driver.findElement(By.linkText("group page")).click();
    }

    public void clickEnterInformationButton() {
      driver.findElement(By.name("submit")).click();
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

    public void clickNewGroupButton() {
      driver.findElement(By.name("new")).click();
    }

    public void openGroupPage() {
      driver.findElement(By.linkText("groups")).click();
    }

    public void login(String username, String password) {
      driver.findElement(By.name("user")).clear();
      driver.findElement(By.name("user")).sendKeys(username);
      driver.findElement(By.name("pass")).clear();
      driver.findElement(By.name("pass")).sendKeys(password);
      driver.findElement(By.id("LoginForm")).submit();
        try {
            Thread.sleep(500);//ожидание прогрузки главной страницы после отправки формы
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
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
