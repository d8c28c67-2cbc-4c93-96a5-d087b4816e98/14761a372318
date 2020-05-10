package ru.ext.webtest.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase{

    public SessionHelper(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        type(By.name("user"), username);
        type(By.name("pass"), password);
        submitForm(By.id("LoginForm"));
        try {
            Thread.sleep(1000);//ожидание прогрузки главной страницы после отправки формы
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}