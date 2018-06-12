package me.savushkin.stargate.base.baseApp;

import me.savushkin.stargate.base.baseApp.helpers.SeleniumTest;
import me.savushkin.stargate.base.baseApp.page.LoginPage;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "server.port=8081", webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@SeleniumTest(driver = ChromeDriver.class, baseUrl = "http://localhost:8081/")
public class LoginPageTests {
    private final String USERNAME = "commander";
    private final String PASSWORD = "derparol";
    private final String URL = "http://localhost:8081/";
    @Autowired
    private WebDriver driver;
    WebDriverWait wait;
    private LoginPage loginPage;

    @Before
    public void setUp() throws Exception {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        wait = new WebDriverWait(driver, 30);
    }

    @Test
    public void successLoginTest() throws Exception {
//        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.get(URL+"login");
        wait.until((WebDriver d) ->
                d.findElement(By.cssSelector(".mat-card.login-card"))
        );

        loginPage.getUsernameInput().clear();
        loginPage.getUsernameInput().sendKeys(USERNAME);
        loginPage.getPassowrdInput().clear();
        loginPage.getPassowrdInput().sendKeys(PASSWORD);
        loginPage.getSubmitButton().click();

        wait.until((WebDriver d) ->
                d.findElement(By.cssSelector(".mat-card:not(.login-card)"))
        );
        assertTrue(loginPage.getTitle().getText().contains("commander"));
    }


    @Test
    public void faalseUsernameTest() throws Exception {
//        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.get(URL+"login");
        wait.until((WebDriver d) ->
                d.findElement(By.cssSelector(".mat-card.login-card"))
        );

        loginPage.getUsernameInput().clear();
        loginPage.getUsernameInput().sendKeys("2");
        loginPage.getPassowrdInput().clear();
        loginPage.getPassowrdInput().sendKeys(PASSWORD);
        loginPage.getSubmitButton().click();

        assertTrue(loginPage.getTitle().getText().contains("commander"));
    }

    @Test
    public void falsePasswordTest() throws Exception {
//        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.get(URL+"login");
        wait.until((WebDriver d) ->
                d.findElement(By.cssSelector(".mat-card.login-card"))
        );

        loginPage.getUsernameInput().clear();
        loginPage.getUsernameInput().sendKeys(USERNAME);
        loginPage.getPassowrdInput().clear();
        loginPage.getPassowrdInput().sendKeys("admin");
        loginPage.getSubmitButton().click();

        assertTrue(loginPage.getTitle().getText().contains("Авторизация"));    }

    @Test
    public void successLogoutTest() throws Exception {
//        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.get(URL+"logout");

        wait.until((WebDriver d) ->
                d.findElement(By.cssSelector(".mat-card.login-card"))
        );

        assertTrue(loginPage.getTitle().getText().contains("Авторизация"));

    }
}
